package com.gmuguessr.backend;


/** 
 * @author Alex Choi
 * 
 * Creates a Geolocation Coordinates structure that holds 2 values that define
 * a geolocation: Latitude and Longitude.
 *
 */
public class GeoCoordinates {
	
	// Instance variables
	private double latitude;
	private double longitude;
	
	/**
	 *  Default constructor that initializes values to 0
	 */
	public GeoCoordinates() {
		latitude = 0;
		longitude = 0;
	}
	
	/**
	 * Overloaded constructor that initializes values using input
	 * 
	 * @param 	newLatitude
	 * @param 	newLongitude
	 */
	public GeoCoordinates(double newLatitude, double newLongitude) {
		latitude = newLatitude;
		longitude = newLongitude;
	}
	
	/**
	 * Returns the latitude value of location entry. 
	 * 
	 * @return	The latitude value of location entry
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets a new latitude for location entry.
	 * 
	 * @param 	latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Returns the longitude value of location entry. 
	 * 
	 * @return	The longitude value of location entry
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets a new longitude for location entry.
	 * 
	 * @param	longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}