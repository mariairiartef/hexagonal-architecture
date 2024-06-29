package domain.ports.outgoing;

import domain.models.Campaign;
import domain.models.Performance;

/**
 * This interface represents an outgoing port towards an Ad Server. It's part of the hexagonal architecture's
 * infrastructure layer and is used to communicate with the external Ad Server system.
 *
 * It provides two main operations:
 * 1. `sendCampaign(Campaign campaign)`: This method is used to send a campaign to the Ad Server. The campaign
 *    details are encapsulated in the `Campaign` object.
 * 2. `getCampaignPerformance(String campaignId)`: This method retrieves the performance data of a specific
 *    campaign from the Ad Server. The campaign is identified by its unique ID.
 */
public interface AdServerClient {
    void sendCampaign(Campaign campaign);
    Performance getCampaignPerformance(String campaignId);
}
