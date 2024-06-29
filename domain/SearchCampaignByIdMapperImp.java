package domain;

import domain.mappers.SearchCampaignByIdMapper;
import domain.models.Campaign;
import domain.models.Performance;

public class SearchCampaignByIdMapperImp implements SearchCampaignByIdMapper {
    @Override
    public SearchCampaignByIdResult mapCampaignAndPerformanceToSearchCampaignIdResult(Campaign campaign, Performance performance) {
        return new SearchCampaignByIdResult(campaign.id(), campaign.storeId(), campaign.dailyBudget(), performance.clicks(), performance.impressions(), performance.orders());
    }
}
