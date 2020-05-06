package com.workathome;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] intArray = {10, 15, 4, 3, 7, 8, 20, 25, 1, 6, 50, 100, 10};
        String[] stringArray = {"Manish", "Neha", "Swati", "Naveen", "Ram", "Ankit", "Vidushi"};
        Arrays.asList(HeapOperations.sort(intArray)).forEach(obj -> System.out.print(obj + " "));
        System.out.println();
        Arrays.asList(HeapOperations.sort(stringArray)).forEach(obj -> System.out.print(obj + " "));
    }
}
