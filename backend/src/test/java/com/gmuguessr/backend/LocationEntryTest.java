
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LocationEntryTest {
	
	@Test
	public void testConstructor1() {
		LocationEntry location = new LocationEntry(38.831549515249264, -77.30925088670938);
		assertEquals(38.831549515249264, location.latitude);
		assertEquals(-77.30925088670938, location.longitude);
	}
	
	@Test
	public void testConstructor2() {
		LocationEntry location = null;
		assertNull(location);
	}
	
	@Test
	public void testContructor3() {
		LocationEntry location = new LocationEntry();
		assertEquals(location.latitude, 0);
		assertEquals(location.longitude, 0);
	}

	@Test
	public void testGetLatitude1() {
		LocationEntry location = new LocationEntry(38.831549515249264, -77.30925088670938);
		double lat = location.getLatitude();
		assertEquals(38.831549515249264, lat);
	}
	
	@Test
	public void testGetLongitude1() {
		LocationEntry location = new LocationEntry(38.831549515249264, -77.30925088670938);
		double lon = location.getLongitude();
		assertEquals(-77.30925088670938, lon);
	}
	
	@Test
	public void testGetLatitude2() {
		LocationEntry location = new LocationEntry(38.82845222400069, -77.30750412978368);
		double lat = location.getLatitude();
		assertEquals(38.82845222400069, lat);
	}

	@Test
	public void testGetLongitude2() {
		LocationEntry location = new LocationEntry(38.82845222400069, -77.30750412978368);
		double lon = location.getLongitude();
		assertEquals(-77.30750412978368, lon);
	}
	
	@Test
	public void testGetLatitude3() {
		LocationEntry location = new LocationEntry(38.82861573045127, -77.30228500682882);
		double lat = location.getLatitude();
		assertEquals(38.82845222400069, lat);
	}

	@Test
	public void testGetLongitude3() {
		LocationEntry location = new LocationEntry(38.82861573045127, -77.30228500682882);
		double lon = location.getLongitude();
		assertEquals(-77.30750412978368, lon);
	}
	
	@Test
	public void testSetLatitude1() {
		LocationEntry location = new LocationEntry();
		double lat = 38.831549515249264; 
		location.setLatitude(lat);
		assertEquals(38.831549515249264, lat);
	}
	
	public void testSetLongitude1() {
		LocationEntry location = new LocationEntry();
		double lon = -77.30925088670938;
		location.setLongitude(lon);
		assertEquals(-77.30925088670938, lon);
	}
	
}
