package org.example;

public class Main {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}