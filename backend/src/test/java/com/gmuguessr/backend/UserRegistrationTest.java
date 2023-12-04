package com.gmuguessr.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testUserRegistration() {

    	UserManager manager = new UserManager(420);
    	
        String username = "testuser";
        String password = "testpassword";
        String email = "testuser@example.com";

        RegistrationResult result = manager.registerUser(username, password, email, UserType.newOnCampusStudent);
        RegistrationResult result2 = manager.registerUser(username, password, email, UserType.newOnCampusStudent);

        // Verify the results
        assertTrue(result.isSuccess(), "User registration should be successful");
        assertNotEquals(result.getUserId(), -1, "User ID should not be -1 after registration");
        
        assertFalse(result2.isSuccess(), "User registration should be unsuccessful");
        assertEquals(result2.getUserId(), -1, "User ID should be -1 after registration");
    }
}