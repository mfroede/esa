package org.dieschnittstelle.jee.esa.basics;


import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedConsumableBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.ConsumableProxyImpl;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		ConsumableCollection collection = new ConsumableCollection(
				"annotated/consumables.xml", new AnnotatedConsumableBuilder());
		// we load the contents into the collection
		collection.load();

		for (IConsumable consumable : collection.getConsumables()) {
			;
			showAttributes(((ConsumableProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.consume(collection.getConsumables());
	}

	/*
	 * †bungsaufgabe 2
	 */
	private static void showAttributes(Object consumable) {

	}

}
