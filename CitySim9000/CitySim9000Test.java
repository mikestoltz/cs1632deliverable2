import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import org.junit.Test;

import java.util.Random;

public class CitySim9000Test {
	
	// Check that the Location Constructor properly initializes
	// the location's name.  This name returned should be equal to the string we set it to.
	
	@Test
	public void testLocationConstructor() {
		Location coffee = new Location("Coffee");
		assertEquals(coffee.getLocationName(), "Coffee");
	}
	
	// Check that move driver returns a different location than the current one.
	// The location returned from moveDriver should not equal our start location.
	
	@Test
	public void testMoveDriver() {
		Location first = new Location("First Location");
		Location second = new Location("Second Location");
		first.setNorth(second, "Fifth Ave.");
		Random mockRand = mock(Random.class);
		assertNotEquals(first, first.moveDriver(0, mockRand));
	}
	
	// Check that moveDriver returns null when there is no location
	// for the diver to move to.
	
	@Test
	public void testMoveDriverNoWhere() {
		Location only = new Location("Coffee");
		Random mockRand = mock(Random.class);
		assertNull(only.moveDriver(0, mockRand));
	}
	
	// Check that moveDriver moves the driver to the north 
	// and returns a new location. The new location should not be null.
	
	@Test
	public void testMoveDriverNorth() {
		Location start = new Location("Start");
		Random mockRand = mock(Random.class);
		when(mockRand.nextInt(Mockito.anyInt())).thenReturn(0);
		Location mockLocation = mock(Location.class);
		start.setNorth(mockLocation, "Test Ave.");
		assertNotNull(start.moveDriver(0, mockRand));
	}
	
	// Check that moveDriver moves the driver to the east 
	// and returns a new location. The new location should not be null.
		
	@Test
	public void testMoveDriverEast() {
		Location start = new Location("Start");
		Random mockRand = mock(Random.class);
		when(mockRand.nextInt(Mockito.anyInt())).thenReturn(0);
		Location mockLocation = mock(Location.class);
		start.setEast(mockLocation, "Test Ave.");
		assertNotNull(start.moveDriver(0, mockRand));
	}
	
	// Check that moveDriver moves the driver to the south 
	// and returns a new location.  This location should not be null.
			
	@Test
	public void testMoveDriverSouth() {
		Location start = new Location("Start");
		Random mockRand = mock(Random.class);
		when(mockRand.nextInt(Mockito.anyInt())).thenReturn(0);
		Location mockLocation = mock(Location.class);
		start.setSouth(mockLocation, "Test Ave.");
		assertNotNull(start.moveDriver(0, mockRand));
	}
	
	// Check that moveDriver moves the driver to the west 
	// and returns a new location. The new location should not be null.
			
	@Test
	public void testMoveDriverWest() {
		Location start = new Location("Start");
		Random mockRand = mock(Random.class);
		when(mockRand.nextInt(Mockito.anyInt())).thenReturn(0);
		Location mockLocation = mock(Location.class);
		start.setWest(mockLocation, "Test Ave.");
		assertNotNull(start.moveDriver(0, mockRand));
	}
	
	// Check that when the current location is outside the city,
	// the outsideCity method will return true.
	
	@Test
	public void testOutsideCity() {
		Location outside = new Location("Outside City");
		assertTrue(outside.outsideCity());
	}
	
	// Check that when the current location is inside the city,
	// the outsideCity method will return false.
	
	@Test
	public void testInsideCity() {
		Location coffee = new Location("Coffee");
		assertFalse(coffee.outsideCity());
	}
	
	// Check that getLocationName returns a correct location name.
	// The name should equal the string we originally set it to.
	
	@Test
	public void testGetLocationName() {
		Location coffee = new Location("Coffee");
		assertEquals(coffee.getLocationName(), "Coffee");
	}
	
	// Check that getStartLocation returns a valid location.
	// This location should not be null.
	
	@Test
	public void testGetStartLocation() {
		City city = new City(0);
		assertNotNull(city.getStartLocation());
	}

}