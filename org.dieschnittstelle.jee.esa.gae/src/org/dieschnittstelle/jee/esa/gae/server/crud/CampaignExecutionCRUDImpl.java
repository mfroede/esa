package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CampaignExecutionCRUDImpl implements CampaignExecutionCRUD {

   protected static final Logger logger = Logger.getLogger(CampaignExecutionCRUDImpl.class.getName());

   EntityManager em = EMF.get().createEntityManager();

   @Override
   public CampaignExecution createCampaignExecution(CampaignExecution campaignExecutionExecution) {
      logger.info("createCampaignExecutionExecution(): before persist(): " + campaignExecutionExecution);
      em.persist(campaignExecutionExecution);
      em.close();
      logger.info("createdCampaignExecutionExecution(): after persist(): " + campaignExecutionExecution);
      return campaignExecutionExecution;
   }

   @Override
   public CampaignExecution readCampaignExecution(Long id) {
      logger.info("readCampaignExecution() id: " + id);

      CampaignExecution campaignExecution = em.find(CampaignExecution.class, id);
      em.close();

      logger.info("readCampaignExecution() CampaignExecution: " + campaignExecution);

      return campaignExecution;
   }

   @Override
   public CampaignExecution updateCampaignExecution(CampaignExecution campaignExecution) {
      logger.info("updateCampaignExecution(): before merge(): " + campaignExecution);
      campaignExecution = em.merge(campaignExecution);
      em.close();

      logger.info("updateCampaignExecution(): after merge(): " + campaignExecution);
      return campaignExecution;
   }

   @Override
   public boolean deleteCampaignExecution(Long id) {
      logger.info("deleteCampaignExecution(): " + id);

      em.remove(em.find(CampaignExecution.class, id));
      em.close();

      logger.info("deleteCampaignExecution(): done");

      return true;
   }

}
