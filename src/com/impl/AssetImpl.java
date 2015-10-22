package com.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.text.ParseException;
import static java.util.Arrays.asList;

import com.model.Coordinate;
import com.model.Meter;
import com.model.Restaurant;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;

public class AssetImpl {
	private MongoDatabase db;	
	private MongoClient mongoClient;
	
	
	/**
	 * Constructor
	 */
	public AssetImpl(){
		
		mongoClient = new MongoClient();		
		db = mongoClient.getDatabase("test");
		
	}
	

	/**
	 * 
	 * @return
	 * @throws ParseException
	 */
	public boolean insertAsset(Meter m) throws ParseException{		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		db.getCollection("meters").insertOne(
		        new Document("location",
		                new Document()
		                        .append("street", m.getStreet())
		                        .append("zipcode", m.getZipcode())
		                        .append("id", m.getId())
		                        .append("coord", asList(-73.9557413, 40.7720266))));

		return true;
	}
	
	/**
	 * 
	 */
	public List<Meter> getMeters(){	

		BasicDBObject query = new BasicDBObject();
		query.put("location.street", "Kings Highway");
		//FindIterable<Document> iterable = db.getCollection("meters").find(query);		
		//FindIterable<Document> iterable = db.getCollection("meters").find().limit(1000);
		FindIterable<Document> iterable = db.getCollection("assets").find();
		List<Meter> dlist = new ArrayList<Meter>();	
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	//String borough = document.getString("borough");
		    	
		    	Document d = (Document) document.get("location");
		    	String meterID = d.getString("meter");
		    	String street = d.getString("street");
		    	String zipCode = d.getString("zipcode");		    	
		    	ArrayList<Object> coordinates =  (ArrayList<Object>) d.get("coord");
		    	
		    	Meter meter = new Meter();
		    	Coordinate cord = null;
		    	
		    	if(coordinates.size() > 1){
		    		String lat = coordinates.get(0).toString();
		    		String lon = coordinates.get(0).toString();
		    		cord = new Coordinate(lat,lon);
		    		meter.setCoord(cord);
		    	}
		    
		    	meter.setId(meterID);
		    	meter.setStreet(street);
		    	meter.setZipcode(zipCode);
		    	
		    	
		    	
		        dlist.add(meter);
		    }
		});
	
		return dlist;
	}
	
}
