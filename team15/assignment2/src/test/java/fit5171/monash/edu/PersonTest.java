package fit5171.monash.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    /* TODO Person class is an abstract class and cannot be create directly
        Related tests have been covered in the PassengerTest class */

//    private Person person;
//    @BeforeEach
//    void setUp() {
//        person = new Person("John", "Doe", 25, "Man");
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    //1. All fields of a Person class are required to create a person
//    @Test
//    public void testRequiredFields() {
//        Person person = new Person();
//        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
//        assertThrows(IllegalArgumentException.class, () -> person.setSecondName(null));
//        assertThrows(IllegalArgumentException.class, () -> person.setAge(0));
//        assertThrows(IllegalArgumentException.class, () -> person.setGender(null));
//    }
//
//    //2. The gender field has following options ‘Woman’, ‘Man’,
//    // ’Non-binary|gender diverse’, ‘Prefer not to say’ and ‘Other’.
//    @Test
//    public void testGenderField() {
//        Person person = new Person();
//        // throw error
//        assertThrows(IllegalArgumentException.class, () -> person.setGender("Non-Binary"));
//        assertThrows(IllegalArgumentException.class, () -> person.setGender("Woman "));
//        assertThrows(IllegalArgumentException.class, () -> person.setGender("Other."));
//        // valid input
//        assertDoesNotThrow(() -> person.setGender("Man"));
//        assertDoesNotThrow(() -> person.setGender("Non-binary|gender diverse"));
//        assertDoesNotThrow(() -> person.setGender("Prefer not to say"));
//        assertDoesNotThrow(() -> person.setGender("Other"));
//    }
//
//    //3. The first name and last name should not start with a number or symbol
//    // and can contain only small case and upper-case alphabet letters
//
//    @Test
//    public void testNamesValidation() {
//        Person person = new Person();
//        assertThrows(IllegalArgumentException.class, () -> person.setFirstName("0123John"));
//        assertThrows(IllegalArgumentException.class, () -> person.setSecondName("$Doe"));
//        assertThrows(IllegalArgumentException.class, () -> person.setSecondName("Surname17"));
//        assertDoesNotThrow(() -> person.setFirstName("John"));
//        assertDoesNotThrow(() -> person.setSecondName("Doe"));
//    }

}