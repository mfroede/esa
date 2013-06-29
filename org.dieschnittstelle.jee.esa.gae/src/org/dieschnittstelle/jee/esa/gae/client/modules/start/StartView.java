/*******************************************************************************
 * Qyotta UG (haftungsbeschränkt) (http://www.qyotta.de).
 * All rights reserved.
 * Copyright (c) 2012 Qyotta UG
 *******************************************************************************/
package org.dieschnittstelle.jee.esa.gae.client.modules.start;

import com.google.gwt.user.client.ui.IsWidget;

public interface StartView extends IsWidget {
	interface Presenter {
	}

	void setPresenter(Presenter presenter);

}
