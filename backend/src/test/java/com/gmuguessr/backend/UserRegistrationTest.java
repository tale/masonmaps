package com.gmuguessr.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testUserRegistration() {

        String username = "testuser";
        String password = "testpassword";
        String email = "testuser@example.com";

        RegistrationResult result = registerUser(username, password, email);

        // Verify the result
        assertTrue(result.isSuccess(), "User registration should be successful");
        assertNotNull(result.getUserId(), "User ID should not be null after registration");
    }
}