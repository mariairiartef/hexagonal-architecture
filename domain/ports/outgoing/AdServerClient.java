package domain.ports.outgoing;

import domain.SendCampaignCommand;

/*
 * Out port
 */
public interface AdServerClient {
    void sendCampaign(SendCampaignCommand command);
}
