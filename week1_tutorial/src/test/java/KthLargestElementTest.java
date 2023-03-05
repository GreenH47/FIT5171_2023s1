import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {

    @Test
    /*
    * an array with only one element, and we want to
    * find the 1st largest element. We expect the output to be the same element.
    * */
    public void testKthLargestElement() {
        int[] arr = {3};
        int k = 1;
        int expected = 3;
        int actual = KthLargestElement.findKthLargestElement(arr, k);
        assertEquals(expected, actual);
    }

    @Test
    /*
    *  array of multiple elements. We want to find the 3rd largest element of the array.
    * */
    public void testKthLargestElementMulti() {
        // Test Case 1
        int[] arr1 = {3};
        int k1 = 1;
        int expected1 = 3;
        int actual1 = KthLargestElement.findKthLargestElement(arr1, k1);
        assertEquals(expected1, actual1);

        // Test Case 2
        int[] arr2 = {5, 3, 9, 8, 1};
        int k2 = 3;
        int expected2 = 5;
        int actual2 = KthLargestElement.findKthLargestElement(arr2, k2);
        assertEquals(expected2, actual2);
    }

    @Test
    /*
    * an array that contains repeated elements
    * */
    public void testKthLargestElementRepeated() {
        // Test Case 3
        int[] arr3 = {3, 3, 5, 2, 5, 2};
        int k3 = 2;
        int expected3 = 5;
        int actual3 = KthLargestElement.findKthLargestElement(arr3, k3);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testKthLargestElementEdge() {
        // Test Case 1
        int[] arr1 = {3};
        int k1 = 1;
        int expected1 = 3;
        int actual1 = KthLargestElement.findKthLargestElement(arr1, k1);
        assertEquals(expected1, actual1);

        // Test Case 2
        int[] arr2 = {5, 3, 9, 8, 1};
        int k2 = 3;
        int expected2 = 5;
        int actual2 = KthLargestElement.findKthLargestElement(arr2, k2);
        assertEquals(expected2, actual2);

        // Test Case 3
        int[] arr3 = {3, 3, 5, 2, 5, 2};
        int k3 = 2;
        int expected3 = 5;
        int actual3 = KthLargestElement.findKthLargestElement(arr3, k3);
        assertEquals(expected3, actual3);

        // Test Case 4
        int[] arr4 = {5, 3, 9, 8, 1};
        int k4 = 10;
        int expected4 = -1;
        int actual4 = KthLargestElement.findKthLargestElement(arr4, k4);
        assertEquals(expected4, actual4);

        // Test Case 5
        int[] arr5 = {};
        int k5 = 1;
        int expected5 = -1;
        int actual5 = KthLargestElement.findKthLargestElement(arr5, k5);
        assertEquals(expected5, actual5);
    }
}

