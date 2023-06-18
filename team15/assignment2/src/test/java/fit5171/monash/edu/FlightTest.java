package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
* When a flight is being added to the system, following conditions must be met.
1. All fields are required. Note: Mock the behaviour of the Airplane
* class while creating objects of the Flight class for unit testing.
*
2. Date must be in DD/MM/YY format.
*
3. Time must be in HH:MM:SS format.
*
4. Ensure the same flight is not already in the system
* */

class FlightTest {
    private Flight flight;

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
        flight = new Flight(1001, "Melbourne", "Sydney", "ATA1001",
                "Australia Flight", "15/06/2023 23:15:00", "16/06/2023 00:45:00", mockAirplane());
    }

    @Test
    void testFlightContainsAirplaneDetails() {
        assertEquals(1001, flight.getFlightID());
        assertEquals("Melbourne", flight.getDepartTo());
        assertEquals("Sydney", flight.getDepartFrom());
        assertEquals("ATA1001", flight.getCode());
        assertEquals("Australia Flight", flight.getCompany());
        assertEquals("15/06/2023 23:15:00", flight.getDateFromString());
        assertEquals("16/06/2023 00:45:00", flight.getDateToString());
    }

//    @Test
//    void testAddFlight() throws ParseException {
//        Flight flight2 = new Flight(1002, "Melbourne", "Sydney", "ATA1001",
//                "Australia Flight", "15/07/2023 23:15:00", "16/07/2023 00:45:00", mockAirplane());
//        Flight flight1 = new Flight();
//        assertEquals(0, flights.size());
//        Flight.addFlight(flight);
//        Flight.addFlight(flight2);
//        assertEquals(2, Flight.flights.size());
//        Flight.addFlight(flight2);
//        assertEquals(2, Flight.flights.size());
//        Flight.addFlight(flight1);
//        assertEquals(2, Flight.flights.size());
//    }

    @Test
    void testRequiredFields(){
        assertThrows(ParseException.class, () -> new Flight(1002, "Melbourne", "Sydney",
                "ATA1001", "Australia Flight", "2023-07-15 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(ParseException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "ATA1001", "Australia Flight", "15/07/2023 23:15:00",
                "2023-07-16 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "ATA1001", "Australia Flight", "17/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(0, "Melbourne", "Sydney",
                "ATA1001", "Australia Flight", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Melbourne",
                "ATA1001", "Australia Flight", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "ATA1001", "", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "ATA1001", "  ", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "", "Australia Flight", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));

        assertThrows(IllegalArgumentException.class, () -> new Flight(1004, "Melbourne", "Sydney",
                "  ", "Australia Flight", "15/07/2023 23:15:00",
                "16/07/2023 00:45:00", mockAirplane()));
    }

}