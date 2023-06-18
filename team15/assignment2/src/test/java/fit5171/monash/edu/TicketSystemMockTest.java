package fit5171.monash.edu;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketSystemMockTest {
    TicketSystem ticketSystem;
    Passenger passenger;
    Flight flight;
    Ticket ticket;
    MockedStatic<TicketCollection> mockTicketCollection;
    MockedStatic<FlightCollection> mockFlightCollection;


    private Airplane mockAirplane() {
        Airplane airplane = mock(Airplane.class);
        when(airplane.getAirplaneID()).thenReturn(101);
        when(airplane.getAirplaneModel()).thenReturn("Boeing 747");
        when(airplane.getBusinessSitsNumber()).thenReturn(20);
        when(airplane.getEconomySitsNumber()).thenReturn(270);
        when(airplane.getCrewSitsNumber()).thenReturn(10);
        return airplane;
    }

    private Person mockPerson() {
        Person person = mock(Person.class);
        when(person.getFirstName()).thenReturn("John");
        when(person.getSecondName()).thenReturn("Doe");
        when(person.getAge()).thenReturn(25);
        when(person.getGender()).thenReturn("Man");
        return person;
    }



    @BeforeAll
    void setup() {
        passenger = mock(Passenger.class);
        flight = mock(Flight.class);
        ticket = mock(Ticket.class);
        ticket.setFlight(flight);
//        when(ticket.getPassenger()).thenReturn(new Passenger(mockPerson(),"john.doe@example.com", "0421 123 456", "123456789", "1234"));
//        try {
//            when(ticket.getFlight()).thenReturn(new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10",mockAirplane()));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        when(ticket.getTicket_id()).thenReturn(1123);
//        when(ticket.ticketStatus()).thenReturn(true);
        mockTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
    }

    @Test
    public void testShowTicketWithValidTicket() throws ParseException {
        ticketSystem = new TicketSystem(passenger, flight, ticket);
        //Timestamp dateFrom = Timestamp.valueOf(LocalDateTime.now().plusHours(1));
        //Timestamp dateTo = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
        Airplane airplane = mock(Airplane.class);
        when(ticket.getFlight()).thenReturn(new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", "15/06/2023 23:15:00", "16/06/2023 00:45:00", airplane));
        assertTrue(ticketSystem.showTicket());
    }

//    @Test
//    public void testShowTicket() {
//        ticketSystem = new TicketSystem(passenger, flight, ticket);
//        Airplane airplane = mock(Airplane.class);
//        Flight flight1 = null;
//        try {
//            flight1 = new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", "15/06/2023 23:15:00", "16/06/2023 00:45:00", airplane);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        assertNotNull(flight1);
//        assertEquals("Sydney",flight1.getDepartTo());
//        //when(ticket.getFlight()).thenReturn(flight1);
//        ticket.setFlight(flight1);
//        assertEquals("Sydney",ticket.getFlight().getDepartTo());
//        //assertEquals("11",ticket.toString());
//        assertFalse(ticketSystem.showTicket());
//    }


//    @Test
//    public void testBuyTicketWithInvalidPassengerInfo() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            TicketCollection.tickets = new ArrayList<>();
//            TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//            String input = String.format("John\nDoe\n-10\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888"); // age less than 0
//            System.setIn(new ByteArrayInputStream(input.getBytes()));
//            ticketSystem = new TicketSystem();
//            ticketSystem.buyTicket(1);
//        });
//        assertEquals("Age can only be within 1-98", e.getMessage());
//    }

//    @Test
//    public void testBuyTicketWithInvalidPassengerInfo() {
//        TicketCollection.tickets = new ArrayList<>();
//        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);
//        TicketCollection.tickets.add(ticket1);
//        String input = String.format("John\nDoe\n-10\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888"); // age less than 0
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        ticketSystem = new TicketSystem();
//        assertEquals(ticket1,TicketCollection.getTicketInfo(1));
//        try {
//            ticketSystem.buyTicket(1);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Test
//    public void testBuyTicketWithInvalidFlightInfo() {
//        Throwable e = assertThrows(NullPointerException.class, () -> {
//            when(flight.getAirplane()).thenReturn(null);
//            TicketCollection.tickets = new ArrayList<>();
//            TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//            String input = String.format("John\nDoe\n10\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888");
//            System.setIn(new ByteArrayInputStream(input.getBytes()));
//            buyTicket = new BuyTicket();
//            buyTicket.buyTicket(1);
//        });
//        assertEquals("Cannot invoke \"fit5171.Flight.getAirplane()\" because \"this.flight\" is null", e.getMessage());
//    }
//
//    @Test
//    public void testBuyTicketWithInvalidTicketInfo() {
//        Throwable e = assertThrows(NullPointerException.class, () -> {
//            when(ticket.getFlight()).thenReturn(null);
//            TicketCollection.tickets = new ArrayList<>();
//            TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//            String input = String.format("John\nDoe\n10\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888");
//            System.setIn(new ByteArrayInputStream(input.getBytes()));
//            buyTicket = new BuyTicket();
//            buyTicket.buyTicket(1);
//        });
//        assertEquals("Cannot invoke \"fit5171.Flight.getAirplane()\" because \"this.flight\" is null", e.getMessage());
//    }
//
//    @Test
//    public void testPriceForUnder15() {
//        Timestamp dateFrom = Timestamp.valueOf(LocalDateTime.now().plusHours(1));
//        Timestamp dateTo = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
//        Airplane airplane = mock(Airplane.class);
//        when(airplane.getAirplaneID()).thenReturn(1);
//        flight = new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", dateFrom, dateTo, airplane);
//        FlightCollection.flights = new ArrayList<>();
//        FlightCollection.flights.add(flight);
//        when(ticket.getFlight()).thenReturn(flight);
//        TicketCollection.tickets = new ArrayList<>();
//        TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//        String input = String.format("John\nDoe\n10\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888");
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        when(passenger.getAge()).thenReturn(10);
//        when(flight.getAirplane().getAirplaneID()).thenReturn(1);
//        when(airplane.getEconomySitsNumber()).thenReturn(200);
//        buyTicket = new BuyTicket(passenger, flight, ticket);
//        try {
//            buyTicket.buyTicket(1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assertEquals(1000 * 0.5 * 1.12, ticket.getPrice());
//
//    }
//
//    @Test
//    public void testPriceForOver60() {
//        Timestamp dateFrom = Timestamp.valueOf(LocalDateTime.now().plusHours(1));
//        Timestamp dateTo = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
//        Airplane airplane = mock(Airplane.class);
//        when(airplane.getAirplaneID()).thenReturn(1);
//        flight = new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", dateFrom, dateTo, airplane);
//
//        when(ticket.getFlight()).thenReturn(flight);
//        TicketCollection.tickets = new ArrayList<>();
//        TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//        String input = String.format("John\nDoe\n70\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888");
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        buyTicket = new BuyTicket(passenger, flight, ticket);
//        try {
//            buyTicket.buyTicket(1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assertEquals(0 * 1.12, ticket.getPrice());
//    }
//
//    @Test
//    public void testPriceForBetween15And60() {
//        Timestamp dateFrom = Timestamp.valueOf(LocalDateTime.now().plusHours(1));
//        Timestamp dateTo = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
//        Airplane airplane = mock(Airplane.class);
//        when(airplane.getAirplaneID()).thenReturn(1);
//        flight = new Flight(1, "Sydney", "Melbourne", "xxx", "XXX", dateFrom, dateTo, airplane);
//
//        when(ticket.getFlight()).thenReturn(flight);
//        TicketCollection.tickets = new ArrayList<>();
//        TicketCollection.tickets.add(new Ticket(1, 1000, flight, false, passenger));
//        String input = String.format("John\nDoe\n40\nmale\nabc@domain.com\n0455787585\nea6574899\n1\n1234321234321234\n888");
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        buyTicket = new BuyTicket(passenger, flight, ticket);
//        try {
//            buyTicket.buyTicket(1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        assertEquals(1000 * 1 * 1.12, ticket.getPrice());
//    }

}