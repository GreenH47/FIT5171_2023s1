//package fit5171.monash.edu;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Timestamp;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockedStatic;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.ByteArrayInputStream;
//import java.sql.Timestamp;
//import java.text.ParseException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.*;
//@ExtendWith(MockitoExtension.class)
//class TicketSystemTest {
//    private TicketSystem ticketSystem;
//    //private Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
//    private Airplane airplane;
//
////    private Airplane mockAirplane() {
////        Airplane airplane = mock(Airplane.class);
////        when(airplane.getAirplaneID()).thenReturn(101);
////        when(airplane.getAirplaneModel()).thenReturn("Boeing 747");
////        when(airplane.getBusinessSitsNumber()).thenReturn(20);
////        when(airplane.getEconomySitsNumber()).thenReturn(270);
////        when(airplane.getCrewSitsNumber()).thenReturn(10);
////        return airplane;
////    }
//
//
////    static {
////        try {
////            airplane = new Airplane(3343, "A330", 8, 72, 6);
////        } catch (SeatLimitExceededException e) {
////            throw new RuntimeException(e);
////        }
////    }
//
//    //private Flight flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10",airplane);
//    private Flight flight;
//    //private static Flight flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline", Timestamp.valueOf("2007-09-23 10:10:10.0"), Timestamp.valueOf("2007-09-23 10:10:10.0"), airplane);
//
//
////    static {
////        try {
////            flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10", airplane);
////        } catch (ParseException e) {
////            throw new RuntimeException(e);
////        }
////    }
//    private Person person;
////    private  static Person mockPerson() {
////        Person person = mock(Person.class);
////        when(person.getFirstName()).thenReturn("John");
////        when(person.getSecondName()).thenReturn("Doe");
////        when(person.getAge()).thenReturn(25);
////        when(person.getGender()).thenReturn("Man");
////        return person;
////    }
//
//    private Passenger passenger;
//    //private  static Passenger passenger = new Passenger(mockPerson(),"john.doe@example.com", "0421 123 456", "123456789", "1234");
//
//    private Ticket ticket1 = new Ticket(1123, 700, flight, false, passenger);
//
////    TicketSystemTest() throws SeatLimitExceededException, ParseException {
////    }
//    //private static Ticket ticket1 = new Ticket(1123, 700, flight, false, passenger);
//
//
////    @BeforeAll
////    void init() {
//////        Airplane airplane1 = mock(Airplane.class);
//////        when(airplane.getAirplaneID()).thenReturn(3343);
//////        when(airplane.getAirplaneModel()).thenReturn("A330");
//////        when(airplane.getBusinessSitsNumber()).thenReturn(8);
//////        when(airplane.getEconomySitsNumber()).thenReturn(72);
//////        when(airplane.getCrewSitsNumber()).thenReturn(6);
////
//////        flight = new Flight(1001, "Melbourne", "Sydney", "ATA1001",
//////                "Australia Flight", "15/06/2023 23:15:00", "16/06/2023 00:45:00", airplane1);
//////
////
////
////    }
//
//    @BeforeEach
//    void setUp() {
//        Airplane airplane = mock(Airplane.class);
//        Flight flight1 = mock(Flight.class);
//        //airplane = new Airplane(3343, "A330", 8, 72, 6);
//        //flight = new Flight(1, "Guang zhou", "Shang Hai", "FF7700", "China Airline","23/09/24 10:10:10", "23/09/24 12:10:10",airplane);
//
//        //mock static class TicketCollection
//        MockedStatic<TicketCollection> mocked = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
//        // mock static method TicketCollection.getTicketInfo
//        mocked.when(() -> TicketCollection.getTicketInfo(1123)).thenReturn(ticket1);
//
//        //mock static class FlightCollection
//        MockedStatic<FlightCollection> mockedFlight = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
//        // mock static method FlightCollection.getFlightInfo
//        mockedFlight.when(() -> FlightCollection.getFlightInfo(1)).thenReturn(flight);
//        //mock static method in non-static class Airplane.getAirPlaneInfo()
//        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
//        airplaneMockedStatic.when(() -> Airplane.getAirPlaneInfo(3343)).thenReturn(airplane);
//
//
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void testBuyTicketEnterInvalidEmail() {
//        //Example to test scanner input
//        //https://www.danvega.dev/blog/2020/12/16/testing-standard-in-out-java/
//        String data2 = "@email.com";
//        System.setIn(new ByteArrayInputStream(data2.getBytes()));
//        ticketSystem = new TicketSystem();
//
//
//        ticket1 = new Ticket(1123, 700, flight, false, null);
//        //ticketSystem.
//        try {
//            ticketSystem.buyTicket(1123);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        // Assert null because an invalid email cannot create a passenger success
//        assertNull(ticket1.getPassenger());
//        // assert throw
//    }
//
//    @Test
//    void testBuyTicketEnterValidEmail() {
//        String data2 = String.format("123@gmail.com\n1");
//        System.setIn(new ByteArrayInputStream(data2.getBytes()));// this should be set before new Scanner(System.in)
//        ticketSystem = new TicketSystem();
//
//        try {
//            ticketSystem.buyTicket(1123);
//            //assertEquals("123@gmail.com", ticket1.getPassenger().getEmail());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Test
//    public void summarizesTwoNumbers() {
//        String data2 = String.format("1\n3");
//        System.setIn(new ByteArrayInputStream(data2.getBytes()));// this should be set before new Scanner(System.in)
//
//        ticketSystem = new TicketSystem();
//        //assertEquals(4, ticketSystem.sumOfNumbersFromSystemIn());
////
////        Airplane mockAirplane = Mockito.mock(Airplane.class);
////        when(mockAirplane.getAirplaneID()).thenReturn(1);
//    }
//
////    @Test
////    public void testChooseTicketWithValidCities() {
////        // Test that a valid city pair returns an available ticket
////        try {
////            ticketSystem.chooseTicket("Guang zhou", "Shang Hai");
////            Ticket availableTicket = ticketCollection.getTicketInfo(1);
////            assertNotNull(availableTicket);
////            assertFalse(availableTicket.ticketStatus());
////        } catch (Exception e) {
////            fail("An exception occurred: " + e.getMessage());
////        }
////    }
//
////    @Test
////    public void testChooseTicketWithInvalidCity() {
////        // Test that choosing an invalid city pair throws an exception
////        try {
////            ticketSystem.chooseTicket("CityA", "InvalidCity");
////            fail("Expected an exception to be thrown.");
////        } catch (Exception e) {
////            assertEquals("Invalid cities selected, please try again.", e.getMessage());
////        }
////    }
//    @Test
//    void showTicket() {
//    }
//
//    @Test
//    void buyTicket() {
//    }
//
//    @Test
//    void testBuyTicket() {
//    }
//
//    @Test
//    void chooseTicket() {
//    }
//}