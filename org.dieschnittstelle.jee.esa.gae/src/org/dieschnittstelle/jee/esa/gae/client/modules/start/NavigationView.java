package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import com.google.gwt.user.client.ui.IsWidget;

public interface NavigationView extends IsWidget {

   public interface Presenter {

      void onMenuProductsClicked();

      void onMenuLoginClicked();

   }

   void setPresenter(Presenter presenter);

}
