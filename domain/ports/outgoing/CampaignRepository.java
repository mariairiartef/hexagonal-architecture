package domain.ports.outgoing;

import domain.CreateCampaignCommand;
import domain.models.Campaign;

/**
 * This interface represents an outgoing port towards the Campaign Repository. It's part of the hexagonal architecture's
 * infrastructure layer and is used to communicate with the external Campaign Repository system.
 *
 * It provides two main operations:
 * 1. `createCampaign(Campaign campaign)`: This method is used to create a new campaign in the repository. The campaign
 *    details are encapsulated in the `Campaign` object.
 * 2. `searchCampaignById(String id)`: This method retrieves a specific campaign from the repository using its unique ID.
 */
public interface CampaignRepository {
    Campaign createCampaign(Campaign campaign);
    Campaign searchCampaignById(String id);
}
