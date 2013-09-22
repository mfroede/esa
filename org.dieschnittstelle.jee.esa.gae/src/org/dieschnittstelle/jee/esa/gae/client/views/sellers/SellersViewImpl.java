package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.TouchpointDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SellersViewImpl extends AbstractView implements SellersView {

	@UiField
	protected Grid producttable;

	private List<TouchpointDTO> touchpoints;
	// @UiField
	// protected FlowPanel panelproduct;
	// @UiField
	// protected Grid producttable;

	private static ProductsViewImplUiBinder uiBinder = GWT
			.create(ProductsViewImplUiBinder.class);

	interface ProductsViewImplUiBinder extends
			UiBinder<Widget, SellersViewImpl> {
		// TODO Generated by GWT
	}

	private Presenter presenter;

	@Inject
	public SellersViewImpl() {
		content.add(uiBinder.createAndBindUi(this));
		// TestTableProductData t = new TestTableProductData();
		// TODO Anzahl Products for rows
		// panelproduct = new FlowPanel();
		// panelproduct.setStyleName("huhu");
		// producttable = new Grid(t.getList().size(), 4);
		// producttable.setStyleName("tablep");
		// for (int row = 0; row < producttable.getRowCount(); row++) {
		// producttable.setWidget(row, 0, new Label(t.getList().get(row)
		// .getId()
		// + ""));
		// producttable.setWidget(row, 1, new Label(t.getList().get(row)
		// .getName()));
		// producttable.setWidget(row, 2, new Label(t.getList().get(row)
		// .getPrice()
		// + ""));
		// producttable.setWidget(row, 3, new Image(
		// "DieSchnittstelle/gwt/standard/images/LupeKlein.png"));
		//
		// }
		// panelproduct.getElement().setAttribute("style",
		// "top: 10%; left: 10%;");
		// producttable.getElement().setAttribute("left", "10%");
		// panelproduct.add(producttable);
		// content.add(producttable);
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setTouchpoints(List<TouchpointDTO> touchpoints) {
		this.touchpoints = touchpoints;
		setTouchpoints();

	}

	private void setTouchpoints() {
		producttable.clear();
		producttable = new Grid(touchpoints.size(), 2);
		producttable.setStyleName("tablep");
		int i = 0;
		if (touchpoints != null && !touchpoints.isEmpty()) {
			for (TouchpointDTO point : touchpoints) {
				i++;
				producttable.setWidget(i, 0, new Label(point.getName() + ""));
				producttable.setWidget(i, 1, new Label(point.getAddress()
						.getCity()
						+ ", "
						+ point.getAddress().getStreet()
						+ " " + point.getAddress().getHouseNr()));
			}
		} else {
			content.add(new Label("Keine Verk�ufer vorhanden"));
		}
		content.add(producttable);
	}

	// @UiHandler("button")
	// void onButtonPressed(ClickEvent e) {
	// Window.alert("Clicked Me");
	// }
}
