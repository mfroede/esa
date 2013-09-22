package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NavigationViewImpl extends AbstractView implements NavigationView {

   private static NavigationViewImplUiBinder uiBinder = GWT.create(NavigationViewImplUiBinder.class);

   interface NavigationViewImplUiBinder extends UiBinder<Widget, NavigationViewImpl> {
      // TODO Generated by GWT
   }

   @UiField
   MenuItem menuproducts;

   @UiField
   MenuItem menuLogin;

   private Presenter presenter;

   @Inject
   public NavigationViewImpl() {
      content.getElement().getStyle().setHeight(10, Unit.PC);
      content.add(uiBinder.createAndBindUi(this));
      menuproducts.setScheduledCommand(new Scheduler.ScheduledCommand() {

         @Override
         public void execute() {
            presenter.onMenuProductsClicked();
         }
      });

      menuLogin.setScheduledCommand(new ScheduledCommand() {
         @Override
         public void execute() {
            presenter.onMenuLoginClicked();
         }
      });
   }

   @Override
   public void setPresenter(final Presenter presenter) {
      this.presenter = presenter;
   }

}
