package com.gmuguessr.backend;

import java.sql.ResultSet;
import org.springframework.ui.Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
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
}
