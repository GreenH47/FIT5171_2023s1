package FIT5171.Team8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TicketCollectionTest {

    Ticket ticket1, ticket2;
    ArrayList<Ticket> tickets;

    @BeforeEach
    void setup(){
        ticket1 = mock(Ticket.class);
        ticket2 = mock(Ticket.class);
        tickets = new ArrayList<Ticket>();;
        tickets.add(ticket1);
        tickets.add(ticket2);
        when(ticket1.getTicket_id()).thenReturn(1);
        when(ticket2.getTicket_id()).thenReturn(2);

    }

    @AfterEach
    void afterEach(){
        TicketCollection.tickets.clear();
    }

    @Test
    void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<TicketCollection> constructor = TicketCollection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        TicketCollection instance = constructor.newInstance();
        assertNotNull(instance);
    }

    @Test
    void testAddTicket() throws Exception {
        when(ticket1.ticketStatus()).thenReturn(false);
        when(ticket2.ticketStatus()).thenReturn(false);

        TicketCollection.addTicket(ticket1);
        assertEquals(1, TicketCollection.tickets.size());
        TicketCollection.addTicket(ticket2);
        assertEquals(2, TicketCollection.tickets.size());
        
        ArrayList<Ticket> ticketsTest = new ArrayList<Ticket>();
        ticketsTest.add(ticket1);
        ticketsTest.add(ticket2);
        assertEquals(ticketsTest, TicketCollection.getTickets());
        //TicketCollection.getTicketInfo(1).getTicket_id();

        Ticket ticket3 = new Ticket();
        TicketCollection.addTicket(ticket3);
        assertEquals(ticket3, TicketCollection.getTicketInfo(0));
    }
    @Test
    void testAddTicketFailed() throws Exception {
        Throwable exception;
        when(ticket1.ticketStatus()).thenReturn(true);
        exception = assertThrows(RuntimeException.class, () -> {
            TicketCollection.addTicket(ticket1);
        });
        assertEquals("1 has been booked.", exception.getMessage());

    }

    @Test
    void testAddTickets() throws Exception {
        when(ticket1.ticketStatus()).thenReturn(false);
        when(ticket2.ticketStatus()).thenReturn(false);
        TicketCollection.addTickets(tickets);

        assertEquals(2, TicketCollection.tickets.size());

    }

    @Test
    void testAddTicketsFailed() throws Exception {
        Throwable exception;
        when(ticket1.ticketStatus()).thenReturn(false);
        when(ticket2.ticketStatus()).thenReturn(true);
        exception = assertThrows(RuntimeException.class, () -> {
            TicketCollection.addTickets(tickets);
        });

        assertEquals("2 has been booked.", exception.getMessage());

    }

    @Test
    void  getTicketInfoTest(){
        Throwable exception;
        when(ticket1.ticketStatus()).thenReturn(false);
        TicketCollection.addTickets(tickets);

        Ticket result = TicketCollection.getTicketInfo(1);
        assertEquals(ticket1, result);

        exception = assertThrows(RuntimeException.class, () -> {
            TicketCollection.getTicketInfo(3);
        });
        assertEquals("3 doesn't exit.", exception.getMessage());

    }

    @Test
    void getAllTicketTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));//Create a ByteArrayOutputStream to capture the output
        when(ticket1.ticketStatus()).thenReturn(false);
        when(ticket2.ticketStatus()).thenReturn(false);
        TicketCollection.addTickets(tickets);
        TicketCollection.getAllTickets();

        //Verify the output
        assertEquals(ticket1.toString() + ticket2.toString(), outputStream.toString());

    }

    //new test case below
    @Test
    void testGetTicketInfo() throws Exception {
        Ticket ticket = new Ticket();
        assertEquals(0, ticket.getTicket_id());
        TicketCollection.addTicket(ticket);
        assertEquals(ticket, TicketCollection.getTicketInfo(0));
        Ticket ticket1 = new Ticket();
        TicketCollection.addTicket(ticket1);
        //assertEquals(ticket1, TicketCollection.getTicketInfo(0));
    }

}
