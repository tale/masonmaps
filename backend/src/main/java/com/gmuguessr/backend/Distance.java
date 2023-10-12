package com.gmuguessr.backend;

/**
 * The Distance class calculates the distance between two geographical coordinates (latitude and longitude)
 * using the Haversine formula.
 */
public class Distance {
    private double imageLatitude;
    private double imageLongitude;
    private double mapboxApiLatitude;
    private double mapboxApiLongitude;

    /**
     * Creates a new Distance instance with image and Mapbox API coordinates.
     *
     * @param imageLatitude        The latitude of the image's location.
     * @param imageLongitude       The longitude of the image's location.
     * @param mapboxApiLatitude    The latitude of the Mapbox API location.
     * @param mapboxApiLongitude   The longitude of the Mapbox API location.
     */
    public Distance(double imageLatitude, double imageLongitude, double mapboxApiLatitude, double mapboxApiLongitude) {
        this.imageLatitude = imageLatitude;
        this.imageLongitude = imageLongitude;
        this.mapboxApiLatitude = mapboxApiLatitude;
        this.mapboxApiLongitude = mapboxApiLongitude;
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