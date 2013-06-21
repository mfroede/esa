package org.dieschnittstelle.jee.esa.gae.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class AppEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		final Label label = new Label();
		label.setText("Hello World");
		RootPanel.get().add(label);
	}
}
