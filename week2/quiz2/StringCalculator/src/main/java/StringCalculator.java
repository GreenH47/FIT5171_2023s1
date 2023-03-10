import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        // Return 0 for an empty input string
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check if the input string has a custom delimiter
        String delimiterRegex = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterStartIndex = 2;
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiterLine = numbers.substring(delimiterStartIndex, delimiterEndIndex);
            // Split the delimiter line by "][" to handle multiple delimiters
            String[] delimiters = delimiterLine.split("\\]\\[");
            for (String delimiter : delimiters) {
                // Remove the square brackets from each delimiter
                delimiter = delimiter.replace("[", "").replace("]", "");
                // Add each delimiter to the regular expression
                delimiterRegex += "|" + Pattern.quote(delimiter);
            }
            // Remove the delimiter line from the input string
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        // Split the input string using the delimiter(s)
        String[] tokens = numbers.split(delimiterRegex);

        // check the string split result (for debugging purposes)
        System.out.println(Arrays.toString(tokens));

        // Calculate the sum of the numbers, ignoring numbers greater than or equal to 1000
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String token : tokens) {
            // Convert each token to an integer and add it to the sum
            int number = Integer.parseInt(token);
            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }

        // If there are negative numbers, throw an exception
        if (!negatives.isEmpty()) {
            StringBuilder sb = new StringBuilder("Negatives not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                sb.append(negatives.get(i));
                if (i < negatives.size() - 1) {
                    sb.append(", ");
                }
            }
            throw new IllegalArgumentException(sb.toString());
        }

        // Return the sum
        return sum;
    }
}
