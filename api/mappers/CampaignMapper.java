package api.mappers;

import api.models.CreateCampaignRequest;
import api.models.CreateCampaignResponse;
import api.models.SearchCampaignByIdQuery;

// Note: From the API layer, we import from the domain

import api.models.SearchCampaignByIdResponse;
import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

import domain.SearchCampaignByIdCommand;
import domain.SearchCampaignByIdResult;

public class CampaignMapper {
    public CreateCampaignCommand mapCreateCampaignRequestToCreateCampaignCommand(CreateCampaignRequest createCampaignRequest) {
        return new CreateCampaignCommand(createCampaignRequest.id(), createCampaignRequest.storeId(), createCampaignRequest.dailyBudget());
    }

    public CreateCampaignResponse mapCreateCampaignResultToCreateCampaignResponse(CreateCampaignResult createCampaignResult) {
        return new CreateCampaignResponse(createCampaignResult.id(), createCampaignResult.storeId(), createCampaignResult.dailyBudget());
    }

    public SearchCampaignByIdCommand mapSearchCampaignByIdQueryToSearchCampaignByIdCommand(SearchCampaignByIdQuery searchCampaignByIdQuery) {
        return new SearchCampaignByIdCommand(searchCampaignByIdQuery.id());
    }

    public SearchCampaignByIdResponse mapSearchCampaignByIdResultToSearchCampaignByIdResponse(SearchCampaignByIdResult searchCampaignByIdResult) {
        return new SearchCampaignByIdResponse(
                searchCampaignByIdResult.campaignId(),
                searchCampaignByIdResult.storeId(),
                searchCampaignByIdResult.dailyBudget(),
                searchCampaignByIdResult.clicks()
        );
    }
}
