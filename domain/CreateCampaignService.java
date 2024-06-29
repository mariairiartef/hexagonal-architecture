package domain;

import domain.mappers.CreateCampaignMapper;
import domain.models.Campaign;
import domain.ports.ingoing.CreateCampaignUseCase;
import domain.ports.outgoing.AdServerClient;
import domain.ports.outgoing.CampaignRepository;

/**
 * Duda: en este caso, implementamos directamente el caso de uso definido en el dominio?
 */
public class CreateCampaignService implements CreateCampaignUseCase {
    private CreateCampaignMapper createCampaignMapper;

    private CampaignRepository campaignRepository;
    private AdServerClient adServerClient;

    /**
     * Executes the process of creating a campaign. This involves several steps:
     *  1. Validates the fields of the createCampaignCommand. This should be done in the domain layer
     *  2. Maps the command to our domain object (Campaign).
     *  3. Uses the repository to create a campaign in the database.
     *  4. Sends the created campaign to the Ad server.
     *  5. Returns the result of the campaign creation process.
     *
     * @param createCampaignCommand An object that encapsulates all the necessary data to create a campaign. This includes details like campaign name, daily budget, etc.
     * @return CreateCampaignResult An object that encapsulates the result of the campaign creation process. This includes the newly created campaign's details.
     * @throws Exception If there's an error during the campaign creation process, such as validation failure or issues with database or Ad server communication.
     */
    @Override
    public CreateCampaignResult execute(CreateCampaignCommand createCampaignCommand) throws Exception {
        // We should validate fields in the domain (business logic)
        // Validate createCampaignCommand
        validateDailyBudget(createCampaignCommand);

        // This is my domain object
        Campaign campaignToCreate = createCampaignMapper.mapCreateCampaignCommandToCampaign(createCampaignCommand);
        Campaign campaign;
        try {
            // 1. Save campaign in database
            campaign = campaignRepository.createCampaign(campaignToCreate);
            // 2. Send campaign to Ad Server
            adServerClient.sendCampaign(campaignToCreate);
        } catch (Exception e) {
            throw new Exception("Error creating a campaign");
        }
        return  createCampaignMapper.mapCampaignToCreateCampaignResult(campaign);
    }

    private void validateDailyBudget(CreateCampaignCommand createCampaignCommand) throws Exception{
        var dailyBudget = createCampaignCommand.dailyBudget();
        if (dailyBudget == null ||dailyBudget < 10L) {
            throw new Exception("Daily budget must be greater that a certain amount");
        }
    }
}
