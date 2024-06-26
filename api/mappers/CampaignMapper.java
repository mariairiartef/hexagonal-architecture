package api.mappers;

import api.models.CreateCampaignRequest;
import api.models.CreateCampaignResponse;
import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

public class CampaignMapper {
    public CreateCampaignCommand mapCreateCampaignRequestToCreateCampaignCommand(CreateCampaignRequest createCampaignRequest) {
        return new CreateCampaignCommand();
    }

    public CreateCampaignResponse mapCreateCampaignResultToCreateCampaignResponse(CreateCampaignResult createCampaignResult) {
        return new CreateCampaignResponse("A", "B", 1L);
    }

    public SearchCampaignByIdCommand mapSearchCampaignByIdQueryToSearchCampaignByIdCommand(SearchCampaignByIdQuery searchCampaignByIdQuery) {
        return new SearchCampaignByIdCommand();
    }
}
