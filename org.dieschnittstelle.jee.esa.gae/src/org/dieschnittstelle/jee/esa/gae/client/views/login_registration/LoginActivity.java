package org.dieschnittstelle.jee.esa.gae.client.views.login_registration;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractActivityDefaultImpl;
import org.dieschnittstelle.jee.esa.gae.client.services.Services;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.LoginDTO;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class LoginActivity extends AbstractActivityDefaultImpl<LoginPlace> implements LoginView.Presenter {

   private final LoginView view;
   private final EventBus eventBus;

   @Inject
   public LoginActivity(final LoginView view, final EventBus eventBus) {
      this.view = view;
      this.eventBus = eventBus;

   }

   @Override
   public void start(final AcceptsOneWidget panel, final com.google.gwt.event.shared.EventBus pEventBus) {
      view.setPresenter(this);

      panel.setWidget(view);

   }
}
