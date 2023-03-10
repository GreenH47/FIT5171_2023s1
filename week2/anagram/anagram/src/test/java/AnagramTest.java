/**
 * @author Yuan-Fang Li & Arvind Kaur
 * @version $Id: 02$
 */

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {
    private String input1;
    private String input2;
    private Anagram testObject;

    @BeforeEach
    public void setUp() throws Exception {
       //input1 = "";
       //input2 = "";
        testObject = new Anagram();
    }

    @Test
    public void testEmptyAnagram(){
        input1 = "";
        assertTrue(testObject.findOneWordAnagram(input1, input1));
    }

    @Test
    public void testNonAnagram(){
        input1 = "abc";
        input2 = "adc";
        assertFalse(testObject.findOneWordAnagram(input1,input2));
    }

    @Test
    public void testDate(){

        Date date = new Date();
        Date anotherDate = date;
        date.setTime(204587433443L);
        assertFalse(date.equals(anotherDate));
    }

    @Test
    public void testFindEmptyAnagram(){
        input1 = "";
        Set<Set<String>> output = testObject.findAnagrams(input1);
        //assertNotNull("not null", output);
        //assertTrue("empty set", output.isEmpty());
        assertNotNull(output);
        assertTrue(output.isEmpty(), "empty set");
    }

    @Test
    public void testFindOneWordAnagram() throws Exception {
        input1 = "word";
        input2 = "ordw";
        assertTrue(testObject.findOneWordAnagram(input1,input2));
    }

    @Test
    public void testFindMultipleAnagram() throws Exception {
        /*input1 = "tews tis lives tamed elvis ream\n" +
                "\tevils comics stew wets markers dashed \n" +
                "\twest veils rat mace sit mated cosmic \n" +
                "\tmare remarks shaded ";
        */
        input1 = "tews tis lives tamed elvis ream " +
                "evils comics stew wets markers dashed " +
                "west veils rat mace sit mated cosmic " +
                "mare remarks shaded ";

        Set<Set<String>> output = testObject.findAnagrams(input1);
       // assertEquals("right no. of groups", 10, output.size());
        assertEquals(10,output.size(), "right no. of groups");
    }

    //method to test if the inputs being sent are correct

}
