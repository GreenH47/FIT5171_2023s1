package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FlightTest {

    // before all need to set field and beforeAll class as static
//    private static Flight mockFlight;
//    @BeforeAll
//    public static void init()
//    {
//        mockFlight = mock(Flight.class);
//    }

    private Flight mockFlight;

    @BeforeEach
    public void init()
    {
        mockFlight = mock(Flight.class);
    }
    @Test
    public void testFlightID() {
        //Flight mockFlight = mock(Flight.class);
        // 错误用法，mock object不能使用set value改变field
        //mockFlight.setFlightID(123);
        when(mockFlight.getFlightID()).thenReturn(123);
        assertEquals(123, mockFlight.getFlightID());
    }

//    @Test
//    public void testFlightIDUsingSpy() {
//        //Flight mockFlight = spy(Flight.class);
//        //when(mockFlight.getFlightID()).thenReturn(123);
//        mockFlight.setFlightID(123);
//        assertEquals(123, mockFlight.getFlightID());
//    }

//    @Test
//    public void testFlightCodeUsingSpy() {
//        //Flight mockFlight = spy(Flight.class);
//        //when(mockFlight.getFlightID()).thenReturn(123);
//        mockFlight.setFlightID(123);
//        when(mockFlight.getCode()).thenReturn("123");
//        assertEquals(123, mockFlight.getFlightID());
//        assertEquals("123", mockFlight.getCode());
//    }

    @Test
    public void testFlightAirplane() {
        // 如何在mocked object里面mock field
        //Flight mockFlight = mock(Flight.class);
        Airplane mockAirplane = mock(Airplane.class);
        when(mockFlight.getAirplane()).thenReturn(mockAirplane);
        when(mockFlight.getAirplane().getAirplaneID()).thenReturn(1234);

//        mockFlight.setFlightID(123);
//        when(mockFlight.getCode()).thenReturn("123");
        //assertEquals(123, mockFlight.getFlightID());
        assertEquals(1234, mockFlight.getAirplane().getAirplaneID());
    }
}