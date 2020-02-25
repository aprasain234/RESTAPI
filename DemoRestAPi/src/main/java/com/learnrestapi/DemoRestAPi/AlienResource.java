package com.learnrestapi.DemoRestAPi;

import java.util.Arrays;
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

@Path("aliens")
public class AlienResource {
	AlienRepositary repo = new AlienRepositary();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Alien> getAliens()  {
		System.out.println("AlienResource called");
		
		  return repo.getAliens();
	}
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id)  {		
		  return repo.getAlien(id);
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("alien")
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1; 
		
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("alien")
	public Alien updateAlien(Alien a1) {
		System.out.println(a1);
		if(repo.getAlien(a1.getId())==null) {
			repo.create(a1);
		} else {
			repo.update(a1);
		}
		return a1; 	
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien killAlien(@PathParam("id") int id)  {
		Alien a = repo.getAlien(id);
		if(a.getId()!= 0 )
			repo.delete(id);
		return a;
	}

}
