package org.dieschnittstelle.jee.esa.basics.dynproxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.lang.reflect.Proxy;

import org.dieschnittstelle.jee.esa.basics.IConsumable;
import org.dieschnittstelle.jee.esa.basics.annotations.*;

import org.apache.log4j.Logger;

public class ConsumableInvocationHandler implements InvocationHandler {

	// the logger
	protected static Logger logger = Logger
			.getLogger(ConsumableInvocationHandler.class);

	// a mapping of the methods of the IConsumable interface to the methods of
	// the class that this handler is supposed to deal with
	private Map<Method, Method> methodMapping = new HashMap<Method, Method>();

	// the object to which the proxy invocations will be forwarded
	private Object proxiedObject;

	// get the proxied object
	public Object getProxiedObject() {
		return this.proxiedObject;
	}

	// try construct the handler for some class
	public ConsumableInvocationHandler(Object obj) {
		logger.debug("<constructor>: " + obj);
		this.proxiedObject = obj;

		Class<?> consumableClass = obj.getClass();

		// show the annotations on the element
		logger.debug("got annotations: "
				+ Arrays.asList(consumableClass.getDeclaredAnnotations()));

		// check whether the class declares the Consumable annotation
		if (!consumableClass.isAnnotationPresent(Consumable.class)) {
			String err = "cannot handle class " + consumableClass
					+ ". It does not declare the Consumable annotation!";
			logger.error(err);
			throw new RuntimeException(err);
		}

		try {

			// first try to obtain the methods that we will consider
			Method acquireMethod = null;
			Method consumeMethod = null;
			Method getBrandnameMethod = null;
			Method getUnitsMethod = null;
			Method disposeMethod = null;

			// for checking presence of annotations we can either use
			// isAnnotationPresent() or getAnnotation(), where the latter
			// requires checking non null on the return value
			for (Method m : consumableClass.getDeclaredMethods()) {
				if (consumeMethod == null
						&& m.isAnnotationPresent(Consume.class)) {
					consumeMethod = m;
				} else if (acquireMethod == null
						&& m.getAnnotation(Acquire.class) != null) {
					acquireMethod = m;
				} else if (disposeMethod == null
						&& m.isAnnotationPresent(Dispose.class)) {
					disposeMethod = m;
				} else if (getBrandnameMethod == null
						&& m.isAnnotationPresent(Brandname.class)) {
					getBrandnameMethod = m;
				} else if (getUnitsMethod == null
						&& m.isAnnotationPresent(Units.class)) {
					getUnitsMethod = m;
				}
			}

			// it might be possible that the @Units or @Brandname annotation is
			// declared on the attributes rather than on the methods, in this
			// case iterate over the fields
			if (getBrandnameMethod == null || getUnitsMethod == null) {
				for (Field f : consumableClass.getDeclaredFields()) {
					/*
					 * if the annotation is declared on one of the fields, we
					 * require a conventionalised getter for that field -
					 * alternatively our mapping could distinguish between
					 * method invocations and field access (see the class
					 * ShowClasspathScan for how to read out the value of a
					 * field)
					 */
					if (getBrandnameMethod == null
							&& f.isAnnotationPresent(Brandname.class)) {
						getBrandnameMethod = consumableClass
								.getDeclaredMethod("get"
										+ f.getName().substring(0, 1)
												.toUpperCase()
										+ f.getName().substring(1));
					} else if (getUnitsMethod == null
							&& f.isAnnotationPresent(Units.class)) {
						getUnitsMethod = consumableClass
								.getDeclaredMethod("get"
										+ f.getName().substring(0, 1)
												.toUpperCase()
										+ f.getName().substring(1));
					}
				}
			}

			logger.info("found the four methods we are interested in on class "
					+ consumableClass + ": " + acquireMethod + ", "
					+ consumeMethod + ", " + getBrandnameMethod + ", "
					+ getUnitsMethod);

			/*
			 * then we populate the mapping
			 */

			// note that a primitive-types argument needs to be identified by
			// the corresponding wrapper class' TYPE constant
			methodMapping.put(IConsumable.class.getDeclaredMethod("acquire",
					Integer.TYPE, String.class), acquireMethod);
			methodMapping.put(IConsumable.class.getDeclaredMethod("consume",
					Integer.TYPE), consumeMethod);
			methodMapping.put(IConsumable.class.getDeclaredMethod("dispose"),
					disposeMethod);
			methodMapping.put(
					IConsumable.class.getDeclaredMethod("getBrandname"),
					getBrandnameMethod);
			methodMapping.put(IConsumable.class.getDeclaredMethod("getUnits"),
					getUnitsMethod);
			// we also map the toString and the equals methods!
			methodMapping.put(Object.class.getDeclaredMethod("toString"),
					consumableClass.getDeclaredMethod("toString"));
			methodMapping.put(
					Object.class.getDeclaredMethod("equals",
							new Class[] { Object.class }),
					consumableClass.getSuperclass().getDeclaredMethod("equals",
							new Class[] { Object.class }));
		} catch (NoSuchMethodException nsme) {
			String err = "got NoSuchMethodException: " + nsme;
			logger.error(err, nsme);
			throw new RuntimeException(nsme);
		}

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		logger.debug("got invocation of method " + method + ", using args: "
				+ args);

		// check whether we have the equals method -- we invoke it on the proxy
		// itself
		if (method.equals(Object.class.getDeclaredMethod("equals",
				new Class[] { Object.class })) && args[0] instanceof Proxy) {
			ConsumableInvocationHandler handler = (ConsumableInvocationHandler) Proxy
					.getInvocationHandler(args[0]);
			Object otherProxiedObject = handler.getProxiedObject();
			logger.debug("got invocation on the equals method. Obtained the proxied object from the argument: "
					+ otherProxiedObject
					+ " passing it to ourselves: "
					+ this.proxiedObject);

			return this.proxiedObject.equals(otherProxiedObject);
		}

		// check whether we find the method in the map
		Method mappedMethod = methodMapping.get(method);
		logger.debug("found mapped method: " + mappedMethod);

		// if we have found the mapped method, we invoke it, passing the proxied
		// object and the arguments array
		if (mappedMethod != null) {
			Object returnValue = mappedMethod.invoke(this.proxiedObject, args);
			logger.debug("return value of mapped method is: " + returnValue);
			return returnValue;
		} else {
			logger.warn("got invocation of unmapped method: " + method
					+ ". Will return null");
			return null;
		}
	}

}
