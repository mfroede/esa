package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class StartActivity extends AbstractActivityDefaultImpl<StartPlace> implements StartView.Presenter {

   private final EventBus eventBus;
   private final StartView view;

   @Inject
   public StartActivity(final StartView view, EventBus eventBus) {
      this.view = view;
      this.eventBus = eventBus;
   }

   @Override
   public void start(final AcceptsOneWidget panel, final com.google.gwt.event.shared.EventBus pEventBus) {
      view.setPresenter(this);
      panel.setWidget(view);

   }

   @Override
   public void onButtonClick() {
      LoginDTO loginDTO = new LoginDTO();

      loginDTO.setUserName("mail@nowere.com");
      loginDTO.setPassword("password");

      Services.login().login(loginDTO, new MethodCallback<CustomerDTO>() {

         @Override
         public void onSuccess(Method method, CustomerDTO response) {
            // TODO login success
            System.out.println("");
         }

         @Override
         public void onFailure(Method method, Throwable exception) {
            // TODO login failed
            System.out.println("");
         }
      });

      Services.campaigns().getAllCampaigns(new MethodCallback<List<CampaignDTO>>() {

         @Override
         public void onFailure(Method method, Throwable exception) {
            System.out.println("");

         }

         @Override
         public void onSuccess(Method method, List<CampaignDTO> response) {
            System.out.println();
         }
      });
   }

}
