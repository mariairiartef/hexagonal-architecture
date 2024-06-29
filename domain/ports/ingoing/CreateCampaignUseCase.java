package domain.ports.ingoing;

import domain.CreateCampaignCommand;
import domain.CreateCampaignResult;

/**
 * This is an ingoing port
 */
public interface CreateCampaignUseCase {
    // We can also call this method "create"
    CreateCampaignResult execute(CreateCampaignCommand createCampaignCommand) throws Exception;
}
