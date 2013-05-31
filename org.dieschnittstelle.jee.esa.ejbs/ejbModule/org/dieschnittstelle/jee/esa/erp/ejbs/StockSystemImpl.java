package org.dieschnittstelle.jee.esa.erp.ejbs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.dieschnittstelle.jee.esa.erp.model.IndividualisedProductItem;

@Singleton
@Startup
@javax.ejb.ConcurrencyManagement(javax.ejb.ConcurrencyManagementType.CONTAINER)
public class StockSystemImpl implements StockSystem {
   
   private final Map<Integer,Map<IndividualisedProductItem, Integer>> stock = new LinkedHashMap<Integer, Map<IndividualisedProductItem,Integer>>();
   @Override
   public void addToStock(IndividualisedProductItem product, int pointOfSaleId, int units) {
      if(stock.get(pointOfSaleId) == null) {
         stock.put(pointOfSaleId, new LinkedHashMap<IndividualisedProductItem, Integer>());
      }
      stock.get(pointOfSaleId).put(product, units);
   }

   @Override
   public void removeFromStock(IndividualisedProductItem product, int pointOfSaleId, int units) {
      throw new UnsupportedOperationException();
   }

   @Override
   public List<IndividualisedProductItem> getProductsOnStock(int pointOfSaleId) {
      throw new UnsupportedOperationException();
   }

   @Override
   public List<IndividualisedProductItem> getAllProductsOnStock() {
      throw new UnsupportedOperationException();
   }

   @Override
   public int getUnitsOnStock(IndividualisedProductItem product, int pointOfSaleId) {
      Map<IndividualisedProductItem, Integer> result = stock.get(pointOfSaleId);
      if(result == null) {
         return 0;
      }
      Integer resultUnits = result.get(product);
      if(resultUnits == null) {
         return 0;
      }      
      return resultUnits;
   }

   @Override
   public int getTotalUnitsOnStock(IndividualisedProductItem product) {
      throw new UnsupportedOperationException();
   }

   @Override
   public List<Integer> getPointsOfSale(IndividualisedProductItem product) {
      throw new UnsupportedOperationException();
   }

}
