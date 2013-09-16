package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CampaignExecutionCRUDImpl implements CampaignExecutionCRUD {

   protected static final Logger logger = Logger.getLogger(CampaignExecutionCRUDImpl.class.getName());

   EntityManager em = EMF.get().createEntityManager();

   @Override
   public CampaignExecution createCampaignExecution(CampaignExecution campaignExecutionExecution) {
      logger.info("createCampaignExecutionExecution(): before persist(): " + campaignExecutionExecution);
      em.getTransaction().begin();
      em.persist(campaignExecutionExecution);
      em.getTransaction().commit();
      logger.info("createdCampaignExecutionExecution(): after persist(): " + campaignExecutionExecution);
      return campaignExecutionExecution;
   }

   @Override
   public CampaignExecution readCampaignExecution(Long id) {
      logger.info("readCampaignExecution() id: " + id);
      CampaignExecution campaignExecution = em.find(CampaignExecution.class, id);
      logger.info("readCampaignExecution() CampaignExecution: " + campaignExecution);

      return campaignExecution;
   }

   @Override
   public CampaignExecution updateCampaignExecution(CampaignExecution campaignExecution) {
      logger.info("updateCampaignExecution(): before merge(): " + campaignExecution);
      em.getTransaction().begin();
      campaignExecution = em.merge(campaignExecution);
      em.getTransaction().commit();
      logger.info("updateCampaignExecution(): after merge(): " + campaignExecution);
      return campaignExecution;
   }

   @Override
   public boolean deleteCampaignExecution(Long id) {
      logger.info("deleteCampaignExecution(): " + id);
      em.getTransaction().begin();
      em.remove(em.find(CampaignExecution.class, id));
      em.getTransaction().commit();
      logger.info("deleteCampaignExecution(): done");

      return true;
   }

   @Override
   public List<CampaignExecution> readAllCampaignExecutions() {
      CriteriaQuery<CampaignExecution> criteria = em.getCriteriaBuilder().createQuery(CampaignExecution.class);
      criteria.select(criteria.from(CampaignExecution.class));
      List<CampaignExecution> campaignExecutions = em.createQuery(criteria).getResultList();
      return campaignExecutions;
   }

}
