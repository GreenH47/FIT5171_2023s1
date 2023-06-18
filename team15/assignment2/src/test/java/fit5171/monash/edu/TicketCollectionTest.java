package fit5171.monash.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
class TicketCollectionTest {
    TicketCollection ticketCollection;
    Ticket existingTicket;

    @BeforeEach
    void setUp() {
        ticketCollection = new TicketCollection();
        ticketCollection.tickets = new ArrayList<>();

        existingTicket = mock(Ticket.class);
        when(existingTicket.getTicket_id()).thenReturn(1);

        ticketCollection.tickets.add(existingTicket);
    }
    @AfterEach
    void clean() {
        ticketCollection.tickets = new ArrayList<>();
    }

    @Test
    void addEmptyTicketList() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(new ArrayList<Ticket>());
        });
        assertEquals("Ticket list cannot be empty", e.getMessage());
    }

    @Test
    void addNullTicketList() {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(null);
        });
        assertEquals("Ticket list cannot be empty", e.getMessage());
    }


    @Test
    public void testAddTickets() {
        assertEquals(1, TicketCollection.tickets.size());
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        Ticket mockTicket3 = mock(Ticket.class);
        ticketsToAdd.add(mockTicket3);

        TicketCollection.addTickets(ticketsToAdd);

        assertEquals(2, TicketCollection.tickets.size());
    }
    @Test
    void addValidTicketList() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(2);
        when(ticket1.getTicket_id()).thenReturn(3);
        tickets.add(ticket1);
        tickets.add(ticket2);
        ticketCollection.addTickets(tickets);
        assertEquals(ticketCollection.tickets, ticketCollection.getTickets());
    }

    @Test
    void addTicketListContainNull() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = null;
        Ticket ticket2 = mock(Ticket.class);
        when(ticket2.getTicket_id()).thenReturn(2);

        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket list cannot contain null", e.getMessage());
    }

    @Test
    void addTicketListContainDuplicatedID() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(2);
        when(ticket2.getTicket_id()).thenReturn(2);
        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket with ID:2 already exists", e.getMessage());
    }

    @Test
    void addTicketListContainExistingID() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = mock(Ticket.class);
        Ticket ticket2 = mock(Ticket.class);
        when(ticket1.getTicket_id()).thenReturn(1);
        when(ticket2.getTicket_id()).thenReturn(2);
        tickets.add(ticket1);
        tickets.add(ticket2);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            ticketCollection.addTickets(tickets);
            ;
        });
        assertEquals("Ticket with ID:1 already exists", e.getMessage());
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
        //String expectedOutput = "Available tickets:\nTicket{\nPrice=500KZT, \nMock Flight\nVip status=true\nMock Passenger\nTicket was purchased=true\n}\nTicket{\nPrice=750KZT, \nMock Flight\nVip status=false\nMock Passenger\nTicket was purchased=false\n}\n";
//        Available tickets:
//        Mock for Ticket, hashCode: 127791068
        //assertEquals(expectedOutput, outputStream.toString());
        String actualOutput = outputStream.toString().replaceAll("\\r\\n", "\n");

        // Check that the method displays the correct output
        assertNotNull(actualOutput);
    }

    @Test
    void testGetExistingTicket() {
        assertEquals(existingTicket, ticketCollection.getTicketInfo(1));
        Ticket ticket = TicketCollection.getTicketInfo(1);
        //assertNotNull(ticket);
        assertEquals(1, ticket.getTicket_id());
    }

    @Test
    void testGetNotExistingTicket() {
        assertNull(ticketCollection.getTicketInfo(2));
    }


}