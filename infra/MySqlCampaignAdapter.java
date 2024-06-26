package infra;

import domain.ports.outgoing.CampaignRepository; // this is the out port

import domain.models.Campaign;

public class MySqlCampaignAdapter implements CampaignRepository {

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return null;
    }
}
