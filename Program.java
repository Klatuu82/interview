package com.encoway.qa.server.embedded.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    // arguments are passed using the text field below this editor
    public static void main(String[] args) {
        int[] in = { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 };
        int[] out = Program.largestRange(in);
        for (int a : out) {
            System.out.println(a);
        }
    }

    public static int[] largestRange(int[] array) {
        // Write your code here.
        int[] output = new int[2];
        int smallest, newSmallest, length = 0;
        boolean noNextNumber = false;
        smallest = Collections.min(Arrays.stream(array).boxed().collect(Collectors.toList()));
        do {
            newSmallest = Program.getNewSmallest(array, smallest);
            if (newSmallest - smallest > length) {
                length = newSmallest - smallest;
                output[0] = smallest;
                output[1] = newSmallest;
            }
            int nextSmallest = Program.findeNextNumber(array, newSmallest);
            if (nextSmallest == Integer.MAX_VALUE)
                noNextNumber = true;
            smallest = nextSmallest;
        } while (!noNextNumber);
        return output;
    }

    public static int findeNextNumber(int[] array, int newSmallest) {
        int nextSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > newSmallest && array[i] <= nextSmallest) {
                nextSmallest = array[i];
            }
        }
        return nextSmallest;
    }

    public static int getNewSmallest(int[] array, int smallest) {
        List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
        while (arr.contains(smallest + 1)) {
            smallest = smallest + 1;
        }
        return smallest;
    }
}
