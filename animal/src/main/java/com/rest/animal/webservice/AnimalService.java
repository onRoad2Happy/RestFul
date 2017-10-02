package com.rest.animal.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.rest.animal.dto.AnimalDTOImpl;
import com.rest.animal.model.Animal;

@Path("/animals")
public class AnimalService {

	@GET
	@Path("/listanimal")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListOfAnimals(){
		List<Animal> listAnimal=new ArrayList<>();
		 listAnimal=new AnimalDTOImpl().getListOfAnimals();
		 String str=null;
		 Gson gson=new Gson();
		 str=gson.toJson(listAnimal);
		 return str;
	}
	
	@POST
	@Path("/create/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAnimal(@PathParam("id") int id,Animal animal){
	Animal an=new AnimalDTOImpl().createAnimal(animal);
	String str=null;
	Gson gson=new Gson();
	str=gson.toJson(an);
	return str;
	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAnimal(@PathParam ("id") int id, Animal animal){
		Animal an=new AnimalDTOImpl().updateAnimal(animal, id);
		String str=null;
		Gson gson=new Gson();
		str=gson.toJson(an);
		return str;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAnimal(@PathParam ("id") int id){
		AnimalDTOImpl ani=new AnimalDTOImpl();
		ani.deleteAnimal(id);
	}
}
