package org.dieschnittstelle.jee.esa.gae.client.common;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class AbstractView implements IsWidget {
	protected LayoutPanel content;

	public AbstractView() {
		content = new LayoutPanel();
		content.getElement().getStyle().setWidth(100, Unit.PC);
		content.getElement().getStyle().setHeight(100, Unit.PC);
	}

	@Override
	public Widget asWidget() {
		return content;
	}

}
