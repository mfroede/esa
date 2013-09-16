package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;

public interface CampaignExecutionCRUD {

   public CampaignExecution createCampaignExecution(CampaignExecution campaignExecution);

   public CampaignExecution readCampaignExecution(Long id);

   public CampaignExecution updateCampaignExecution(CampaignExecution campaignExecution);

   public boolean deleteCampaignExecution(Long id);

   public List<CampaignExecution> readAllCampaignExecutions();

}
