package org.dieschnittstelle.jee.esa.gae.server.crud;

import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;

public interface CampaignCRUD {	
	
	public Campaign createCampaign(Campaign campaign);

	public Campaign readCampaign(Long id);

	public Campaign updateCampaign(Campaign campaign);
		
	public Campaign updateCampaignWithSleep(Campaign campaign,long sleep);
	
	public boolean deleteCampaign(Long id);

}
