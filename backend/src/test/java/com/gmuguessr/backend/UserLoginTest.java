import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class UserLoginTest {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        // Initialize or inject the UserManager before each test
        userManager = new UserManager(420);
    }

    @Test
    void testUserLogin() {
    	
    	//Check if initialization is correct.
    	assertEquals(420, userManager.getId());
    	
        // Test user login functionality

        // Create a user for testing
        User user = new User("Alice", UserType.newOnCampusStudent, 1);

        // Register the user
        userManager.registerUser(user);
        
        // Check if registration was successful:
        assertTrue(userManager.getUsers().get(0).equals(user));

        // Try to log in with correct credentials
        boolean loginResult = userManager.loginUser("Alice", UserType.newOnCampusStudent, 1);

        // Check if login is successful
        assertTrue(loginResult, "Login should be successful with correct credentials");

        // Try to log in with incorrect credentials
        boolean wrongLoginResult = userManager.loginUser("Bob", UserType.newOnCampusStudent, 2);
        boolean wrongLoginResult2 = userManager.loginUser("Alice", UserType.newOnCampusStudent, 2);
        boolean wrongLoginResult3 = userManager.loginUser("Alice", UserType.newFaculty, 1);

        // Check if login fails with incorrect credentials
        assertFalse(wrongLoginResult, "Login should fail with incorrect credentials");
        assertFalse(wrongLoginResult2, "Login should fail with incorrect credentials");
        assertFalse(wrongLoginResult3, "Login should fail with incorrect credentials");
    }
}

