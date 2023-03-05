import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnagramDetectorTest {

    @Test
    void main() {
    }

    @Test
     /*
    check that the getAnagramGroups method returns an
    empty list when passed an empty array of words.
    */
    void getAnagramGroupsEmptyList() {
        String[] words = {};
        List<List<String>> result = AnagramDetector.getAnagramGroups(words);
        assertTrue(result.isEmpty());
    }

    @Test
        /*
        * check that the getAnagramGroups method correctly groups
        * a set of words that are all anagrams of each other
        * */
    void getAnagramGroupsSameGroup() {
        String[] words = {"listen", "silent", "enlist"};
        List<List<String>> result = AnagramDetector.getAnagramGroups(words);
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains("listen"));
        assertTrue(result.get(0).contains("silent"));
        assertTrue(result.get(0).contains("enlist"));
    }

    @Test
    public void testGetAnagramGroups() {
        // Test case with no input
        String[] emptyWordsArray = {};
        assertTrue(AnagramDetector.getAnagramGroups(emptyWordsArray).isEmpty());

        // Test case with single word input
        String[] singleWordArray = {"hello"};
        assertEquals(1, AnagramDetector.getAnagramGroups(singleWordArray).size());

        // Test case with input containing only anagrams
        String[] anagramWordsArray = {"race", "care", "acre"};
        assertEquals(1, AnagramDetector.getAnagramGroups(anagramWordsArray).size());

        // Test case with input containing no anagrams
        String[] nonAnagramWordsArray = {"hello", "world", "java"};
        assertEquals(3, AnagramDetector.getAnagramGroups(nonAnagramWordsArray).size());

        // Test case with input containing multiple anagram groups
        String[] multipleGroupsWordsArray = {"race", "care", "acre", "listen", "silent", "enlist"};
        assertEquals(2, AnagramDetector.getAnagramGroups(multipleGroupsWordsArray).size());

        // Test case with input containing empty strings
        //String[] emptyStringArray = {"race", "care", "", "enlist", "listen", "  "};
        //assertEquals(3, AnagramDetector.getAnagramGroups(emptyStringArray).size());
    }

    @Test
    /*
    * This test case ensures that the getAnagramGroups method correctly
    * groups anagrams even when the input array contains duplicates
    * */
    public void testGetAnagramGroups_InputWithDuplicates_ReturnsAnagramGroups() {
        AnagramDetector detector = new AnagramDetector();
        List<List<String>> result = detector.getAnagramGroups(new String[]{"eat", "tea", "ate", "ape", "pea", "pea", "are"});
        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList("eat", "tea", "ate")));
        assertTrue(result.contains(Arrays.asList("ape", "pea", "pea")));
        assertTrue(result.contains(Collections.singletonList("are")));
        assertFalse(result.contains(Arrays.asList("tea", "ate", "eat", "pea", "ape", "pea", "are")));
    }
}