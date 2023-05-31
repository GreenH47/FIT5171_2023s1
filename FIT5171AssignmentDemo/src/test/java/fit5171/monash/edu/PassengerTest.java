package fit5171.monash.edu;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class PassengerTest {

    @Test
    void testSetEmailValid() {
        Passenger passenger = new Passenger();
        String email = "abc@dome.com";
        passenger.setEmail(email);
        assertEquals(email, passenger.getEmail());
    }

    @Test
    void testSetEmailInvalid() {

        Passenger passenger = new Passenger();
//        Passenger passenger = mock(Passenger.class);

        String email = "@dome.com";
        assertThrows(PatternSyntaxException.class, () -> {
            passenger.setEmail(email);
        });
    }

    @Test
    void testGetEmail() {

        Passenger passenger = new Passenger();
//        Passenger passenger = mock(Passenger.class);

        assertEquals(null, passenger.getEmail());
    }
}