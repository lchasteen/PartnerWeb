package com.service;



import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.impl.AssetImpl;
import com.model.Meter;

@Path("/asset")
public class AssetService {

		
	 @GET
	 @Path("/search/{id}")
	 @Produces("application/json")
	 public Meter getPerson(@PathParam("id") String person) {
		 Meter meter = new Meter();		 
		 return meter;
	 }
	 
	 
	 @GET
	 @Path("/meters/")
	 @Produces("application/json")
	 public List<Meter> getMeters(){		 
		 AssetImpl ai = new AssetImpl();		 
		 return ai.getMeters();		 
	 }
	 
	 
}
