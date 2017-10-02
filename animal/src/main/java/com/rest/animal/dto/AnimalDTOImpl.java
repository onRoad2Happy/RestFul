package com.rest.animal.dto;

import java.util.ArrayList;
import java.util.List;

import com.rest.animal.dao.AnimalDAO;
import com.rest.animal.dao.AnimalDAOImpl;
import com.rest.animal.model.Animal;

public class AnimalDTOImpl implements AnimalDTOI {

	@Override
	public List<Animal> getListOfAnimals() {
		List<Animal> animalList=new ArrayList<>();
		AnimalDAOImpl animpl=new AnimalDAOImpl();
		animalList=animpl.getListOfAnimals();
		return animalList;
	}

	@Override
	public Animal createAnimal(Animal animal) {
		AnimalDAOImpl animpl=new AnimalDAOImpl();
		Animal an=animpl.createAnimal(animal);
		return an;
	}

	@Override
	public Animal updateAnimal(Animal animal,int id) {
		AnimalDAOImpl animp=new AnimalDAOImpl();
		Animal an=animp.updateAnimal(animal, id);
		return an;
	}

	@Override
	public void deleteAnimal(int id) {
		AnimalDAOImpl ani=new AnimalDAOImpl();
		ani.deleteAnimal(id);
	}

}
