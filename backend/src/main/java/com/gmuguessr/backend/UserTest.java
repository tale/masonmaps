import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
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
}
