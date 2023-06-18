package fit5171.monash.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.util.Date;
class TicketMockTest {
    private Flight mockFlight;
    private Passenger mockPassenger;
    private Ticket ticket;


    @BeforeEach
    void setUp() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        ticket = new Ticket();

        // Set up mock Flight object with some data
        when(mockFlight.getFlightID()).thenReturn(123);
        when(mockFlight.getDepartFrom()).thenReturn("London");
        when(mockFlight.getDepartTo()).thenReturn("New York");
        when(mockFlight.getDateFrom()).thenReturn(new Timestamp(new Date().getTime()));
        when(mockFlight.getDateTo()).thenReturn(new Timestamp(new Date().getTime()));

        // Set up mock Passenger object with some data
        when(mockPassenger.getFirstName()).thenReturn("John");
        when(mockPassenger.getSecondName()).thenReturn("Smith");
        when(mockPassenger.getEmail()).thenReturn("john.smith@example.com");

        ticket.setPassenger(mockPassenger);
        ticket.setFlight(mockFlight);
        ticket.setTicket_id(111);

        //ticket = new Ticket(1, 100, flight, false, passenger);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testTicketStatus() {
        ticket.setTicketStatus(true);
        assert(ticket.ticketStatus() == true);

        ticket.setTicketStatus(false);
        assert(ticket.ticketStatus() == false);
    }

    @Test
    public void testTicketPrice() {
        int expectedPrice = 500;
        when(mockPassenger.getAge()).thenReturn(25);
        ticket.setPrice(expectedPrice);
        int expectedFinalPrice = (int) (expectedPrice * 1.12); // 12% service tax added to the discounted price
        assertEquals(expectedFinalPrice, ticket.getPrice());
    }

    @Test
    public void testTicketPriceWithAgeDiscount() {
        int expectedPrice = 500;
        when(mockPassenger.getAge()).thenReturn(10);
        ticket.setPrice(expectedPrice);
        int expectedFinalPrice = (int) (expectedPrice *0.5* 1.12); // 12% service tax added to the discounted price
        assertEquals(expectedFinalPrice, ticket.getPrice());
    }

    @Test
    public void testTicketPriceWithElderDiscount() {
        int expectedPrice = 500;
        when(mockPassenger.getAge()).thenReturn(60);
        ticket.setPrice(expectedPrice);
        int expectedFinalPrice = 0; // 12% service tax added to the discounted price
        assertEquals(expectedFinalPrice, ticket.getPrice());
    }

//    @Test
//    public void testTicketPriceWithServiceTax() {
//        ticket.setPrice(100);
//        assert(ticket.getPrice() == 110);
//    }

    @Test
    public void testTicketFlight() {
        assert(ticket.getFlight() == mockFlight);
    }

    @Test
    public void testTicketPassenger() {
        assert(ticket.getPassenger() == mockPassenger);
    }

}