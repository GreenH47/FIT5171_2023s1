package fit5171.monash.edu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

class PassengerTest {
    private Passenger passenger;
    @BeforeEach
    void init() {
        //passenger = new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", 908);
        //passenger = new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "123456789", "908");
        passenger = new Passenger("Jane","Doe",22,"Man","aa@nn.com","0488256354","cardnum","pass123",123);
        //public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String cardNumber, String passport)
        //
    }

//    @Test
//    void testCreateValidFemalePassenger() {
//        assertNotNull(new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", "908"));
//    }
//
//    @Test
//    void testCreateValidMalePassenger() {
//        assertNotNull(new Passenger("John", "Doe", 22, "Male", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", "908"));
//    }

//    @Test
//    void testCreateValidOtherGenderPassenger() {
//        assertNotNull(new Passenger("Jane", "Doe", 22, "Other", "abc@admain.com", "0488256354", "AB8976754", "5674635271624728", ""));
//    }

    @Test
    void testCreatePassengerWithInvalidGender() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            new Passenger("Jane", "Doe", 22, "xxx", "aa@nn.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("Gender can only be Male Female or Other", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setGender("xxx"));
    }

    @Test
    void testCreateValidNullGenderPassenger() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            new Passenger("Jane", "Doe", 22, null, "aa@nn.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("Gender can only be Male Female or Other", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setGender(null));
    }

    @Test
    void testNullFirstNameInConstructor() {

//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger(null, "Doe", 22, "Female", "aa@nn.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("First/second name or last name cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setFirstName(null));
    }

    @Test
    void testNullSecondNameInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", null, 22, "Female", "aa@nn.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("First/second name or last name cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setSecondName(null));
    }

    @Test
    void testNegativeAgeInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", -10, "Female", "aa@nn.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("Age can only be within 1-98", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setAge(0));
    }



    @Test
    void testNullEmailInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", 30, "Male", null,"0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("Email address cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setEmail(null));
    }

    @Test
    void testNullPhoneNumberInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", 30, "Male", "aa.com","0488256354","cardnum","pass123");
//        });
//        Assertions.assertEquals("Phone number cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setPhoneNumber(null));
    }

    @Test
    void testNullCardNumberInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", 30, "Male", "aa@nn.com","0488256354",null,"pass123");
//        });
//        Assertions.assertEquals("Card number cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setCardNumber(null));
    }

    @Test
    void testNullPassportNumberInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", 30, "Male", "aa@nn.com","0488256354","cardnum","fafafadpass123");
//        });
//        Assertions.assertEquals("Passport number cannot be empty", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setPassport(null));
    }

    @Test
    void testInvalidSecurityCodeInConstructor() {
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger = new Passenger("Jane", "Doe", 30, "Male", "abd@domain.com", "0488256354", "AB8976754", "5674635271624728", 90008);
//        });
//        Assertions.assertEquals("Invalid cvc number:Cvc number should be 3 digits", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setSecurityCode(1123));
    }


    @Test
    void testSetValidPhoneNumberStartsWith05() {
        String phone = "0512345678";
        String expectedResult = "0512345678";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(expectedResult, passenger.getPhoneNumber());
        //assertThrows(IllegalArgumentException.class, () -> passenger.setPhoneNumber("0512345678"));
    }

    @Test
    void testSetValidPhoneNumberStartsWith04() {
        String phone = "0412345678";
        String expectedResult = "0412345678";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(expectedResult, passenger.getPhoneNumber());
    }

    @Test
    void testSetValidPhoneNumberStartsWith61() {
        String phone = "+61412345678";
        String expectedResult = "+61412345678";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(expectedResult, passenger.getPhoneNumber());
    }

//    @Test
//    void testSetPhoneNumberLengthExceed9() {
//        String phone = "6112345678000";
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger.setPhoneNumber(phone);
//        });
//        Assertions.assertEquals("Invalid phone number:phone number should starts with 04/05/61 with length 9", e.getMessage());
//    }

    @Test
    void testSetPhoneNumberContainsLetter() {
//        String phone = "qwe1213ec";
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger.setPhoneNumber(phone);
//        });
//        Assertions.assertEquals("Invalid phone number:phone number should starts with 04/05/61 with length 9", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setPhoneNumber("fasfaf"));
    }

    @Test
    void testValidEmail() {
        String email = "xyz@abcde.com";
        String expectedResult = "xyz@abcde.com";
        passenger.setEmail(email);
        Assertions.assertEquals(expectedResult, passenger.getEmail());
    }

    @Test
    void testInvalidEmail() {
//        String email = "xyz@abcdecom";
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger.setEmail(email);
//        });
//        Assertions.assertEquals("Invalid Email address:username and domain can only be letters and must end with .com", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setEmail("22@.com"));
    }

    @Test
    void testValidPassport() {
        String passport = "ex0989078";
        String expectedResult = "ex0989078";
        passenger.setPassport(passport);
        Assertions.assertEquals(expectedResult, passenger.getPassport());
    }

    @Test
    void testPassportNumberMoreThan9Characters() {
//        String passport = "ex0989078099";
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger.setPassport(passport);
//        });
//        Assertions.assertEquals("Invalid passport number:passport number must contain 9 characters", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> passenger.setPassport("0512345678ss"));
    }

    @Test
    void testValidCardNumber() {
        String cardNumber = "1234234565434567";
        String expectedResult = "1234234565434567";
        passenger.setCardNumber(cardNumber);
        Assertions.assertEquals(expectedResult, passenger.getCardNumber());
    }

//    @Test
//    void testInvalidCardNumber() {
//        String cardNumber = "9ascece12e";
//        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
//            passenger.setCardNumber(cardNumber);
//        });
//        Assertions.assertEquals("Invalid card number:Card number should be 16 digits", e.getMessage());
//    }


}