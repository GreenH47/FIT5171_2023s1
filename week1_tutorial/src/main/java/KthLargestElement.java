import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElement {

    public static void main(String[] args) {
        // Read input array from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array elements separated by comma: ");
        String input = scanner.nextLine();
        String[] values = input.split(",");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i].trim());
        }

        // Read the value of k from user
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Find the k-th largest element using findKthLargestElement()
        int kthLargest = findKthLargestElement(arr, k);

        // Print the k-th largest element
        System.out.println("The " + k + "-th largest element is " + kthLargest);
    }

    public static int findKthLargestElement(int[] arr, int k) {

        // If k is greater than the length of the array, return -1
        if (k > arr.length) {
            return -1;
        }

        // Sort the array in descending order
        Arrays.sort(arr);
        int x = arr.length - k;
        int kthLargest = arr[x];
        return kthLargest;
    }
}
