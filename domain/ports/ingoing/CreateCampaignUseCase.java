package domain.ports.ingoing;

import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

/*
 * In port
 */
public interface CreateCampaignUseCase {
    CreateCampaignResult execute(CreateCampaignCommand createCampaignCommand);
}
