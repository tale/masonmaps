package com.gmuguessr.backend;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.ui.Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class BackendApplication {

	public static void main(String[] args) {
		try {
			JDBC.connect();
			ResultSet set = JDBC.query("SHOW TABLES"); // Example
			while (set.next()) {
				System.out.println(set.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Could not connect to database");
			System.out.println(e);
		}

		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	// Returns a JSON with the image URL
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/image")
	public Image image() {
		Image[] images = new Image[] {
			new Image("1", "http://localhost:8080/20230914_160750916_iOS.jpg", 38.8329, -77.309),
			new Image("2", "http://localhost:8080/20230914_161632.jpg", 38.8294, -77.3057),
			new Image("3", "http://localhost:8080/20230914_161029040_iOS.jpg", 38.82981566714652, -77.30781445053643),
			new Image("4", "http://localhost:8080/IMG_3139.png", 38.83200733000247, -77.30822486249099),
		};

		int rand = (int) (Math.random() * images.length);
		return images[rand];
	}

	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping("/submit")
	public String submit(@RequestBody Map<String, Object> payload) {
		Image image = new Image(payload.get("imageId").toString(), payload.get("url").toString(),
				Double.parseDouble(payload.get("latitude").toString()),
				Double.parseDouble(payload.get("longitude").toString()));

		GeoCoordinates guess = new GeoCoordinates(Double.parseDouble(payload.get("lat").toString()),
				Double.parseDouble(payload.get("lng").toString()));

		GeoCoordinates imageCoordinates = new GeoCoordinates(image.getLatitude(), image.getLongitude());

		Distance distance = new Distance(imageCoordinates, guess);
		int score = Integer.parseInt(payload.get("score").toString());

		// I had to rip this for now since we aren't using ActiveGame
		double dis = (distance.getDistance());
		int result = 0;

		if ((dis >= 1) && (dis <= 2)) {
			result = 2;
		}

		else if (dis < 1) {
			result = 5;
		}

		score += result;
		return String.valueOf(score);
	}
}
