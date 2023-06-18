package fit5171.monash.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {
    Airplane airplane;

    @BeforeEach
    void setUp()
    {
        airplane = new Airplane(101, "Boeing 747",
                20, 270, 10);
    }

    @Test
    void testGetAirplaneID() {
        assertEquals(101, airplane.getAirplaneID());
    }

    @Test
    void testSetAirplaneID() {
        airplane.setAirplaneID(102);
        assertEquals(102, airplane.getAirplaneID());
    }

    @Test
    void testGetAirplaneModel() {
        assertEquals("Boeing 747", airplane.getAirplaneModel());
    }

    @Test
    void testSetAirplaneModel() {
        airplane.setAirplaneModel("Boeing 848");
        assertEquals("Boeing 848", airplane.getAirplaneModel());
    }

    @Test
    void testGetBusinessSitsNumber() {
        assertEquals(20, airplane.getBusinessSitsNumber());
    }

    @Test
    void testGetEconomySitsNumber() {
        assertEquals(270, airplane.getEconomySitsNumber());
    }

    @Test
    void testGetCrewSitsNumber() {
        assertEquals(10, airplane.getCrewSitsNumber());
    }

    @Test
    void testSetInvalidBusinessSitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> airplane.setBusinessSitsNumber(301));
//        assertThrows(SeatLimitExceededException.class, () -> {
//            airplane.setBusinessSitsNumber(301);
//        });
    }

    @Test
    void testSetInvalidEconomySitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> airplane.setEconomySitsNumber(301));
//        assertThrows(SeatLimitExceededException.class, () -> {
//            airplane.setEconomySitsNumber(301);
//        });
    }

    @Test
    void testSetInvalidCrewSitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            airplane.setCrewSitsNumber(301);
        });
    }

    @Test
    void testSetValidBusinessSitsNumber() throws SeatLimitExceededException {
        airplane.setBusinessSitsNumber(10);
        assertEquals(10, airplane.getBusinessSitsNumber());
    }

    @Test
    void testSetValidEconomySitsNumber() throws SeatLimitExceededException {
        airplane.setEconomySitsNumber(10);
        assertEquals(10, airplane.getEconomySitsNumber());
    }

    @Test
    void testSetValidCrewSitsNumber() throws SeatLimitExceededException {
        airplane.setCrewSitsNumber(10);
        assertEquals(10, airplane.getCrewSitsNumber());
    }

    @Test
    void testTotalSitsNumberExceed300() {
        int businessSitsNumber = 50;
        int economySitsNumber = 240;
        int crewSitsNumber = 12;
        int expectedResult = businessSitsNumber + economySitsNumber + crewSitsNumber;
        Airplane airplane1 = new Airplane(101, "Boeing 747",
                1, 1, 1);
        airplane1.setBusinessSitsNumber(businessSitsNumber);
        airplane1.setEconomySitsNumber(economySitsNumber);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            airplane1.setCrewSitsNumber(crewSitsNumber);
        });
//        airplane.setBusinessSitsNumber(businessSitsNumber);
//        airplane.setEconomySitsNumber(economySitsNumber);
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            airplane.setCrewSitsNumber(crewSitsNumber);
//        });
//        Assertions.assertEquals("Total sits number cannot exceed 300", exception.getMessage());
    }

    @Test
    void testGetAirPlaneInfo(){
        Airplane ap = Airplane.getAirPlaneInfo(101);
        //assertEquals(airplane, ap);

        //assertEquals(expectedOutput, outputStream.toString());
        String expectedOutput = airplane.toString().replaceAll("\\r\\n", "\n");
        String actualOutput = ap.toString().replaceAll("\\r\\n", "\n");
        // Check that the method displays the correct output
        assertEquals(expectedOutput, actualOutput);
    }
}