package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.client.common.AbstractView;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;

public class CampaignsViewImpl extends AbstractView implements CampaignsView {

	@UiField
	protected FlowPanel campaignspanel;

	private List<CampaignDTO> campaigns;
	private static ProductsViewImplUiBinder uiBinder = GWT
			.create(ProductsViewImplUiBinder.class);

	interface ProductsViewImplUiBinder extends
			UiBinder<Widget, CampaignsViewImpl> {

	}

	private Presenter presenter;

	@Inject
	public <T> CampaignsViewImpl() {
		content.add(uiBinder.createAndBindUi(this));
		if (campaigns != null) {
			for (CampaignDTO camp : campaigns) {
				campaignspanel.add(new CampaignObjectForListView(camp
						.getImageURL(), camp.getName() + "</br>Price "
						+ camp.getPrice()).asWidget());
			}
		} else {
			campaignspanel.add(new Label(
					"Leider keine aktuellen Angebote vorhanden"));
		}

	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setCampaigns(List<CampaignDTO> campaigns) {
		this.campaigns = campaigns;
	}

	@Override
	public void setCampaignsViews() {

	}
}
