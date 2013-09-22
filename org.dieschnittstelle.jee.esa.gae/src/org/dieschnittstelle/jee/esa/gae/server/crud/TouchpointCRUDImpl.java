package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.MobileTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class TouchpointCRUDImpl implements TouchpointCRUD {

   protected static Logger logger = Logger.getLogger(TouchpointCRUDImpl.class.getName());

   EntityManager em = EMF.get().createEntityManager();

   @Override
   public MobileTouchpoint createTouchpoint(MobileTouchpoint touchpoint) {

      logger.info("createTouchpoint(): before persist(): " + touchpoint);
      em.getTransaction().begin();
      em.persist(touchpoint);
      em.getTransaction().commit();
      logger.info("createTouchpoint(): after persist(): " + touchpoint);

      return touchpoint;
   }

   @Override
   public StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint) {

      logger.info("createTouchpoint(): before persist(): " + touchpoint);
      em.getTransaction().begin();
      em.persist(touchpoint);
      em.getTransaction().commit();
      logger.info("createTouchpoint(): after persist(): " + touchpoint);

      return touchpoint;
   }

   @Override
   public AbstractTouchpoint readTouchpoint(long id) {
      logger.info("readTouchpoint(): " + id);

      AbstractTouchpoint touchpoint = em.find(StationaryTouchpoint.class, id);
      if (touchpoint == null) {
         touchpoint = em.find(MobileTouchpoint.class, id);
      }

      logger.info("readTouchpoint(): " + touchpoint);

      return touchpoint;
   }

   @Override
   public AbstractTouchpoint updateTouchpoint(AbstractTouchpoint touchpoint) {
      logger.info("updateTouchpoint(): before merge(): " + touchpoint);
      em.getTransaction().begin();
      touchpoint = em.merge(touchpoint);
      em.getTransaction().commit();
      logger.info("updateTouchpoint(): after merge(): " + touchpoint);
      return touchpoint;
   }

   @Override
   public boolean deleteTouchpoint(long id) {
      logger.info("deleteTouchpoint(): " + id);
      em.getTransaction().begin();
      em.remove(em.find(AbstractTouchpoint.class, id));
      em.getTransaction().commit();
      logger.info("deleteTouchpoint(): done");

      return true;
   }

   @Override
   public List<AbstractTouchpoint> readAllTouchpoints() {
      List<AbstractTouchpoint> result = new ArrayList<>();
      result.addAll(readAllMobileTouchpoints());
      result.addAll(readAllStationaryTouchpoints());
      return result;
   }

   private List<MobileTouchpoint> readAllMobileTouchpoints() {
      CriteriaQuery<MobileTouchpoint> criteria = em.getCriteriaBuilder().createQuery(MobileTouchpoint.class);
      criteria.select(criteria.from(MobileTouchpoint.class));
      List<MobileTouchpoint> touchpoints = em.createQuery(criteria).getResultList();
      return touchpoints;
   }

   private List<StationaryTouchpoint> readAllStationaryTouchpoints() {
      CriteriaQuery<StationaryTouchpoint> criteria = em.getCriteriaBuilder().createQuery(StationaryTouchpoint.class);
      criteria.select(criteria.from(StationaryTouchpoint.class));
      List<StationaryTouchpoint> touchpoints = em.createQuery(criteria).getResultList();
      return touchpoints;
   }

}
