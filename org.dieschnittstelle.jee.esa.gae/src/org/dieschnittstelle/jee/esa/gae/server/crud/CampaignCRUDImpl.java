package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class CampaignCRUDImpl implements CampaignCRUD {

   protected static final Logger logger = Logger.getLogger(CampaignCRUDImpl.class.getName());

   EntityManager em = EMF.get().createEntityManager();

   @Override
   public Campaign createCampaign(Campaign campaign) {
      logger.info("createCampaign(): before persist(): " + campaign);
      em.getTransaction().begin();
      em.persist(campaign);
      em.getTransaction().commit();
      logger.info("createdCampaign(): after persist(): " + campaign);
      return campaign;
   }

   @Override
   public Campaign readCampaign(Long id) {
      logger.info("readCampaign() id: " + id);

      Campaign campaign = em.find(Campaign.class, id);

      logger.info("readCampaign() campaign: " + campaign);

      return campaign;
   }

   @Override
   public List<Campaign> readAllCampaigns() {
      CriteriaQuery<Campaign> criteria = em.getCriteriaBuilder().createQuery(Campaign.class);
      criteria.select(criteria.from(Campaign.class));
      List<Campaign> campaigns = em.createQuery(criteria).getResultList();
      return campaigns;
   }

   @Override
   public Campaign updateCampaign(Campaign campaign) {
      logger.info("updateCampaign(): before merge(): " + campaign);
      em.getTransaction().begin();
      campaign = em.merge(campaign);
      em.getTransaction().commit();
      logger.info("updateCampaign(): after merge(): " + campaign);
      return campaign;
   }

   @Override
   public Campaign updateCampaignWithSleep(Campaign campaign, long sleep) {
      logger.info("sleep" + sleep + "@" + this + ": entity manager is: " + em);
      logger.info("sleep" + sleep + "@" + this + ": before merge(): got remote: " + campaign);
      // we read out the campaign using the provided method
      logger.info("sleep" + sleep + "@" + this + ": before merge(): got local: " + readCampaign(campaign.getId()));

      campaign = em.merge(campaign);
      em.close();
      logger.info("sleep" + sleep + "@" + this + ": after merge(): " + campaign);

      try {
         Thread.sleep(sleep);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      logger.info("sleep" + sleep + "@" + this + ": after sleep(): " + campaign);

      return campaign;
   }

   @Override
   public boolean deleteCampaign(Long id) {
      logger.info("deleteCampaign(): " + id);
      em.getTransaction().begin();
      em.remove(em.find(Campaign.class, id));
      em.getTransaction().commit();
      logger.info("deleteCampaign(): done");

      return true;
   }

}
