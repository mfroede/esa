package org.dieschnittstelle.jee.esa.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * at the moment, this class does not do that much. It only keeps on iterating over a list
 * of consumables and consumes a part of each of it until each consumable is consumed
 */
public class Consumer {

	/*
	 * some random generator for determining the number of units that will be
	 * consumed
	 */
	private static final Random randomiser = new Random();

	public void consume(List<IConsumable> consumables) {
		// count the consumption cycles
		int cycles = 0;
		
		do {
			cycles++;
			
			System.out.println("\n************* CYCLE " + cycles);
						
			List<IConsumable> todispose = new ArrayList<IConsumable>();

			for (IConsumable consumable : consumables) {
				// determine the number of units for each consumable
				int units = randomiser.nextInt(consumable.getUnits()+1);
				System.out.println("WILL CONSUME " + units + " OF: " + consumable);
				consumable.consume(units);
				
				if (consumable.getUnits() == 0) {
					todispose.add(consumable);
				}
			}
			
			for (IConsumable consumable : todispose) {
				consumables.remove(consumable);
				System.out.println("WILL DISPOSE: " + consumable);
				consumable.dispose();
			}
												
		} while (!consumables.isEmpty());
		
		System.out.println("\n************* DONE AFTER " + cycles + " CYCLES!");
		
	}

}
