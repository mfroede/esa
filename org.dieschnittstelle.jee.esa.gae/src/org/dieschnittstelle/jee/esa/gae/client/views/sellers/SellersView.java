package org.dieschnittstelle.jee.esa.gae.client.views.sellers;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.TouchpointDTO;

import com.google.gwt.user.client.ui.IsWidget;

public interface SellersView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);

	void setTouchpoints(List<TouchpointDTO> touchpoints);
}
