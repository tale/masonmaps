package com.gmuguessr.backend;

/**
 * The Distance class calculates the distance between two geographical coordinates (latitude and longitude)
 * using the Haversine formula.
 */
public class Distance {

    private GeoCoordinates imageCoordinates;
    private GeoCoordinates mapboxApiCoordinates;

    /**
     * Creates a new Distance instance with image and Mapbox API coordinates.
     *
     * @param imageLatitude        The latitude of the image's location.
     * @param imageLongitude       The longitude of the image's location.
     * @param mapboxApiLatitude    The latitude of the Mapbox API location.
     * @param mapboxApiLongitude   The longitude of the Mapbox API location.
     */
    public Distance(double imageLatitude, double imageLongitude, double mapboxApiLatitude, double mapboxApiLongitude) {
        this.imageCoordinates = new GeoCoordinates(imageLatitude, imageLongitude);
        this.mapboxApiCoordinates = new GeoCoordinates(mapboxApiLatitude, mapboxApiLongitude);
    }

    /**
     * Creates a new Distance instance with image and Mapbox API coordinates.
     * @param imageCoordinates      The latitude and longitude of the image's location
     * @param mapboxApiCoordinates  The latitude and longitude of the user's guess
     */
    public Distance(GeoCoordinates imageCoordinates, GeoCoordinates mapboxApiCoordinates) {
        this.imageCoordinates = imageCoordinates;
        this.mapboxApiCoordinates = mapboxApiCoordinates;
    }

    /**
     * Calculates the distance between the image location and the Mapbox API location
     * using the Haversine formula.
     *
     * @return The calculated distance in kilometers.
     */
    public double getDistance() {
        // Calculate the distance using the Haversine formula
        // Implement the calculation logic here
    	
    	//Subtracting mapbox latitude from image latitude for latitude delta.
    	double latImg = this.imageCoordinates.getLatitude();
    	double latMap = this.mapboxApiCoordinates.getLatitude();
    	double latDelta = Math.toRadians(latImg - latMap);
    	
    	//Subtracting mapbox longitude from image longitude for longitude delta.
    	double lonImg = this.imageCoordinates.getLongitude();
    	double lonMap = this.mapboxApiCoordinates.getLongitude();
    	double lonDelta = Math.toRadians(lonImg - lonMap);
    	
    	//Re-converting latitude values to radians for use later.
    	latImg = Math.toRadians(latImg);
    	latMap = Math.toRadians(latMap);
    	
    	//Applying Haversine formula using taken latitude and longitude deltas.
    	double formA = Math.pow(Math.sin(latDelta / 2), 2);
    	double formB = Math.pow(Math.sin(lonDelta / 2), 2);
    	double formC =  Math.cos(latMap) * Math.cos(latImg);
    	double formRes = formA + formB * formC;
    	
    	//Applying results of Haversine formula to Earth's radius of 6371.
    	double rad = 6371;
    	double c = 2 * Math.asin(Math.sqrt(formRes));
    	double result = rad * c;
    	
        return result; // Placeholder value; replace with actual calculation
    }
}