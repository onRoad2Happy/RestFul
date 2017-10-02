package com.rest.animal.dao;

import java.util.List;

import com.rest.animal.model.Animal;

public interface AnimalDAO {
	List<Animal> getListOfAnimals();
	Animal createAnimal(Animal animal);
	Animal updateAnimal(Animal animal,int id);
	void deleteAnimal(int id);
}
