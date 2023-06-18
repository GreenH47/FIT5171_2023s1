package fit5171.monash.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
class TicketCollectionMockTest {
    private ArrayList<Ticket> mockTickets;
    private static Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);;


//    static {
//        try {
//            airplane = new Airplane(3343, "A330", 8, 72, 6);
//        } catch (SeatLimitExceededException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //private static Flight flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline",Timestamp.valueOf("2007-09-23 10:10:10.0"), Timestamp.valueOf("2007-09-23 10:10:10.0"), airplane);
    //private static Ticket ticket1 = new Ticket(1123, 700, flight, false, null);
    private static Flight flight;
    //flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10", airplane);

//    static {
//        try {
//            flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10", airplane);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @BeforeEach
    void setUp() {
//        //mock static class TicketCollection
//        MockedStatic<TicketCollection> mocked = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
//        // mock static method TicketCollection.getTicketInfo
//        mocked.when(() -> TicketCollection.getTicketInfo(1123)).thenReturn(ticket1);
//        //mock static class FlightCollection
//        MockedStatic<FlightCollection> mockedFlight = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
//        // mock static method FlightCollection.getFlightInfo
//        mockedFlight.when(() -> FlightCollection.getFlightInfo(1)).thenReturn(flight);
//        //mock static method in non-static class Airplane.getAirPlaneInfo()
//        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
//        airplaneMockedStatic.when(() -> Airplane.getAirPlaneInfo(3343)).thenReturn(airplane);

        mockTickets = new ArrayList<>();
        Ticket mockTicket1 = mock(Ticket.class);
        Ticket mockTicket2 = mock(Ticket.class);
        when(mockTicket1.getTicket_id()).thenReturn(123);
        when(mockTicket2.getTicket_id()).thenReturn(456);
        when(mockTicket1.toString()).thenReturn("Ticket{\nPrice=500KZT, \nMock Flight\nVip status=true\nMock Passenger\nTicket was purchased=true\n}");
        when(mockTicket2.toString()).thenReturn("Ticket{\nPrice=750KZT, \nMock Flight\nVip status=false\nMock Passenger\nTicket was purchased=false\n}");


        mockTickets.add(mockTicket1);
        mockTickets.add(mockTicket2);

        TicketCollection.tickets = mockTickets;
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void testAddTickets() {
        assertEquals(2, TicketCollection.tickets.size());
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        Ticket mockTicket3 = mock(Ticket.class);
        ticketsToAdd.add(mockTicket3);

        TicketCollection.addTickets(ticketsToAdd);

        assertEquals(3, TicketCollection.tickets.size());
    }

    @Test
    public void testGetAllTickets() {
        TicketCollection.getAllTickets();
        // Assert that the output or expected behavior is correct
        // Redirect console output for testing purposes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        TicketCollection.getAllTickets();

        // Check that the method displays the correct output
        String expectedOutput = "Available tickets:\nTicket{\nPrice=500KZT, \nMock Flight\nVip status=true\nMock Passenger\nTicket was purchased=true\n}\nTicket{\nPrice=750KZT, \nMock Flight\nVip status=false\nMock Passenger\nTicket was purchased=false\n}\n";
        //assertEquals(expectedOutput, outputStream.toString());
        String actualOutput = outputStream.toString().replaceAll("\\r\\n", "\n");

        // Check that the method displays the correct output
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetTicketInfo() {
        Ticket ticket = TicketCollection.getTicketInfo(123);
        //assertNotNull(ticket);
        assertEquals(123, ticket.getTicket_id());
    }

//    @Test
//    public void testGetTicketInfo() {
//        int ticketId = 123;
//        Ticket mockTicket1 = mock(Ticket.class);
//        when(mockTicket1.getTicket_id()).thenReturn(ticketId);
//        mockTickets.add(mockTicket1);
//
//        assertEquals(mockTicket1, TicketCollection.getTicketInfo(ticketId));
//    }

    @Test
    void getTickets() {
    }

    @Test
    void addTickets() {
    }

    @Test
    void getAllTickets() {
    }

    @Test
    void getTicketInfo() {
    }
}