package domain;

import domain.mappers.SearchCampaignByIdMapper;
import domain.models.Campaign;
import domain.models.Performance;
import domain.ports.ingoing.SearchCampaignByIdUseCase;
import domain.ports.outgoing.AdServerClient;
import domain.ports.outgoing.CampaignRepository;

public class SearchCampaignByIdService implements SearchCampaignByIdUseCase {
    private CampaignRepository campaignRepository;
    private AdServerClient adServerClient;

    private SearchCampaignByIdMapper searchCampaignByIdMapper;

    /**
     * Executes the process of searching a campaign using an ID. This process involves several steps:
     *  1. Validates the command to ensure the campaign ID is present and valid.
     *  2. Queries the campaign repository to retrieve the campaign with the specified ID.
     *  3. Asks the ad server client the performance data for that campaign.
     *  4. Combines the campaign data and performance into a result object and returns it.
     *
     * @param searchCampaignByIdCommand An object that encapsulates the ID of the campaign to be searched. This command object is expected to contain a valid campaign ID.
     * @return SearchCampaignByIdResult An object that encapsulates the result of the search operation. This includes the campaign data and its associated performance data.
     * @throws Exception If there's an issue during the search operation, such as an invalid campaign ID, failure to retrieve campaign data, or failure to retrieve performance data.
     */
    @Override
    public SearchCampaignByIdResult execute(SearchCampaignByIdCommand searchCampaignByIdCommand) throws Exception {
        // Validate the searchCampaignByIdCommand
        validateCampaignId(searchCampaignByIdCommand);

        Campaign campaign;
        Performance performance;
        try {
            campaign = campaignRepository.searchCampaignById(searchCampaignByIdCommand.id());
            performance = adServerClient.getCampaignPerformance(searchCampaignByIdCommand.id());
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
        return searchCampaignByIdMapper.mapCampaignAndPerformanceToSearchCampaignIdResult(campaign, performance);
    }

    private void validateCampaignId(SearchCampaignByIdCommand searchCampaignByIdCommand) throws Exception {
        if (searchCampaignByIdCommand.id() == null) {
            throw new Exception("This is not a valid ID for a campaign");
        }
    }
}
