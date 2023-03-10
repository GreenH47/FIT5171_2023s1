/**
 * @author Yuan-Fang Li & Arvind Kaur
 * @version $Id: 02$
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Anagram {

    // variables to store the words
    //variables to store the characters

    //methods to get the input
    // methods to compare the characters


    public boolean findOneWordAnagram(String input1, String input2){

        if(input1.length() == input2.length()) {
            char word1Array[] = input1.toCharArray();
            char word2Array[] = input2.toCharArray();

            Arrays.sort(word1Array);
            Arrays.sort(word2Array);

            return Arrays.equals(word1Array, word2Array);
        }
        else
            return false;
    }

    public Set<Set<String>> findAnagrams(String input) {

        // Sets is static class, newhashset: Creates a mutable, initially empty HashSet instance.
        // HAshset, collection that uses hashset for storage
        Set<String> tokens = Sets.newHashSet();

        //creates a mutable HashSet instance containing the given elements.
        Set<Set<String>> output = new HashSet<Set<String>>();

        //creating a map with integer and a string
        Multimap<Integer, String> map = HashMultimap.create();

        //Break a string into tokens
        StringTokenizer tokenizer = new StringTokenizer(input.trim());

        //if there are more tokens available
        while (tokenizer.hasMoreTokens()) {

            //next token
            String s = tokenizer.nextToken();
            System.out.println("one token at a time:" + s);

            // adding the token into the Set<String>
            tokens.add(s);
            System.out.println("Tokens so far: " + tokens);

            //create an array of char from the current token
            char[] chars = s.toLowerCase().toCharArray();
            for(int i = 0; i<chars.length; i++){
                System.out.println("char array: " + chars[i]);
            }
            Arrays.sort(chars);
            for(int i = 0; i<chars.length; i++){
                System.out.println("sorted char array: " + chars[i]);
            }


            //Arrays.hashCode(): method returns a hash code based on the contents of the specified array.
            // For any two non-null int arrays a and b such that Arrays.equals(a, b),
            // it is also the case that Arrays.hashCode(a) == Arrays.hashCode(b).
            // SO, 1. GENERATE HASCODE OF THE CHARS ARRAY FOR THAT WORD
            // 2. PUT THE HASCODE AND THE STRING IN THE MAP
            // 3. IF THE HASCODE IS SAME, THEN USE THE SAME KEY,
            // THIS WAY ONE KEY HAS TWO STRINGS OF SAME HASCODE KEY
            map.put(Arrays.hashCode(chars), s);
            System.out.println("Map: " + map);
        }

        // keySet() method is used to get a Set view of the keys contained in this map.
        for (Integer key : map.keySet()) {
            System.out.println(Sets.newHashSet(map.get(key)));
            //map.get(key: get me the string on that key)
            output.add(Sets.newHashSet(map.get(key)));
        }

        System.out.println("OUTPUT: " + output);
        return output;
    }



}
