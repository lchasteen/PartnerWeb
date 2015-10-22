package com.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.model.Person;

@Path("/user")
public class UserService {
	@GET	
	@Produces("application/json")
	public ArrayList<Person> getUser(){
		ArrayList<Person>pp = new ArrayList<Person>();
		
		Person p = new Person();
		Person ap = new Person();
		
		Person bp = new Person();
		
		p.setName("Lane Chasteen");
		p.setAge("34");
		p.setDateOfBirth("08/22/1980");
		
		ap.setName("Cezar Lica");
		ap.setAge("42");
		ap.setDateOfBirth("02/22/1968");
		
		bp.setName("Johnny Paulk");
		bp.setAge("21");
		bp.setDateOfBirth("02/03/1996");
		
		pp.add(p);
		pp.add(ap);
		pp.add(bp);
		
		return pp;
	}
	
	 @GET
	 @Path("/search/{person}")
	 @Produces("application/json")
	 public Person getUser(@PathParam("person") String person) {
		 Person p = new Person();
		 if(person.equalsIgnoreCase( "Chasteen")){
			 
			p.setName("Lane Chasteen");
			p.setAge("34");
			p.setDateOfBirth("08/22/1980");
				
		 }
		 return p;
	 }
}
