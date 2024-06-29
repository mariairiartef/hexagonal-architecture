package domain.ports.ingoing;

import domain.SearchCampaignByIdCommand;
import domain.SearchCampaignByIdResult;

public interface SearchCampaignByIdUseCase {
    SearchCampaignByIdResult execute(SearchCampaignByIdCommand searchCampaignByIdCommand) throws Exception;
}
