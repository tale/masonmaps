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
        return 0.0; // Placeholder value; replace with actual calculation
    }
}