package FIT5171.Team8;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {


    public Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger();
    }



    @Test
    public void testAllFieldsRequired() {
        Passenger incompletePassenger = new Passenger();
        incompletePassenger.setEmail("johndoe@gmail.com");
        incompletePassenger.setPhoneNumber("0423456789");
        incompletePassenger.setPassport("123456789");
        incompletePassenger.setCardNumber("1234567890123456");
        incompletePassenger.setSecurityCode(123);

        assertNull("First name should be null", incompletePassenger.getFirstName());
        assertNull("Last name should be null", incompletePassenger.getSecondName());
        assertEquals( 0, incompletePassenger.getAge());
        assertNull("Gender should be null", incompletePassenger.getGender());

        passenger = new Passenger("Jane","Doe",22,"Man","aa@nn.com","0488256354","cardnum","pass123",123);
    }

    @Test
    public void testPassengerConstructor() {
        String firstName = "John";
        String lastName = "Doe";
        int age = 30;
        String gender = "Man";
        String email = "johndoe@example.com";
        String phoneNumber = "0488256354";
        String passport = "ABC123";
        String cardNumber = "pass123";
        int securityCode = 123;
        passenger = new Passenger(firstName, lastName, age, gender, email, phoneNumber, passport, cardNumber, securityCode);

        //passenger = new Passenger("John", "Doe", 30, "Man", "johndoe@example.com", "0488256354", "ABC123", "pass123", 123);

        assertEquals(firstName, passenger.getFirstName());
        assertEquals(lastName, passenger.getSecondName());
        assertEquals(age, passenger.getAge());
        assertEquals(gender, passenger.getGender());
        assertEquals(email, passenger.getEmail());
        assertEquals(phoneNumber, passenger.getPhoneNumber());
        assertEquals(passport, passenger.getPassport());
        assertEquals(cardNumber, passenger.getCardNumber());
        assertEquals(securityCode, passenger.getSecurityCode());
        String expectedResult = "Passenger{firstName='John', lastName='Doe', age=30, gender='Man', email='johndoe@example.com', phoneNumber='0488256354', passport='ABC123', cardNumber='pass123', securityCode=123}";
        assertEquals(expectedResult, passenger.toString());
    }


    @Test
    public void testPhoneNumberPattern() {
        Throwable exception;

        passenger.setPhoneNumber("0412345678");
        assertEquals("0412345678", passenger.getPhoneNumber());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber("0512345678");
        });
        assertEquals("Invalid phone number.", exception.getMessage());

        passenger.setPhoneNumber("+61412345678");
        assertEquals("+61412345678", passenger.getPhoneNumber());

        assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber("+61512345678");
        });
        assertEquals("Invalid phone number.", exception.getMessage());

        passenger=new Passenger();
        assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber("0412 345 678");
        });
        assertEquals("Invalid phone number.", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber("04123456789");
        });
        assertEquals("Invalid phone number.", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPhoneNumber("0412");
        });
        assertEquals("Invalid phone number.", exception.getMessage());
    }

    @Test
    public void testEmailPattern() {
        Throwable exception;
        passenger.setEmail("johndoe@gmail.com");
        assertEquals("johndoe@gmail.com", passenger.getEmail());

        passenger=new Passenger();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setEmail("johndoe@domain");
        });
        assertEquals("Invalid email.", exception.getMessage());

        passenger=new Passenger();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setEmail("johndoegmail.com");
        });
        assertEquals("Invalid email.", exception.getMessage());

        passenger=new Passenger();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setEmail("");
        });
        assertEquals("Invalid email.", exception.getMessage());
    }

    @Test
    public void testPassportLength() {
        Throwable exception;
        passenger.setPassport("123456789");
        assertEquals("123456789", passenger.getPassport());

        exception = assertThrows(IllegalArgumentException.class, () -> {
                    passenger.setPassport("");
        });
        assertEquals("Passport number cannot be empty.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setPassport("1234567890");
        });
        assertEquals("Passport number cannot be more than 9 characters long.", exception.getMessage());

    }

    //======================
    //new test case from here
    //======================

    @Test
    public void testInvalidPersonInfo() {
        Throwable exception;

        //test invalid first name
        passenger.setFirstName("John");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setFirstName("111");
        });
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setFirstName("A111");
        });
        assertEquals("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        //test invalid last name
        passenger.setSecondName("Doe");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setSecondName("111");
        });
        exception = assertThrows(IllegalArgumentException.class, () -> {
            passenger.setSecondName("A111");
        });
        assertEquals("Last name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());
    }


    
}


