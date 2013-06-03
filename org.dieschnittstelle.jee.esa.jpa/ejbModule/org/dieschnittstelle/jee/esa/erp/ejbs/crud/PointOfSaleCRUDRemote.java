package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import javax.ejb.Remote;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;

@Remote
public interface PointOfSaleCRUDRemote {

	public PointOfSale createPointOfSale(PointOfSale pos);

	public PointOfSale readPointOfSale(int posId);

	public boolean deletePointOfSale(int posId);

}
