package com.gmuguessr.backend;

/**
 * The Image class represents an image with associated properties, including image ID, URL, and geographical coordinates.
 */
public class Image {
    private String imageId;
    private String url;
    private GeoCoordinates location;

    /**
     * Constructs an Image object with the specified properties.
     *
     * @param imageId   The unique identifier for the image.
     * @param url       The URL of the image.
     * @param latitude  The latitude coordinate of the image's location.
     * @param longitude The longitude coordinate of the image's location.
     */
    public Image(String imageId, String url, double latitude, double longitude) {
        this.imageId = imageId;
        this.url = url;
        this.location = new GeoCoordinates(latitude, longitude);
    }

    /**
     * Constructs an Image object with the specified properties.
     *
     * @param imageId       The unique identifier for the image.
     * @param url           The URL of the image.
     * @param GeoCoordinates    the latitue and longitude of the image's location
     */
    public Image(String imageId, String url, GeoCoordinates location) {
        this.imageId = imageId;
        this.url = url;
        this.location = location;
    }

    /**
     * Retrieves the image's unique identifier (image ID).
     *
     * @return The image's unique identifier.
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * Retrieves the URL of the image.
     *
     * @return The URL of the image.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Retrieves the longitude coordinate of the image's location.
     *
     * @return The longitude coordinate of the image's location.
     */
    public double getLongitude() {
        return location.getLongitude();
    }

    /**
     * Retrieves the latitude coordinate of the image's location.
     *
     * @return The latitude coordinate of the image's location.
     */
    public double getLatitude() {
        return location.getLatitude();
    }
}

