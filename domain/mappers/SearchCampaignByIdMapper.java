package domain.mappers;

import domain.SearchCampaignByIdResult;
import domain.models.Campaign;
import domain.models.Performance;

public interface SearchCampaignByIdMapper {
    SearchCampaignByIdResult mapCampaignAndPerformanceToSearchCampaignIdResult(Campaign campaign, Performance performance);
}
