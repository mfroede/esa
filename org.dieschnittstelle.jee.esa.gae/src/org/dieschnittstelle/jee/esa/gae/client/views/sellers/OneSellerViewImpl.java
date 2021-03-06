package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class OneSellerViewImpl extends AbstractView implements OneSellerView {

	@UiField
	protected ListBox amountcombo;
	@UiField
	protected ListBox sellercombo;
	@UiField
	protected Label pricetext;

	private static ProductsViewImplUiBinder uiBinder = GWT
			.create(ProductsViewImplUiBinder.class);

	interface ProductsViewImplUiBinder extends
			UiBinder<Widget, OneSellerViewImpl> {
		// TODO Generated by GWT
	}

	private Presenter presenter;

	@Inject
	public OneSellerViewImpl() {
		content.add(uiBinder.createAndBindUi(this));
		// amountcombo = new ListBox(false);
		// sellercombo = new ListBox(false);

		amountcombo.addItem("0");
		amountcombo.addItem("1");
		amountcombo.addItem("2");
		amountcombo.addItem("3");

		sellercombo.addItem("a");
		sellercombo.addItem("b");
		sellercombo.addItem("c");
		sellercombo.addItem("d");

		// pricetext = new Label();
		pricetext.setText("testText");

		content.add(amountcombo);
		content.add(sellercombo);
		content.add(pricetext);
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	// @UiHandler("button")
	// void onButtonPressed(ClickEvent e) {
	// Window.alert("Clicked Me");
	// }
}
