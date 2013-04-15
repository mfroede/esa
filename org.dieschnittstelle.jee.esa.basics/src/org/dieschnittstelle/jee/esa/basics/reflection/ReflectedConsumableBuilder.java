package org.dieschnittstelle.jee.esa.basics.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.basics.IConsumable;
import org.dieschnittstelle.jee.esa.basics.IConsumableBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// this builder only reads in the 
public class ReflectedConsumableBuilder implements IConsumableBuilder {

	protected static Logger logger = Logger
			.getLogger(ReflectedConsumableBuilder.class);

	@Override
	public IConsumable buildConsumableFromElement(Element el) {

		try {
			// obtain the child nodes
			NodeList children = el.getChildNodes();
			// iterate over the nodes and populate a map that we will use later
			Map<String, String> nodes = new HashMap<String, String>();

			for (int i = 0; i < children.getLength(); i++) {
				// once we have found an element node we check its name
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// get the textual content and the name
					String elementContent = ((Element) children.item(i))
							.getTextContent();
					String elementName = ((Element) children.item(i))
							.getTagName();
					logger.debug("found element " + elementName
							+ " with content: " + elementContent);
					nodes.put(elementName, elementContent);
				} else {
					// logger.debug("found node " + children.item(i)
					// + " of class " + children.item(i).getClass());
				}
			}
			
			logger.info("read out child elements and values: " + nodes);

			// try to obtain the class given the classname and create an
			// instance of it
			Class<?> klass = Class.forName(nodes.get("class"));
			IConsumable instance = (IConsumable) klass.newInstance();

			instance.acquire(Integer.parseInt(nodes.get("units")),
					nodes.get("brandname"));
			
			for(String key : nodes.keySet()) {
				if(key.equals("units") || key.equals("brandname") || key.equals("class")){
					continue;
				}
				Method[] classMethods = klass.getDeclaredMethods();
				for(int i = 0; i < classMethods.length; i++){
					Method method = classMethods[i];
					if(method.getName().toLowerCase().equals("set"+key.toLowerCase())){
//						System.err.println("Method: " + method.getName() + " Params: ");
						for (Class<?> methodTypes : method.getParameterTypes()) {
							System.err.println(methodTypes.getName() + " ");
							if(methodTypes.isPrimitive()){
								if (methodTypes.equals(Integer.TYPE) ){
									method.invoke(instance, Integer.parseInt(nodes.get(key)));
								} else if (methodTypes.equals(Double.TYPE) ) {
									method.invoke(instance, Double.parseDouble(nodes.get(key)));
								} 
							} else if (methodTypes.equals(String.class)) {
								method.invoke(instance, nodes.get(key));
							}
						}
					}
				}
			}


			// and pass back the instance
			return instance;
		} catch (ClassNotFoundException e) {
			logger.error("got ClassNotFoundException: " + e, e);
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			logger.error("got InstantiationException: " + e, e);
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			logger.error("got IllegalAccessException: " + e, e);
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			logger.error("got SecurityException: " + e, e);
			throw new RuntimeException(e);
		} catch (NumberFormatException e) {
			logger.error("got NumberFormatException: " + e, e);
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			logger.error("got IllegalArgumentException: " + e, e);
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			logger.error("got InvocationTargetException: " + e, e);
			throw new RuntimeException(e);
		} 

	}

}
