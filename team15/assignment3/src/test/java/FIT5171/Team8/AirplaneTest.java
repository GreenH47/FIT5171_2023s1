package FIT5171.Team8;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AirplaneTest {

    Airplane airplane;
    Airplane airplane1;
    @BeforeEach
    void setup(){
        airplane1 = new Airplane();
        airplane = new Airplane(5, "boeing747", 50, 50, 50);
    }

    @Test
    void testAirplaneID(){
        Airplane airplane1 = new Airplane();
        airplane1.setAirplaneID(1);
        assertEquals(1, airplane1.getAirplaneID());
    }

    @Test
    void testAirplaneIDReturnsZero() {
        airplane.setAirplaneID(0);
        assertEquals(0, airplane.getAirplaneID());
    }

    @Test
    void testConstructor(){
        int id = 1;
        String model = "boeing747";
        int businessSitNo = 50;
        int economySitNo = 50;
        int crewSitNo = 50;
        airplane = new Airplane(id, model, businessSitNo, economySitNo, crewSitNo);

        assertEquals(id, airplane.getAirplaneID());
        assertEquals(model, airplane.getAirplaneModel());
        assertEquals(businessSitNo, airplane.getBusinessSitsNumber());
        assertEquals(economySitNo, airplane.getEconomySitsNumber());
        assertEquals(crewSitNo, airplane.getCrewSitsNumber());
        String expected = "Airplane{airplaneID=1', model=boeing747', business sits=50', economy sits=50', crew sits=50'}";
        assertEquals(expected, airplane.toString());
    }

    @Test
    void testSetBusinessSitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(0));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(301));

        airplane1.setBusinessSitsNumber(1);
        assertEquals(1, airplane1.getBusinessSitsNumber());
        airplane1.setBusinessSitsNumber(300);
        assertEquals(300, airplane1.getBusinessSitsNumber());
        airplane1.setBusinessSitsNumber(150);
        assertEquals(150, airplane1.getBusinessSitsNumber());

        assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(500));

        Throwable exception;
        airplane1.setBusinessSitsNumber(1);
        assertEquals(1, airplane1.getBusinessSitsNumber());
        airplane1.setBusinessSitsNumber(300);
        assertEquals(300, airplane1.getBusinessSitsNumber());
        airplane1.setBusinessSitsNumber(150);
        assertEquals(150, airplane1.getBusinessSitsNumber());
        exception = assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(0));
        assertEquals("Seat number must be in the range [1, 300].", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(301));
        assertEquals("Seat number must be in the range [1, 300].", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(-1));
        assertEquals("Seat number must be in the range [1, 300].", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(500));
        assertEquals("Seat number must be in the range [1, 300].", exception.getMessage());
    }

    @Test
    void testSetEconomicSitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> airplane1.setEconomySitsNumber(0));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setEconomySitsNumber(301));

        airplane1.setEconomySitsNumber(1);
        assertEquals(1, airplane1.getEconomySitsNumber());
        airplane1.setEconomySitsNumber(300);
        assertEquals(300, airplane1.getEconomySitsNumber());
        airplane1.setEconomySitsNumber(150);
        assertEquals(150, airplane1.getEconomySitsNumber());

        assertThrows(IllegalArgumentException.class, () -> airplane1.setEconomySitsNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setEconomySitsNumber(500));
    }

    @Test
    void testSetCrewSitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> airplane1.setCrewSitsNumber(0));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setCrewSitsNumber(301));

        airplane1.setCrewSitsNumber(1);
        assertEquals(1, airplane1.getCrewSitsNumber());
        airplane1.setCrewSitsNumber(300);
        assertEquals(300, airplane1.getCrewSitsNumber());
        airplane1.setCrewSitsNumber(150);
        assertEquals(150, airplane1.getCrewSitsNumber());

        assertThrows(IllegalArgumentException.class, () -> airplane1.setCrewSitsNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> airplane1.setCrewSitsNumber(500));
    }

    @Test
    void testBusinessAvailableSeatNo(){
        int economySeatsNumber = 30;
        int crewSeatsNumber = 5;
        airplane1.setEconomySitsNumber(economySeatsNumber);
        airplane1.setCrewSitsNumber(crewSeatsNumber);
        airplane1.setBusinessSitsNumber(265);
        airplane1.setBusinessSitsNumber(1);
        assertThrows(IllegalArgumentException.class, () -> airplane1.setBusinessSitsNumber(266));
    }

    @Test
    void testEconomyAvailableSeatNo(){
        int businessSeatsNumber = 30;
        int crewSeatsNumber = 5;
        airplane1.setBusinessSitsNumber(businessSeatsNumber);
        airplane1.setCrewSitsNumber(crewSeatsNumber);
        airplane1.setEconomySitsNumber(265);
        airplane1.setEconomySitsNumber(1);
        assertThrows(IllegalArgumentException.class, () -> airplane1.setEconomySitsNumber(266));
    }

    @Test
    void testCrewAvailableSeatNo(){
        int economySeatsNumber = 30;
        int businessSeatsNumber = 5;
        airplane1.setEconomySitsNumber(economySeatsNumber);
        airplane1.setBusinessSitsNumber(businessSeatsNumber);
        airplane1.setCrewSitsNumber(265);
        airplane1.setCrewSitsNumber(1);
        assertThrows(IllegalArgumentException.class, () -> airplane1.setCrewSitsNumber(266));
    }

    @Test
    void testAirplaneModel(){
        airplane.setAirplaneModel("Boeing 747");
        assertEquals("Boeing 747", airplane.getAirplaneModel());
    }
}