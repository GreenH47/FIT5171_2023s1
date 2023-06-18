package FIT5171.Team8;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Mock
    Person person;

    @BeforeEach
    void setup(){
        person = new Person();
    }




    @Test
    void testAddFirstName() {
        Throwable exception;
        person.setFirstName("john");
        assertEquals("john",person.getFirstName());//FirstName that meets the requirements
        //FirstName that does not meet the requirements

        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("111");
        });
        assertEquals("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("A111");
        });
        assertEquals("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        // Test invalid firstName starting with a number
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("2John");
        });

        // Test invalid firstName containing a non-alphabetic character
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("Joh*n");
        });

        // Test invalid firstName starting with a symbol
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("$John$");
        });
    }




    @Test
    void testAddAge() {
        assertEquals(0,person.getAge());
        //Test whether the added age is successful
        person.setAge(25);
        assertEquals(25,person.getAge());

        person.setAge(0);
        assertEquals(0,person.getAge());

        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });

    }

    @Test
    void testAddSecondName() {
        Throwable exception;
        person.setSecondName("Doe");
        assertEquals("Doe",person.getSecondName());//Test for compliance with the requirements of SecondName
        //The test does not meet the requirements of SecondName

        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("111");
        });
        assertEquals("Last name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("A111");
        });
        assertEquals("Last name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        // Test invalid firstName starting with a number
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("2John");
        });

        // Test invalid firstName containing a non-alphabetic character
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("Joh*n");
        });

        // Test invalid firstName starting with a symbol
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("$John");
        });
    }

    @Test
    void testAddGender() {
        Throwable exception;

        //"Woman", "Man", "Non-binary|gender diverse", "Prefer not to say", "Other"
        person.setGender("Woman");//The test meets the required gender
        assertEquals("Woman",person.getGender());
        person.setGender("Non-binary|gender diverse");
        assertEquals("Non-binary|gender diverse",person.getGender());
        person.setGender("Prefer not to say");
        assertEquals("Prefer not to say",person.getGender());
        person.setGender("Other");
        assertEquals("Other",person.getGender());

        //The test does not meet the required gender
        // new test case from huang
        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setGender("Male");
        });
        assertEquals("Invalid gender. Gender should be one of the following: 'Woman', 'Man', 'Non-binary|gender diverse', 'Prefer not to say', 'Other'", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setGender("Female");
        });
        assertEquals("Invalid gender. Gender should be one of the following: 'Woman', 'Man', 'Non-binary|gender diverse', 'Prefer not to say', 'Other'", exception.getMessage());

    }

    // new test case from huang

    @Test
    void testIsValidGenderValid() {
        Person person = new Person();
        // Test valid gender
        assertTrue(person.isValidGender("Man"));
        // Test invalid gender
        assertFalse(person.isValidGender("Invalid Gender"));
        // Test negated conditional
        assertFalse(person.isValidGender("Some Gender"));

    }

    @Test
    void testSetFirstName() {
        Throwable exception;
        person = new Person();
        // Test valid firstName
        person.setFirstName("John");
        Assert.assertEquals("First name should match pattern", "John", person.getFirstName());
        // Test invalid firstName starting with a number
        exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("2John");
        });
        assertEquals("First name should contain only small case and upper-case alphabet letters and should not start with a number or symbol.", exception.getMessage());

        // Test invalid firstName containing a non-alphabetic character
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("Joh*n");
        });
        // Test invalid firstName starting with a symbol
        assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName("$John");
        });
    }

    @Test
    void testSetSecondName() {
        Person person = new Person();

        // Test valid firstName
        person.setSecondName("John");

        // Test invalid firstName starting with a number
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("2John");
        });

        // Test invalid firstName containing a non-alphabetic character
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("Joh*n");
        });

        // Test invalid firstName starting with a symbol
        assertThrows(IllegalArgumentException.class, () -> {
            person.setSecondName("$John");
        });
    }

    @Test
    public void testPersonConstructor() {
        String expectedEmptyString = "Person{firstName='null', secondName='null', age=0, gender='null'}";
        assertEquals(expectedEmptyString, person.toString());



        String firstName = "John";
        String secondName = "Doe";
        int age = 30;
        String gender = "Man";

        Person person = new Person(firstName, secondName, age, gender);

        assertEquals(firstName, person.getFirstName());
        assertEquals(secondName, person.getSecondName());
        assertEquals(age, person.getAge());
        assertEquals(gender, person.getGender());

        String expectedString = "Person{firstName='John', secondName='Doe', age=30, gender='Man'}";
        String actualString = person.toString();

        assertEquals(expectedString, actualString);


    }

}
