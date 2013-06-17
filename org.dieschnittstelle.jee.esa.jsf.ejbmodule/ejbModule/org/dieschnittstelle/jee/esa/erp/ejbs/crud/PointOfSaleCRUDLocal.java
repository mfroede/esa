package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;

@Local
public interface PointOfSaleCRUDLocal {
	
	public PointOfSale createPointOfSale(PointOfSale pos);

	public PointOfSale readPointOfSale(int posId);

	public boolean deletePointOfSale(int posId);

}
