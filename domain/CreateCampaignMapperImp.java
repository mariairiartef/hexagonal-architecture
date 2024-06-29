package domain;

import domain.mappers.CreateCampaignMapper;
import domain.models.Campaign;

public class CreateCampaignMapperImp implements CreateCampaignMapper {
    @Override
    public Campaign mapCreateCampaignCommandToCampaign(CreateCampaignCommand createCampaignCommand) {
        return new Campaign(createCampaignCommand.id(), createCampaignCommand.storeId(), createCampaignCommand.dailyBudget());
    }

    @Override
    public CreateCampaignResult mapCampaignToCreateCampaignResult(Campaign campaign) {
        return new CreateCampaignResult(campaign.id(), campaign.storeId(), campaign.dailyBudget());
    }
}
