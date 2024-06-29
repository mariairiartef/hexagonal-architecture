package api;

import api.models.CreateCampaignRequest;
import api.models.CreateCampaignResponse;

import api.mappers.CampaignMapper;

import api.models.SearchCampaignByIdQuery;
import api.models.SearchCampaignByIdResponse;
import domain.SearchCampaignByIdCommand;
import domain.SearchCampaignByIdResult;
import domain.ports.ingoing.CreateCampaignUseCase;
import domain.ports.ingoing.SearchCampaignByIdUseCase;

import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;


public class CampaignController {
    private CampaignMapper campaignMapper;
    private CreateCampaignUseCase createCampaignUseCase;
    private SearchCampaignByIdUseCase searchCampaignByIdUseCase;

     // POST /campaigns
    public CreateCampaignResponse createCampaign(CreateCampaignRequest createCampaignRequest) throws Exception {
        // In first place, we map the request to the command.
        // The command is what is going to be received by the use case
        CreateCampaignCommand createCampaignCommand = campaignMapper.mapCreateCampaignRequestToCreateCampaignCommand(createCampaignRequest);
        // It is not necessary to implement the use case, we use it directly
        CreateCampaignResult createCampaignResult = createCampaignUseCase.execute(createCampaignCommand);
        // Once we have the result for the use case, we map it to the response we want to return
        return campaignMapper.mapCreateCampaignResultToCreateCampaignResponse(createCampaignResult);
    }

    // GET /campaigns/id=?
    public SearchCampaignByIdResponse searchCampaignById(SearchCampaignByIdQuery searchCampaignByIdQuery) throws Exception {
        SearchCampaignByIdCommand searchCampaignByIdCommand = campaignMapper.mapSearchCampaignByIdQueryToSearchCampaignByIdCommand(searchCampaignByIdQuery);
        SearchCampaignByIdResult searchCampaignByIdResult = searchCampaignByIdUseCase.execute(searchCampaignByIdCommand);
        return campaignMapper.mapSearchCampaignByIdResultToSearchCampaignByIdResponse(searchCampaignByIdResult);
    }
}
