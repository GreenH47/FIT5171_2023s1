public class Practise {
        public static void main(String[] args) {

            // initializing int array
            int[] ival = new int[] { 3, 5 };

            // hashcode for value1
            int retval1 = ival.hashCode();

            // printing hash code value
            System.out.println("The hash code of value1 is: " + retval1);

            // value2 for double array
            int[] ival2 = new int[] { 3, 5 };
            int retval2 = ival2.hashCode();

            // hashcode for value2
            retval2 = ival.hashCode();

            // printing hash code value
            System.out.println("The hash code of value2 is: " + retval2);

            //same for strings
        }
}

