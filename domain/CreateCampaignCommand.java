package domain;

public record CreateCampaignCommand(String id, String storeId, Long dailyBudget) {}
