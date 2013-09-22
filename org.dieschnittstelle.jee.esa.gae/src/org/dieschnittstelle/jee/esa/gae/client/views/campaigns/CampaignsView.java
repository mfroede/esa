package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface CampaignsView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);

	void setCampaigns(List<CampaignDTO> campaigns);

	void setCampaignsViews();
}
