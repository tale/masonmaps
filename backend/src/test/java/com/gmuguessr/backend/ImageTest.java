package com.gmuguessr.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImageTest {

    @Test
    public void testGetImageId() {
        // Create an Image instance with sample values
        Image image = new Image("12345", "jc-gmu.jpg", 45.6789, -123.4567);

        // Test the getImageId method
        assertEquals("12345", image.getImageId());
    }

    @Test
    public void testGetUrl() {
        // Create an Image instance with sample values
        Image image = new Image("12345", "jc-gmu.jpg", 45.6789, -123.4567);

        // Test the getUrl method
        assertEquals("jc-gmu.jpg", image.getUrl());
    }

    @Test
    public void testGetLongitude() {
        // Create an Image instance with sample values
        Image image = new Image("12345", "jc-gmu.jpg", 45.6789, -123.4567);

        // Test the getLongitude method
        assertEquals(-123.4567, image.getLongitude(), 0.0001); // Allowing a small delta for double comparison
    }

    @Test
    public void testGetLatitude() {
        // Create an Image instance with sample values
        Image image = new Image("12345", "jc-gmu.jpg", 45.6789, -123.4567);

        // Test the getLatitude method
        assertEquals(45.6789, image.getLatitude(), 0.0001); // Allowing a small delta for double comparison
    }
}
