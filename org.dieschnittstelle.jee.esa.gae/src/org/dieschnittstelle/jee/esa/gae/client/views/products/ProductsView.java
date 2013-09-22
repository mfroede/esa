package org.dieschnittstelle.jee.esa.gae.client.views.products;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignExecutionDTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface ProductsView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);

	void setCampaignsExecutions(List<CampaignExecutionDTO> execution);
}
