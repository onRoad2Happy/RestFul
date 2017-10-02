package com.rest.animal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.rest.animal.model.Animal;

public class AnimalDAOImpl implements AnimalDAO {

	Connection connection=null;
	public  AnimalDAOImpl() {
	DBConnection db=new DBConnection();
	try{
	connection=db.getConnection();
	}catch(Exception e){
		e.printStackTrace();
		}
	}
	
	@Override
	public List<Animal> getListOfAnimals() {
		String sql="select * from animal";
		List<Animal> animalList=new ArrayList<>();
		Animal animal=null;
		if(connection!=null){
			try {
				PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
				ResultSet result=statement.executeQuery();
				while(result.next()){
					animal=new Animal();
					animal.setId(result.getInt(1));
					animal.setName(result.getString(2));
					animal.setType(result.getString(3));
					animalList.add(animal);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return animalList;
	}

	@Override
	public Animal createAnimal(Animal animal) {
		String sql="insert into animal(id,name,type) values(?,?,?)";
		if(connection!=null){
			PreparedStatement statement;
			try {
				statement = (PreparedStatement) connection.prepareStatement(sql);
			
			statement.setInt(1, animal.getId());
			statement.setString(2, animal.getName());
			statement.setString(3,animal.getType());
			
			boolean result=statement.execute();
			
			
			if(result){
			System.out.println("Animal "+animal.getId() + " Added into db successfully");	
			}
			} catch (SQLException e) {
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		return animal;
	}

	@Override
	public Animal updateAnimal(Animal animal,int id) {
		String sql="update animal set name=?,type=? where id=?";
		if(connection!=null){
			try {
				PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
				statement.setString(1, animal.getName());
				statement.setString(2, animal.getType());
				statement.setInt(3, id);
				
				boolean result=statement.executeUpdate()>0;
				if(result){
					System.out.println("Animal "+id+" updated in DB successfully..");
				}
				
			} catch (SQLException e) {
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return animal;
	}

	@Override
	public void deleteAnimal(int id) {
		String sql="delete from animal where id=?";
		if(connection!=null){
			PreparedStatement statement;
			try {
				statement = (PreparedStatement) connection.prepareStatement(sql);
		
			statement.setInt(1, id);
			boolean result=statement.execute();
			if(result){
				System.out.println("Animal "+id+ " deleted from DB successfully..");
			}
		
			} catch (SQLException e) {
			e.printStackTrace();
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
