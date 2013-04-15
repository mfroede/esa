package org.dieschnittstelle.jee.esa.basics;

import org.dieschnittstelle.jee.esa.basics.reflection.ReflectedConsumableBuilder;


public class ShowReflection {
	
	public static void main(String[] args) {
		// we initialise the collection
		ConsumableCollection collection = new ConsumableCollection("reflected/consumables.xml", new ReflectedConsumableBuilder());
		// we load the contents into the collection
		collection.load();
		// we initialise a consumer
//		Consumer consumer = new Consumer();
//		// ... and let them consume
//		consumer.consume(collection.getConsumables());
	}

}
