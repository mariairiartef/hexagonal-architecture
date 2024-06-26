package domain.mappers;

import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

import domain.models.Campaign;

public interface CreateCampaignMapper {
    Campaign mapCreateCampaignCommandToCampaign(CreateCampaignCommand createCampaignCommand);
    CreateCampaignResult mapCampaignToCreateCampaignResult(Campaign campaign);
}
