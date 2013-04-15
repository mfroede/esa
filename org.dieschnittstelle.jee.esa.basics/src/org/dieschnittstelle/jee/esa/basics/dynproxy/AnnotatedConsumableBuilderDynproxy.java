package org.dieschnittstelle.jee.esa.basics.dynproxy;

import java.lang.reflect.Proxy;

import org.dieschnittstelle.jee.esa.basics.IConsumable;
import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedConsumableBuilder;

public class AnnotatedConsumableBuilderDynproxy extends AnnotatedConsumableBuilder {

	protected IConsumable createProxyForInstance(Object instance) {
		// create the invocation handler
		ConsumableInvocationHandler handler = new ConsumableInvocationHandler(
				instance);
		logger.debug("created invocation handler: " + handler);

		logger.debug("now creating proxy using handler and class loader: "
				+ instance.getClass().getClassLoader());

		return (IConsumable) Proxy.newProxyInstance(
				instance.getClass().getClassLoader(),
				new Class[] { IConsumable.class }, handler);
	}
}
