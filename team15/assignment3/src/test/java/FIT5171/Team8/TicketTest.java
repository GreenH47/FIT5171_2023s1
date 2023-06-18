package FIT5171.Team8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketTest {
    Ticket ticket;
    Passenger passenger;
    Flight flight;
    Throwable exception;
    Airplane airplane;

    @BeforeEach
    void setup() {
        ticket = new Ticket();
//        passenger = mock(Passenger.class);
//        airplane = mock(Airplane.class);
//        flight = mock(Flight.class);
        passenger = new Passenger();
        airplane = new Airplane();
        flight = new Flight();

    }

    @AfterEach
    void afterEach() {
        FlightCollection.flights.clear();
    }

    @Test
    void testConstructor() {
        //Flight flight1 = new Flight(0, "beijing", "shanghai", "boing747", "china filght", Timestamp.valueOf("2023-05-19 10:30:00.000"), Timestamp.valueOf("2023-05-19 13:30:00.000"), airplane);
        passenger = new Passenger("John", "Doe", 30, "Man", "johndoe@example.com", "0488256354", "ABC123", "pass123", 123);
        airplane = new Airplane(5, "boeing747", 50, 50, 50);
        flight = new Flight(0, "beijing", "shanghai", "boing747", "china filght", Timestamp.valueOf("2023-05-19 10:30:00.000"), Timestamp.valueOf("2023-05-19 13:30:00.000"), airplane);
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        assertEquals(0, ticket.getTicket_id());

        ticket = new Ticket(1, 100, flight, true, passenger);
        assertEquals(1, ticket.getTicket_id());
        assertEquals(100, ticket.getPrice());
        assertEquals(flight, ticket.getFlight());
        assertTrue(ticket.getClassVip());
        assertEquals(passenger, ticket.getPassenger());

        String expectedResult = "Ticket{\n" +
                "Ticket Id: 1\n" +
                "Price = 100KZT, \n" +
                "Flight{Airplane{airplaneID=5', model=boeing747', business sits=50', economy sits=50', crew sits=50'}, date to=19/05/2023 13:30:00, ', date from='19/05/2023 10:30:00', depart from='shanghai', depart to='beijing', code=boing747', company=china filght', code=boing747'}\n" +
                "Vip status = true\n" +
                "Passenger{firstName='John', lastName='Doe', age=30, gender='Man', email='johndoe@example.com', phoneNumber='0488256354', passport='ABC123', cardNumber='pass123', securityCode=123}\n" +
                "Ticket was purchased = false\n" +
                "}";
        assertEquals(expectedResult, ticket.toString());
    }

    @Test
    void testTicketID() {
        Ticket ticket = new Ticket();
        ticket.setClassVip(true);

//        int ticketID = ticket.getTicket_id();
//        assertEquals(0, ticketID);
        assertEquals(0, ticket.getTicket_id());


        int expectedId = 123;
        ticket.setTicket_id(expectedId);
        assertEquals(expectedId, ticket.getTicket_id());

        ticket.setTicket_id(1);
        assertEquals(1, ticket.getTicket_id());
    }

    @Test
    void testClassVip() {
        assertFalse(ticket.getClassVip());
        ticket.setClassVip(true);
        assertTrue(ticket.getClassVip());
    }

    @Test
    void testStatus() {
        assertFalse(ticket.ticketStatus());
        ticket.setTicketStatus(true);
        assertTrue(ticket.ticketStatus());
    }

    @Test
    void testSetPassenger() {
        assertEquals(null, ticket.getPassenger());
//        when(passenger.getEmail()).thenReturn("test@gmail.com");
//        when(passenger.getPhoneNumber()).thenReturn("0423456789");
//        when((passenger.getPassport())).thenReturn("121345678");
        passenger.setEmail("test@gmail.com");
        passenger.setPhoneNumber("0423456789");
        passenger.setPassport("121345678");
        ticket.setPassenger(passenger);

        assertEquals(passenger, ticket.getPassenger());

    }

    @Test
    void testSetPassengerWithInvalidInfo() {
        Passenger passenger = new Passenger();
        assertEquals(null, passenger.getEmail());
//        when(passenger.getEmail()).thenReturn("invalidEmail");
//

        assertThrows(IllegalArgumentException.class, () -> {
            passenger.setEmail("invalid_email");
            new Ticket(1, 100, new Flight(), true, passenger);
        });
//
//        when(passenger.getEmail()).thenReturn("test@gmail.com");
//        when(passenger.getPhoneNumber()).thenReturn("invalidPhoneNumber");
//        exception = assertThrows(IllegalArgumentException.class, () -> {
//            ticket.setPassenger(passenger);
//        });
//        assertEquals("Invalid phone number.", exception.getMessage());
//
//        when(passenger.getEmail()).thenReturn("test@gmail.com");
//        when(passenger.getPhoneNumber()).thenReturn("0423456789");
//        when((passenger.getPassport())).thenReturn("invalidPassport");
//        exception = assertThrows(IllegalArgumentException.class, () -> {
//            ticket.setPassenger(passenger);
//        });
//        assertEquals("Passport number cannot be more than 9 characters long.", exception.getMessage());

    }

    @Test
    void testSetFlight() {
        flight = mock(Flight.class);
        when(flight.getDepartFrom()).thenReturn("Sydney");
        when(flight.getDepartTo()).thenReturn("Shanghai");
        FlightCollection.addFlight(flight);
        ticket.setFlight(flight);

        assertEquals(flight, ticket.getFlight());

        when(flight.getDepartTo()).thenReturn("Sydney");
        assertThrows(IllegalArgumentException.class, () -> {
            ticket.setFlight(flight);
        });

        when(flight.getDepartFrom()).thenReturn("Shanghai");
        when(flight.getDepartTo()).thenReturn("Shanghai");
        assertThrows(IllegalArgumentException.class, () -> {
            ticket.setFlight(flight);
        });

    }


    @Test
    void testSetFlightWithInvalidCItyName() {
        flight = mock(Flight.class);
        when(flight.getDepartFrom()).thenReturn("1");
        when(flight.getDepartTo()).thenReturn("1");
        FlightCollection.flights.add(flight);

        exception = assertThrows(RuntimeException.class, () -> {
            ticket.setFlight(flight);
        });
        assertEquals("This city name is invalid!", exception.getMessage());

    }

    @Test
    void testPrice() {
        passenger = mock(Passenger.class);
        when(passenger.getEmail()).thenReturn("test@gmail.com");
        when(passenger.getPhoneNumber()).thenReturn("0423456789");
        when((passenger.getPassport())).thenReturn("121345678");
        ticket.setPassenger(passenger);

        when(passenger.getAge()).thenReturn(14);
        ticket.setPrice(100);
        assertEquals(56, ticket.getPrice());

        when(passenger.getAge()).thenReturn(15);
        ticket.setPrice(100);
        assertEquals(112, ticket.getPrice());

        when(passenger.getAge()).thenReturn(16);
        ticket.setPrice(100);
        assertEquals(112, ticket.getPrice());

        when(passenger.getAge()).thenReturn(59);
        ticket.setPrice(100);
        assertEquals(112, ticket.getPrice());

        when(passenger.getAge()).thenReturn(60);
        ticket.setPrice(100);
        assertEquals(0, ticket.getPrice());

        when(passenger.getAge()).thenReturn(61);
        ticket.setPrice(100);
        assertEquals(0, ticket.getPrice());

    }

    //test invalid passenger info
    @Test
    void testInvalidPassengerInfo() {
        passenger = mock(Passenger.class);
        when(passenger.getEmail()).thenReturn("test@gmail.com");
        when(passenger.getPhoneNumber()).thenReturn("0423456789");
        when((passenger.getPassport())).thenReturn("121345678");
        ticket.setPassenger(passenger);


        when(passenger.getEmail()).thenReturn("invalidEmail");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setPassenger(passenger);
        });
        assertEquals("Invalid email.", exception.getMessage());

        when(passenger.getEmail()).thenReturn("test@gmail.com");
        when(passenger.getPhoneNumber()).thenReturn("invalidPhoneNumber");
        //when(passenger.getEmail()).thenReturn("invalidEmail");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setPassenger(passenger);
        });
        assertEquals("Invalid phone number.", exception.getMessage());

        when(passenger.getPhoneNumber()).thenReturn("0423456789");
        when((passenger.getPassport())).thenReturn("sdgsdGSgdasgasg");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            ticket.setPassenger(passenger);
        });
        assertEquals("Passport number cannot be more than 9 characters long.", exception.getMessage());
    }

}