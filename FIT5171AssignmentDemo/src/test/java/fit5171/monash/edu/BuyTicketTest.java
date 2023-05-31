package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)//option 1.1
class BuyTicketTest {

    private BuyTicket buyTicket;
    private static Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
    private static Flight flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline",
            Timestamp.valueOf("2007-09-23 10:10:10.0"), Timestamp.valueOf("2007-09-23 10:10:10.0"), airplane);
    private static Ticket ticket1 = new Ticket(1123, 700, flight, false, null);

    @BeforeAll
    public static void init() {

        //mock static class TicketCollection
        MockedStatic<TicketCollection> mocked = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        // mock static method TicketCollection.getTicketInfo
        mocked.when(() -> TicketCollection.getTicketInfo(1123)).thenReturn(ticket1);
        //mock static class FlightCollection
        MockedStatic<FlightCollection> mockedFlight = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
        // mock static method FlightCollection.getFlightInfo
        mockedFlight.when(() -> FlightCollection.getFlightInfo(1)).thenReturn(flight);
        //mock static method in non-static class Airplane.getAirPlaneInfo()
        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
        airplaneMockedStatic.when(() -> Airplane.getAirPlaneInfo(3343)).thenReturn(airplane);
    }

    @Test
    void testBuyTicketEnterInvalidEmail() {
        //Example to test scanner input
        //https://www.danvega.dev/blog/2020/12/16/testing-standard-in-out-java/
        String data2 = "@email.com";
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        buyTicket = new BuyTicket();

        // 改成mock + when
        ticket1 = new Ticket(1123, 700, flight, false, null);

        try {
            buyTicket.buyTicket(1123);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Assert null because an invalid email cannot create a passenger success
        assertNull(ticket1.getPassenger());
        // 可以写成assert throw
    }

    @Test
    void testBuyTicketEnterValidEmail() {
        String data2 = String.format("123@gmail.com\n1");
        System.setIn(new ByteArrayInputStream(data2.getBytes()));// this should be set before new Scanner(System.in)
        buyTicket = new BuyTicket();

        try {
            buyTicket.buyTicket(1123);
            assertEquals("123@gmail.com", ticket1.getPassenger().getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void summarizesTwoNumbers() {
        String data2 = String.format("1\n3");
        System.setIn(new ByteArrayInputStream(data2.getBytes()));// this should be set before new Scanner(System.in)

        BuyTicket buyTicket1 = new BuyTicket();
        assertEquals(4, buyTicket1.sumOfNumbersFromSystemIn());
//
//        Airplane mockAirplane = Mockito.mock(Airplane.class);
//        when(mockAirplane.getAirplaneID()).thenReturn(1);
    }
}