package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.Remote;

import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.CampaignExecution;

@Remote
public interface CampaignTrackingRemote {

	public void addCampaignExecution(CampaignExecution campaign);
	
	public int existsValidCampaignExecutionAtTouchpoint(int erpProductId,
			AbstractTouchpoint tp);
	
	public void purchaseCampaignAtTouchpoint(int erpProductId,
			AbstractTouchpoint tp, int units);
	
	public List<CampaignExecution> getAllCampaignExecutions();
}
