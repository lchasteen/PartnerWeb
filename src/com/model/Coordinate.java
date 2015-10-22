package com.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coord")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinate {	
	private String latitude;
	private String longitude;
	
	/**
	 * Creates new Coordinate.
	 * @param lat {@link String} latitude
	 * @param lon {@link String} longitude
	 */
	public Coordinate(String lat, String lon){
		
	}
	
	/**
	 * Creates new Coordinate.
	 */
	public Coordinate(){
		
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	

}
