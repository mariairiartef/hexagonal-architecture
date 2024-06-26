package api;

import api.models.CreateCampaignRequest;
import api.models.CreateCampaignResponse;

import api.mappers.CampaignMapper;

import api.models.SearchCampaignByIdQuery;
import api.models.SearchCampaignByIdResponse;
import domain.ports.ingoing.CreateCampaignUseCase;

import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

public class CampaignController {
    private CampaignMapper campaignMapper;
    private CreateCampaignUseCase createCampaignUseCase;

     // POST /campaigns
    CreateCampaignResponse createCampaign(CreateCampaignRequest createCampaignRequest) {
        CreateCampaignCommand createCampaignCommand = campaignMapper.mapCreateCampaignRequestToCreateCampaignCommand(createCampaignRequest);
        CreateCampaignResult createCampaignResult = createCampaignUseCase.execute(createCampaignCommand);
        return campaignMapper.mapCreateCampaignResultToCreateCampaignResponse(createCampaignResult);
    }

    // GET /campaigns/id=?
    SearchCampaignByIdResponse searchCampaignById(SearchCampaignByIdQuery searchCampaignByIdQuery) {
        SearchCampaignByIdCommand searchCampaignByIdCommand = campaignMapper.mapSearchCampaignByIdQueryToSearchCampaignByIdCommand(searchCampaignByIdQuery);
        SearchCampaignByIdResult searchCampaignByIdResult = SearchCampaignByIdUseCase.execute(searchCampaignByIdCommand);
        return campaignMapper.mapSearchCampaignByIdResultToSearchCampaignByIdResponse(searchCampaignByIdResult);
    }
}
