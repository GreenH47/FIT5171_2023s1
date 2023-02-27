package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class squareTest {
    public void test(){
        JunitTesting test = new JunitTesting();
        int output = test.square(5);
        assertEquals(26, output);

    }
    public static void main(String[] args) {

    }


}