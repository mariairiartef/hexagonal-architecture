package domain;

import domain.mappers.CreateCampaignMapper;
import domain.models.Campaign;
import domain.ports.ingoing.CreateCampaignUseCase;
import domain.ports.outgoing.AdServerClient;
import domain.ports.outgoing.CampaignRepository;

public class CreateCampaignService implements CreateCampaignUseCase {
    private CreateCampaignMapper createCampaignMapper;

    private CampaignRepository campaignRepository;
    private AdServerClient adServerClient;

    @Override
    public CreateCampaignResult execute(CreateCampaignCommand createCampaignCommand) {
        // We should validate fields in the domain (business logic)
        // Validate createCampaignCommand

        // This is my domain object
        Campaign campaignToCreate = createCampaignMapper.mapCreateCampaignCommandToCampaign(createCampaignCommand);
        Campaign campaign;
        try {
            // 1. Save campaign in database
            campaign = campaignRepository.createCampaign(campaignToCreate);
            // 2. Send campaign to Ad Server
            adServerClient.sendCampaign(campaignToCreate);
        } catch (Exception e) {
            throw e;
        }
        return  createCampaignMapper.mapCampaignToCreateCampaignResult(campaign);
    }
}
