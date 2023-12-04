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
	public Image image(@RequestParam(value = "counter", defaultValue = "0") String counter) {
		Image[] images = new Image[] {
			new Image("1", "http://localhost:8080/20230914_160750916_iOS.jpg", 38.8329, -77.309),
			new Image("2", "http://localhost:8080/20230914_161632.jpg", 38.8294, -77.3057),
			new Image("3", "http://localhost:8080/20230914_161029040_iOS.jpg", 38.82981566714652,
			-77.30781445053643),
			
			new Image("4", "http://localhost:8080/IMG_3139.png", 38.83200733000247, -77.30822486249099),
			new Image("5", "http://localhost:8080/IMG_4.png", 38.8320666667, -77.3052055556),
		};
		
		int index = Integer.parseInt(counter);
		if (index >= images.length) {
			index = 0;
		}
		
		return images[index];
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
		int difficulty = Integer.parseInt(payload.get("difficulty").toString()); // should be a number between 1, 2, and 3
		
		// I had to rip this for now since we aren't using ActiveGame
		double dis = (distance.getDistance());
		int result = 0;
		
		if(difficulty == 1) { // Difficulty: Easy
			if (dis <= 0.1) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.5) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.75) {
				result = 5; // Medium score for somewhat close guesses
			} else if (dis <= 1.5) {
				result = 3; // Low-medium score for moderately close guesses
			} else if (dis <= 3) {
				result = 1; // Lower score for distances between 1.5 and 3
			}
		}
		else if(difficulty == 2) { // Difficulty: Medium
			if (dis <= 0.05) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.1) {
				result = 9; // Very high score for very close guesses
			} else if (dis <= 0.2) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.5) {
				result = 5; // Medium-high score for somewhat close guesses
			} else if (dis <= 1) {
				result = 3; // Medium score for moderately close guesses
			} else if (dis <= 2) {
				result = 1; // Lower score for distances between 1 and 2
			}
		}
		else { // Difficulty: Hard
			if (dis <= 0.02) {
				result = 10; // Highest score for extremely close guesses
			} else if (dis <= 0.05) {
				result = 9; // Very high score for very close guesses
			} else if (dis <= 0.1) {
				result = 7; // High score for close guesses
			} else if (dis <= 0.25) {
				result = 5; // Medium-high score for somewhat close guesses
			} else if (dis <= 0.5) {
				result = 3; // Medium score for moderately close guesses
			} else if (dis <= 1) {
				result = 1; // Lower score for distances between 0.5 and 1
			}
		}
		
		score += result;
		return String.valueOf(score);
	}
}
