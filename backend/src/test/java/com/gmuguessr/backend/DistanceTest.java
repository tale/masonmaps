package com.gmuguessr.backend;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    public void testGetDistance() {
        // Define latitude and longitude values for an image and Mapbox API location
        double imageLatitude = 45.6789;
        double imageLongitude = -123.4567;
        double mapboxApiLatitude = 45.6780;
        double mapboxApiLongitude = -123.4570;
        GeoCoordinates imageCoordinates(imageLatitude, imageLongitude);
        GeoCoordinates mapboxApiCoordinates(mapboxApiLatitude, mapboxApiLongitude);

        // Create a Distance instance with the defined coordinates
        Distance distance = new Distance(imageCoordinates, mapboxApiCoordinates);

        // Calculate the distance using the getDistance method
        double calculatedDistance = distance.getDistance();

        // Define the expected distance (this should match your actual distance calculation)
        double expectedDistance = 0.1157;

        // Define a delta for double comparison (small tolerance)
        double delta = 0.001;

        // Use assertEquals to compare the calculated distance with the expected distance
        // and provide the delta for tolerance
        assertEquals(expectedDistance, calculatedDistance, delta);
    }
}

