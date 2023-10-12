
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class GeoCoordinatesTest {
	
	@Test
	public void testConstructor1() {
		GeoCoordinates location = new GeoCoordinates(38.831549515249264, -77.30925088670938);
		assertEquals(38.831549515249264, location.getLatitude());
		assertEquals(-77.30925088670938, location.getLatitude());
	}
	
	@Test
	public void testConstructor2() {
		GeoCoordinates location = null;
		assertNull(location);
	}
	
	@Test
	public void testContructor3() {
		GeoCoordinates location = new GeoCoordinates();
		assertEquals(location.getLatitude(), 0);
		assertEquals(location.getLatitude(), 0);
	}

	@Test
	public void testGetLatitude1() {
		GeoCoordinates location = new GeoCoordinates(38.831549515249264, -77.30925088670938);
		double lat = location.getLatitude();
		assertEquals(38.831549515249264, lat);
	}
	
	@Test
	public void testGetLongitude1() {
		GeoCoordinates location = new GeoCoordinates(38.831549515249264, -77.30925088670938);
		double lon = location.getLongitude();
		assertEquals(-77.30925088670938, lon);
	}
	
	@Test
	public void testGetLatitude2() {
		GeoCoordinates location = new GeoCoordinates(38.82845222400069, -77.30750412978368);
		double lat = location.getLatitude();
		assertEquals(38.82845222400069, lat);
	}

	@Test
	public void testGetLongitude2() {
		GeoCoordinates location = new GeoCoordinates(38.82845222400069, -77.30750412978368);
		double lon = location.getLongitude();
		assertEquals(-77.30750412978368, lon);
	}
	
	@Test
	public void testGetLatitude3() {
		GeoCoordinates location = new GeoCoordinates(38.82861573045127, -77.30228500682882);
		double lat = location.getLatitude();
		assertEquals(38.82845222400069, lat);
	}

	@Test
	public void testGetLongitude3() {
		GeoCoordinates location = new GeoCoordinates(38.82861573045127, -77.30228500682882);
		double lon = location.getLongitude();
		assertEquals(-77.30750412978368, lon);
	}
	
	@Test
	public void testSetLatitude1() {
		GeoCoordinates location = new GeoCoordinates();
		double lat = 38.831549515249264; 
		location.setLatitude(lat);
		assertEquals(38.831549515249264, lat);
	}
	
	public void testSetLongitude1() {
		GeoCoordinates location = new GeoCoordinates();
		double lon = -77.30925088670938;
		location.setLongitude(lon);
		assertEquals(-77.30925088670938, lon);
	}
	
}
