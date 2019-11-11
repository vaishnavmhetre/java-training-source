/**
 * 
 */
package com.categories.service;

/**
 * @author Allianz3076
 *
 */
public class AnimalTypeService {

	public String animalType(String animal) {

		String animalType;

		switch (animal) {
		case "Lion":
			animalType = "Wild";
			break;
		case "God":
			animalType = "Domestic";
			break;
		default:
			animalType = "UNKNOWN";
			break;
		}

		return animalType;
	}

}
