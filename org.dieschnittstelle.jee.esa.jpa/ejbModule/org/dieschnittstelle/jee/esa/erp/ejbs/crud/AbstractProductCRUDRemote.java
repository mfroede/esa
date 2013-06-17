package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import java.util.Collection;

import javax.ejb.Remote;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

@Remote
public interface AbstractProductCRUDRemote {

   public AbstractProduct createAbstractProduct(AbstractProduct pos);

   public AbstractProduct updateAbstractProduct(AbstractProduct pos);

   public AbstractProduct readAbstractProduct(int posId);

   public Collection<AbstractProduct> readAllAbstractProducts();

   public boolean deleteAbstractProduct(int posId);

}
