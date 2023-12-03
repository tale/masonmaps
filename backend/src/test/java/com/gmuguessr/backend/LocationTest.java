package com.gmuguessr.backend;

import static org.junit.jupiter.api.Assertions.*;

import com.gmuguessr.backend.Distance;
import com.gmuguessr.backend.GeoCoordinates;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    void testDistanceCalculation() {
        // Test the distance calculation logic using the Haversine formula

        // Example coordinates
        GeoCoordinates imageCoordinates = new GeoCoordinates(37.7749, -122.4194); // San Francisco, CA
        GeoCoordinates mapboxApiCoordinates = new GeoCoordinates(34.0522, -118.2437); // Los Angeles, CA

        // Create a Distance object
        Distance distance = new Distance(imageCoordinates, mapboxApiCoordinates);

        // Expected distance between San Francisco and Los Angeles (in kilometers)
        double expectedDistance = 559.2;

        // Tolerance for floating-point comparison
        double tolerance = 0.1;

        // Check if the calculated distance is close to the expected distance
        assertEquals(expectedDistance, distance.getDistance(), tolerance, "Distance calculation is incorrect");
    }

    @Test
    void testGeoCoordinates() {
        // Test the GeoCoordinates class

        // Example coordinates
        double latitude = 37.7749;
        double longitude = -122.4194;

        // Create a GeoCoordinates object
        GeoCoordinates geoCoordinates = new GeoCoordinates(latitude, longitude);

        // Check if the coordinates are set correctly
        assertEquals(latitude, geoCoordinates.getLatitude(), "Latitude is incorrect");
        assertEquals(longitude, geoCoordinates.getLongitude(), "Longitude is incorrect");

        // Test setting new coordinates
        double newLatitude = 34.0522;
        double newLongitude = -118.2437;

        geoCoordinates.setLatitude(newLatitude);
        geoCoordinates.setLongitude(newLongitude);

        // Check if the new coordinates are set correctly
        assertEquals(newLatitude, geoCoordinates.getLatitude(), "New latitude is incorrect");
        assertEquals(newLongitude, geoCoordinates.getLongitude(), "New longitude is incorrect");
    }
}

