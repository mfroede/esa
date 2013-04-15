package org.dieschnittstelle.jee.esa.basics;

import org.w3c.dom.Element;

public interface IConsumableBuilder {

	public IConsumable buildConsumableFromElement(Element el);
	
}
