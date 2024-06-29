package domain;

public record SearchCampaignByIdResult(String campaignId, String  storeId, Long dailyBudget, Number clicks, Number impressions, Number orders) {}
