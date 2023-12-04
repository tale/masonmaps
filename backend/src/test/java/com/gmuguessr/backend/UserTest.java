package com.gmuguessr.backend;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize a User instance before each test
        user = new User("First Last", UserType.newOnCampusStudent, 24);
    }

    @Test
    public void testSetName() {
        user.setName("John Doe");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testSetUserType() {
        user.setUserType(UserType.currentOnCampusStudent);
        assertEquals(UserType.currentOnCampusStudent, user.getUserType());
    }

    @Test
    public void testSetUserID() {
        user.setUserID(12345);
        assertEquals(12345, user.getUserID());
    }

    @Test
    public void testSetNameWithNull() {
        // Test that setName handles null input
        user.setName(null);
        assertNull(user.getName());
    }

    @Test
    public void testSetUserTypeWithNull() {
        // Test that setUserType handles null input
        user.setUserType(null);
        assertNull(user.getUserType());
    }
    
    @Test
    public void testEquals() {
    	User x = new User("Rachel");
    	User y = new User("Rachel");
    	User z = new User("Deckard");
    	String hmp = "AA";
    	
    	assertTrue(x.equals(x));
    	assertFalse(x.equals(hmp));
    	assertTrue(x.equals(y));
    	
    	y.setUserID(43);
    	assertFalse(x.equals(y));
    	
    	y.setUserType(UserType.newFaculty);
    	assertFalse(x.equals(y));
    	assertFalse(x.equals(z));
    }
}