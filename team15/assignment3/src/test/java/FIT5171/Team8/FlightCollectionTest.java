package FIT5171.Team8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FlightCollectionTest {

    Flight flight1, flight2;
    ArrayList<Flight> flights;
    Throwable exception;

    @BeforeEach
    void setup(){
        flight1 = mock(Flight.class);
        flight2 = mock(Flight.class);
        flights = new ArrayList<Flight>();
        flights.add(flight1);
        flights.add(flight2);
        when(flight1.getFlightID()).thenReturn(1);
        when(flight2.getFlightID()).thenReturn(2);

    }

    @AfterEach
    void afterEach(){
        FlightCollection.flights.clear();
    }

    @Test
    void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<FlightCollection> constructor = FlightCollection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        FlightCollection instance = constructor.newInstance();
        assertNotNull(instance);
    }

    @Test
    void testVerifyCityName(){
        assertFalse(FlightCollection.verifyCityName("1000"));
        assertTrue(FlightCollection.verifyCityName("Sydney"));
    }

    @Test
    void testAddFlights() {
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("testTwo");
        when(flight2.getDepartFrom()).thenReturn("testThree");
        when(flight2.getDepartTo()).thenReturn("testFour");
        when(flight1.getFlightID()).thenReturn(1);

        FlightCollection.addFlights(flights);
        assertEquals(2, FlightCollection.getFlights().size());
    }

    @Test
    void testAddFlightsWithInvalidCityName(){
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("testTwo");
        when(flight2.getDepartFrom()).thenReturn("3");
        when(flight2.getDepartTo()).thenReturn("4");
        exception = assertThrows(RuntimeException.class, () -> {
            FlightCollection.addFlights(flights);
        });
        assertEquals("The city name is invalid.", exception.getMessage());
        assertEquals(1, FlightCollection.getFlights().size());
    }

    @Test
    void TestAddFlight(){
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("test{}}");
        assertThrows(RuntimeException.class, () -> {
            FlightCollection.addFlight(flight1);
        });
        assertEquals(0, FlightCollection.getFlights().size());
    }

    @Test
    void testAddFlightsWithExistingFlight(){
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("testTwo");
        when(flight2.getDepartFrom()).thenReturn("testThree");
        when(flight2.getDepartTo()).thenReturn("testFour");
        FlightCollection.addFlights(flights);

        exception = assertThrows(RuntimeException.class, () -> {
            FlightCollection.addFlight(flight1);
        });
        assertEquals("1 is already existing.", exception.getMessage());
    }

    @Test
    void testGetFlights(){
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("testTwo");
        when(flight2.getDepartFrom()).thenReturn("testThree");
        when(flight2.getDepartTo()).thenReturn("testFour");
        FlightCollection.addFlights(flights);

        assertEquals(flights, FlightCollection.getFlights());
    }

    @Test
    void testGetFlightInfo(){
        when(flight1.getDepartFrom()).thenReturn("testOne");
        when(flight1.getDepartTo()).thenReturn("testTwo");
        when(flight2.getDepartFrom()).thenReturn("testThree");
        when(flight2.getDepartTo()).thenReturn("testFour");
        FlightCollection.addFlights(flights);

        assertEquals(flight1, FlightCollection.getFlightInfo("testOne", "testTwo"));
        assertEquals(flight2, FlightCollection.getFlightInfo("testThree", "testFour"));
        assertThrows(RuntimeException.class, () -> {
            FlightCollection.getFlightInfo("testOne", "testFour");
        });

        assertEquals(flight1, FlightCollection.getFlightInfo("testTwo"));
        assertEquals(flight2, FlightCollection.getFlightInfo("testFour"));

        assertEquals(flight1, FlightCollection.getFlightInfo(1));
        assertEquals(flight2, FlightCollection.getFlightInfo(2));
    }

    @Test
    void testIsCityNameValid(){
        boolean result = FlightCollection.verifyCityName("000");
        assertFalse(result);
        boolean result1 = FlightCollection.verifyCityName("{{{");
        assertFalse(result1);
        boolean result3 = FlightCollection.verifyCityName("AAA");
        assertTrue(result3);
        boolean result4 = FlightCollection.verifyCityName("zzz");
        assertTrue(result4);
        boolean result5 = FlightCollection.verifyCityName("BBB");
        assertTrue(result5);
        boolean result6 = FlightCollection.verifyCityName("yyy");
        assertTrue(result6);
    }

    @Test
    void testGetNonExistentFlightInfo(){
        Throwable exception;

        exception = assertThrows(RuntimeException.class, () -> {
            FlightCollection.getFlightInfo("testOne", "testTwo");
        });
        assertEquals("No such flight exists.", exception.getMessage());

        exception = assertThrows(RuntimeException.class, () -> {
            FlightCollection.getFlightInfo("testTwo");
        });
        assertEquals("No such flight exists.", exception.getMessage());

        exception = assertThrows(RuntimeException.class, () -> {
            FlightCollection.getFlightInfo(1);
        });
        assertEquals("No such flight exists.", exception.getMessage());
    }
}