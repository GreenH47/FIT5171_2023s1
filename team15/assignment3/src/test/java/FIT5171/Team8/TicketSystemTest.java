package FIT5171.Team8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


class TicketSystemTest {

    Airplane airplane_1, airplane_2, airplane_3;
    Passenger passenger;
    Ticket ticket, ticketConnection_1, ticketConnection_2;
    Flight flight, flightConnection_1, flightConnection_2;
    TicketSystem ticketSystem;

    String city1 = "cityOne";
    String city2 = "cityTwo";
    String connectCity = "cityThree";

    Throwable exception;

    @BeforeEach
    void setup(){
        airplane_1 = mock(Airplane.class);
        airplane_2 = mock(Airplane.class);
        airplane_3 = mock(Airplane.class);

        passenger = mock(Passenger.class);

        ticket = mock(Ticket.class);
        ticketConnection_1 = mock(Ticket.class);
        ticketConnection_2 = mock(Ticket.class);

        flight = mock(Flight.class);
        flightConnection_1 = mock(Flight.class);
        flightConnection_2 = mock(Flight.class);

    }

    @AfterEach
    void afterEach(){
        FlightCollection.flights.clear();
        AirplaneCollection.airplanes.clear();
        TicketCollection.tickets.clear();
    }

    @Test
    void testVerifyCityName(){
        assertFalse(TicketSystem.verifyCityName("1000"));
        assertFalse(TicketSystem.verifyCityName("Sydney123"));
        assertTrue(TicketSystem.verifyCityName("Sydney"));
    }

    @Test
    void testVerifyTicketStatus(){
        TicketCollection.tickets.add(ticket);
        when(ticket.getTicket_id()).thenReturn(1);
        when(ticket.ticketStatus()).thenReturn(false);
        assertTrue(TicketSystem.verifyTicketStatus(1));

        when(ticket.ticketStatus()).thenReturn(true);
        exception = assertThrows(RuntimeException.class, () -> {
            assertTrue(TicketSystem.verifyTicketStatus(1));
        });
        assertEquals("This ticket is booked, please choose another one.", exception.getMessage());
    }

    @Test
    void testValidatePassengerInfo(){
        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "18\n" + "Man\n" + "test@monash.com\n" + "0423456789\n" + "2000000\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        ticketSystem.setPassengerInfo();
        assertEquals("2000000" ,ticketSystem.passenger.getPassport());

        System.setIn(new ByteArrayInputStream((
                "1111\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.",exception.getMessage());

        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "11111\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("Last name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.",exception.getMessage());

        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "18\n" + "M\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("Invalid gender. Gender should be one of the following: 'Woman', 'Man', 'Non-binary|gender diverse', 'Prefer not to say', 'Other'",exception.getMessage());

        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "18\n" + "Man\n" + "test\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("Invalid email.",exception.getMessage());

        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "18\n" + "Man\n" + "test@monash.com\n" + "042345\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("Invalid phone number.",exception.getMessage());

        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "18\n" + "Man\n" + "test@monash.com\n" + "0423456789\n" + "20000000000\n"
        ).getBytes()));
        ticketSystem = new TicketSystem();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            ticketSystem.setPassengerInfo();
        });
        assertEquals("Passport number cannot be more than 9 characters long.",exception.getMessage());
    }

    @Test
    void testValidateFlightInfo(){
        assertNull(TicketSystem.getFlightByCity(city1, city2));

        FlightCollection.flights.add(flight);
        when(flight.getDepartFrom()).thenReturn(city1);
        when(flight.getDepartTo()).thenReturn(city2);
        assertEquals(flight, TicketSystem.getFlightByCity(city1, city2));
    }

    @Test
    void testBuyTicketWithDirectFlight() throws Exception {
        FlightCollection.flights.add(flight);
        AirplaneCollection.airplanes.add(airplane_1);
        TicketCollection.tickets.add(ticket);

        when(flight.getDepartFrom()).thenReturn(city1);
        when(flight.getDepartTo()).thenReturn(city2);
        when(flight.getAirplane()).thenReturn(airplane_1);
        when(flight.getAirplane().getAirplaneID()).thenReturn(1);

        when(ticket.getTicket_id()).thenReturn(1);
        when(ticket.ticketStatus()).thenReturn(false);
        when(ticket.getFlight()).thenReturn(flight);
        when(ticket.getFlight().getFlightID()).thenReturn(1);
        when(ticket.getPrice()).thenReturn(100);
        when(ticket.getFlight().getDepartFrom()).thenReturn(city1);
        when(ticket.getFlight().getDepartTo()).thenReturn(city2);

        System.setIn(new ByteArrayInputStream(("1\n" +
                "FirstName\n" + "SecondName\n" + "18\n" + "Man\n" + "test@monash.com\n" + "0423456789\n" + "2000000\n" +
                "1\n"+
                "1000\n2000\n").getBytes()));

        ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket(city1,city2);
    }

    @Test
    void testBuyTicketNoDirectFlight() throws Exception {

        FlightCollection.flights.add(flightConnection_1);
        FlightCollection.flights.add(flightConnection_2);
        AirplaneCollection.airplanes.add(airplane_2);
        AirplaneCollection.airplanes.add(airplane_3);
        TicketCollection.tickets.add(ticketConnection_1);
        TicketCollection.tickets.add(ticketConnection_2);

        when(flightConnection_1.getFlightID()).thenReturn(2);
        when(flightConnection_1.getDepartFrom()).thenReturn(city1);
        when(flightConnection_1.getDepartTo()).thenReturn(connectCity);
        when(flightConnection_1.getAirplane()).thenReturn(airplane_2);
        when(flightConnection_1.getAirplane().getAirplaneID()).thenReturn(2);

        when(flightConnection_2.getFlightID()).thenReturn(3);
        when(flightConnection_2.getDepartFrom()).thenReturn(connectCity);
        when(flightConnection_2.getDepartTo()).thenReturn(city2);
        when(flightConnection_2.getAirplane()).thenReturn(airplane_3);
        when(flightConnection_2.getAirplane().getAirplaneID()).thenReturn(3);

        when(ticketConnection_1.getFlight()).thenReturn(flightConnection_1);
        when(ticketConnection_2.getFlight()).thenReturn(flightConnection_2);
        when(ticketConnection_1.getPrice()).thenReturn(100);
        when(ticketConnection_2.getPrice()).thenReturn(200);
        when(ticketConnection_1.getTicket_id()).thenReturn(2);
        when(ticketConnection_2.getTicket_id()).thenReturn(3);


        System.setIn(new ByteArrayInputStream((
                "FirstName\n" + "SecondName\n" + "10\n" + "Man\n" + "test@monash.com\n" + "0423456789\n" + "2000000\n" +
                 "1\n"+
                "1000\n1000\n").getBytes()));

        ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket(city1,city2);
    }

    //Test for ticket class
    @Test
    void testTicketClass(){
        Ticket ticket = new Ticket();
        //TicketSystem.

    }
}