package com.rest.animal.dto;

import java.util.List;

import com.rest.animal.model.Animal;

public interface AnimalDTOI {
	
	List<Animal> getListOfAnimals();
	Animal createAnimal(Animal animal);
	Animal updateAnimal(Animal animal,int id);
	void deleteAnimal(int id);
}
