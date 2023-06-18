package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

//import static fit5171.monash.edu.FlightCollection.addFlights;
//import static fit5171.monash.edu.FlightCollection.getFlightInfo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightCollectionTest {
    ArrayList<Flight> flights = new ArrayList<>();
    Flight flight1;
    Flight flight2;
    Flight flight3;
    private Airplane mockAirplane() {
        Airplane airplane = mock(Airplane.class);
        when(airplane.getAirplaneID()).thenReturn(101);
        when(airplane.getAirplaneModel()).thenReturn("Boeing 747");
        when(airplane.getBusinessSitsNumber()).thenReturn(20);
        when(airplane.getEconomySitsNumber()).thenReturn(270);
        when(airplane.getCrewSitsNumber()).thenReturn(10);
        return airplane;
    }


    @BeforeEach
    void setup() throws ParseException {
        flights = new ArrayList<>();
        flight1 = new Flight(1001, "Melbourne", "Sydney", "ATA1001",
                "Australia Flight", "15/06/2023 23:15:00", "16/06/2023 00:45:00", mockAirplane());
        flight2 = new Flight(1002, "Sydney", "Melbourne", "ATA1001",
                "Australia Flight", "15/06/2023 23:15:00", "16/06/2023 00:45:00", mockAirplane());
        flight3 = flight1;
        flights.add(flight1);
        flights.add(flight2);
        //flights.add(flight3);
    }

    @Test
    void testIsFlightsValid(){
//        assertEquals(2, flights.size());
//        //valid flights add
//        FlightCollection.addFlights(flights);
//        assertEquals(2, FlightCollection.getFlights().size());

        // same flightid add to list
        ArrayList<Flight> flight3s = new ArrayList<>();
        flight3s.add(flight3);
        assertThrows(IllegalArgumentException.class, () -> FlightCollection.addFlights(flight3s));
    }

    @Test
    void testGetFlightInfo(){
        FlightCollection.addFlights(flights);
        assertEquals(flight1, FlightCollection.getFlightInfo("Sydney", "Melbourne"));

        //assertThrows(IllegalArgumentException.class, () -> FlightCollection.getFlightInfo("Beijing", "Melbourne"));

        assertEquals(flight2, FlightCollection.getFlightInfo("Sydney"));
        //assertThrows(IllegalArgumentException.class, () -> FlightCollection.getFlightInfo("Beijing"));

        assertEquals(flight2, FlightCollection.getFlightInfo(1002));
        //assertThrows(IllegalArgumentException.class, () -> FlightCollection.getFlightInfo(100002));
    }

    @Test
    void testAddNullFlights() {
//        Flight flight = new Flight();
//        flight = null;
        assertThrows(IllegalArgumentException.class, () -> {
            FlightCollection.addFlights(null);
        });
    }

    @Test
    void testGetnullFlightInfo() {
        assertThrows(IllegalArgumentException.class, () -> FlightCollection.validateCity(null));
    }
    @Test
    void testInvalidCoty() {
        assertThrows(IllegalArgumentException.class, () -> FlightCollection.getFlightInfo(null));
//        assertThrows(IllegalArgumentException.class, () -> {
//            FlightCollection.getFlightInfo(null);
//        });
    }

    @Test
    void testGetFlightInfoTwo() {
        assertThrows(IllegalArgumentException.class, () -> {
            FlightCollection.getFlightInfo(null);
        });
    }

//    @Test
//    void testIfFind(){
//        assertEquals(2, flights.size());
//        //FlightCollection.addFlights(flights);
//        //valid flights add
////        FlightCollection.addFlights(flights);
////        assertEquals(2, FlightCollection.getFlights().size());
//
//        assertEquals(flight2, FlightCollection.getFlightInfo("Sydney"));
//        assertEquals(flight1, FlightCollection.getFlightInfo("Melbourne"));
//
//
//    }
}