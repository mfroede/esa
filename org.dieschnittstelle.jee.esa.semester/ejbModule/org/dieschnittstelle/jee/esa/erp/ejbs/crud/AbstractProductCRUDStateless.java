package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

@Stateless
public class AbstractProductCRUDStateless implements AbstractProductCRUDRemote {

   @PersistenceContext(unitName = "crm_erp_PU")
   private EntityManager em;

   @Override
   public AbstractProduct createAbstractProduct(AbstractProduct pos) {
      em.persist(pos);
      return pos;
   }

   @Override
   public AbstractProduct readAbstractProduct(int posId) {
      return em.find(AbstractProduct.class, posId);
   }

   @SuppressWarnings("unchecked")
   @Override
   public Collection<AbstractProduct> readAllAbstractProducts() {
      Query query = em.createQuery("SELECT e FROM AbstractProduct e");
      Collection<AbstractProduct> resultList = query.getResultList();
      return resultList;
   }

   @Override
   public AbstractProduct updateAbstractProduct(AbstractProduct pos) {
      return em.merge(pos);
   }

   @Override
   public boolean deleteAbstractProduct(int posId) {
      em.remove(em.find(AbstractProduct.class, posId));
      return true;
   }

}
