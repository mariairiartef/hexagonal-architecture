package domain.ports.outgoing;

import domain.CreateCampaignCommand;
import domain.models.Campaign;

/*
 * Out port
 */
public interface CampaignRepository {
    Campaign createCampaign(Campaign campaign);
}
