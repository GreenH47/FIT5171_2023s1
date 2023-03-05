import java.util.*;

public class AnagramDetector {

    /**
     * Takes an array of words and returns a list of lists, where each list contains
     * all the anagrams in the input array.
     *
     * @param words array of words
     * @return list of lists containing anagrams
     */
    public static List<List<String>> getAnagramGroups(String[] words) {


        List<List<String>> anagramGroups = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        // loop through all the words in the input array
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // if the sorted word has already been seen, add the original word to the list
            // of anagrams for that sorted word
            if (anagramMap.containsKey(sortedWord)) {
                anagramMap.get(sortedWord).add(word);
            }
            // otherwise, create a new list for the anagrams of this sorted word, add the
            // original word to the list, and add the list to the list of anagram groups
            else {
                List<String> group = new ArrayList<>();
                group.add(word);
                anagramMap.put(sortedWord, group);
                anagramGroups.add(group);
            }
        }

        return anagramGroups;
    }

    /**
     * Takes user input of words separated by spaces and prints out the anagram groups.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter words separated by spaces:");
        String words = input.nextLine();
        String[] wordsArray = words.split(" ");

        List<List<String>> anagramGroups = getAnagramGroups(wordsArray);

        // loop through each anagram group and print out the words separated by spaces
        for (List<String> group : anagramGroups) {
            StringBuilder sb = new StringBuilder();
            for (String word : group) {
                sb.append(word).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
