package FIT5171.Team8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class FlightTest {
    Flight flight;
    Airplane airplane;
    Throwable exception;

    @BeforeEach
    void setup(){
        airplane = mock(Airplane.class);
        flight = new Flight();

    }

    @Test
    void testFlightID() {
        assertEquals(0,flight.getFlightID());
        flight.setFlightID(1);
        assertEquals(1,flight.getFlightID());
    }

    @Test
    void testConstructor(){
        Flight flight1 = new Flight(1, "beijing", "shanghai", "boing747", "china filght", Timestamp.valueOf("2023-05-19 10:30:00.000"), Timestamp.valueOf("2023-05-19 13:30:00.000"), airplane);
        assertEquals(1,flight1.getFlightID());
        assertEquals("beijing", flight1.getDepartTo());
        assertEquals("shanghai", flight1.getDepartFrom());
        assertEquals("boing747", flight1.getCode());
        assertEquals("china filght", flight1.getCompany());
        assertEquals("19/05/2023 10:30:00", flight1.getDateFrom());
        assertEquals("19/05/2023 13:30:00", flight1.getDateTo());
        assertEquals(airplane, flight1.getAirplane());
    }


    @Test
    void testDepartTo() {
        flight.setDepartTo("Sydney");
        assertEquals("Sydney",flight.getDepartTo());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo("test001");
        });
        assertEquals("This city name is invalid!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo("test{}");
        });
        assertEquals("This city name is invalid!", exception.getMessage());

        flight.setDepartFrom("Shanghai");
        assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartTo("Shanghai");
        }, "Departure and Destination cities cannot be the same.");

    }

    @Test
    void testDepartFrom() {
        flight.setDepartFrom("Sydney");
        assertEquals("Sydney",flight.getDepartFrom());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartFrom("test001");
        });
        assertEquals("This city name is invalid!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            flight.setDepartFrom("test{}");
        });
        assertEquals("This city name is invalid!", exception.getMessage());
    }

    @Test
    void testCode() {
        flight.setCode("C10000");
        assertEquals("C10000",flight.getCode());
    }

    @Test
    void testCompany() {
        flight.setCompany("QANTAS");
        assertEquals("QANTAS",flight.getCompany());
    }

    @Test
    void testSetDateFrom() {
        // this.dateTo is null);
        flight.setDateFrom(Timestamp.valueOf("2022-05-23 15:20:30.000"));
        assertEquals("23/05/2022 15:20:30", flight.getDateFrom());

        // this.dateTo is after dateFrom
        flight.setDateTo(Timestamp.valueOf("2022-05-25 15:20:30.000"));
        Timestamp dateFrom2 = Timestamp.valueOf("2022-05-24 15:20:30.000");
        flight.setDateFrom(dateFrom2);
        assertEquals("24/05/2022 15:20:30", flight.getDateFrom());

        // this.dateTo is before dateFrom
        assertThrows(RuntimeException.class, () -> flight.setDateFrom(Timestamp.valueOf("2022-05-26 15:20:30.000")));

        //dateTo = dateFrom
        assertThrows(RuntimeException.class, () -> flight.setDateFrom(Timestamp.valueOf("2022-05-25 15:20:30.000")));

        flight.setDateFrom(Timestamp.valueOf("2022-05-25 15:20:29.999"));
        assertEquals("25/05/2022 15:20:29", flight.getDateFrom());
        assertThrows(RuntimeException.class, () -> flight.setDateFrom(Timestamp.valueOf("2022-05-25 15:20:30.001")), "The time of dateTo must AFTER time of dateFrom!!!");

    }

    @Test
    void testSetDateTo() {
        //date from is null
        flight.setDateTo(Timestamp.valueOf("2022-05-25 15:20:30.000"));
        assertEquals("25/05/2022 15:20:30", flight.getDateTo());

        // this.dateTo is after dateFrom
        flight.setDateFrom(Timestamp.valueOf("2022-05-23 15:20:30.000"));
        Timestamp dateTo2 = Timestamp.valueOf("2022-05-24 15:20:30.000");
        flight.setDateTo(dateTo2);
        assertEquals("24/05/2022 15:20:30", flight.getDateTo());

        assertThrows(RuntimeException.class, () -> flight.setDateTo(Timestamp.valueOf("2022-05-22 15:20:30.000")));
        assertThrows(RuntimeException.class, () -> flight.setDateTo(Timestamp.valueOf("2022-05-23 15:20:30.000")));

        flight.setDateTo(Timestamp.valueOf("2022-05-23 15:20:30.001"));
        assertEquals("23/05/2022 15:20:30", flight.getDateTo());
        assertThrows(RuntimeException.class, () -> flight.setDateTo(Timestamp.valueOf("2022-05-23 15:20:29.999")), "The time of dateTo must AFTER time of dateFrom!!!");
    }

    @Test
    void testAirplane(){
        flight.setAirplane(airplane);
        assertEquals(airplane, flight.getAirplane());
    }

    @Test
    void testIsCityNameValid(){
        boolean result = Flight.verifyCityName("000");
        assertFalse(result);
        boolean result1 = Flight.verifyCityName("{{{");
        assertFalse(result1);
        boolean result3 = Flight.verifyCityName("AAA");
        assertTrue(result3);
        boolean result4 = Flight.verifyCityName("zzz");
        assertTrue(result4);
        boolean result5 = Flight.verifyCityName("BBB");
        assertTrue(result5);
        boolean result6 = Flight.verifyCityName("yyy");
        assertTrue(result6);
    }

    @Test
    void testToString(){
        Flight flight1 = new Flight(0, "beijing", "shanghai", "CN747", "china filght", Timestamp.valueOf("2023-05-19 10:30:00.000"), Timestamp.valueOf("2023-05-19 13:30:00.000"), new Airplane(1, "boeing747", 50, 50, 50));
        assertEquals("Flight{Airplane{airplaneID=1', model=boeing747', business sits=50', economy sits=50', crew sits=50'}, date to=19/05/2023 13:30:00, ', date from='19/05/2023 10:30:00', depart from='shanghai', depart to='beijing', code=CN747', company=china filght', code=CN747'}",flight1.toString());
    }

}