package com.gmuguessr.backend;

import com.gmuguessr.backend.User;
import com.gmuguessr.backend.UserManager;
import com.gmuguessr.backend.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        // Initialize or inject the UserManager before each test
        userManager = new UserManager();
    }

    @Test
    void testUserLogin() {
        // Test user login functionality

        // Create a user for testing
        User user = new User("Alice", UserType.newOnCampusStudent, 1);

        // Register the user
        userManager.registerUser(user);

        // Try to log in with correct credentials
        boolean loginResult = userManager.loginUser("Alice", UserType.newOnCampusStudent, 1);

        // Check if login is successful
        assertTrue(loginResult, "Login should be successful with correct credentials");

        // Try to log in with incorrect credentials
        boolean wrongLoginResult = userManager.loginUser("Bob", UserType.newOnCampusStudent, 2);

        // Check if login fails with incorrect credentials
        assertFalse(wrongLoginResult, "Login should fail with incorrect credentials");
    }
}

