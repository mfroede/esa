package org.dieschnittstelle.jee.esa.ejbs.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote;
import org.dieschnittstelle.jee.esa.erp.ejbs.StockSystem;

public class CreateStock {

   protected static Logger logger = Logger.getLogger(CreateStock.class);

   public static void main(String[] args) {

      // greifen Sie wie in den anderen Anwendungen auf die von Ihnen
      // erstellte StockSystem EJB zu
      Context context;
      try {
         context = new InitialContext();

         StockSystem stockSystem = (StockSystem) context.lookup(Constants.STOCK_SYSTEM_BEAN);
         logger.info("got stock system bean: " + stockSystem);

         // fügen Sie die Produkte hinzu
         stockSystem.addToStock(Constants.PRODUCT_1, Constants.TOUCHPOINT_1.getId(), 100);
         stockSystem.addToStock(Constants.PRODUCT_2, Constants.TOUCHPOINT_1.getId(), 100);
         stockSystem.addToStock(Constants.PRODUCT_1, Constants.TOUCHPOINT_2.getId(), 100);
         stockSystem.addToStock(Constants.PRODUCT_2, Constants.TOUCHPOINT_2.getId(), 100);

         // und lassen Sie sich die Vorräte ausgeben
         int s1 = stockSystem.getUnitsOnStock(Constants.PRODUCT_1, Constants.TOUCHPOINT_1.getId());
         int s2 = stockSystem.getUnitsOnStock(Constants.PRODUCT_1, Constants.TOUCHPOINT_2.getId());
         int s3 = stockSystem.getUnitsOnStock(Constants.PRODUCT_2, Constants.TOUCHPOINT_1.getId());
         int s4 = stockSystem.getUnitsOnStock(Constants.PRODUCT_2, Constants.TOUCHPOINT_2.getId());

         logger.info("Vorraete: " + s1 + "/" + s2 + ", " + s3 + "/" + s4);
      } catch (NamingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
