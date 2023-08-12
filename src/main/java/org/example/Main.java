package org.example;

import service.IntegerList;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntegerList intList = new IntegerList();

//        int separator = Integer.MAX_VALUE;
//        Integer[] testArray1 = new Integer[100_000];
//        Random random = new Random();
//        IntStream.range(0, testArray1.length)
//                .forEach(e -> testArray1[e] = random.nextInt(separator));
//
//        Integer[] testArray2 = new Integer[100_000];
//        Integer[] testArray3 = new Integer[100_000];
//        System.arraycopy(testArray1, 0, testArray2, 0, testArray1.length);
//        System.arraycopy(testArray1, 0, testArray3, 0, testArray1.length);

//        long start1 = System.currentTimeMillis();
//        intList.sortBubble(testArray1);
//        System.out.println("Время выполнения метода sortBubble " + (System.currentTimeMillis() - start1)); // 73896 ms
//        long start2 = System.currentTimeMillis();
//        intList.sortedSelection(testArray2);
//        System.out.println("Время выполнения метода sortSelection " + (System.currentTimeMillis() - start2)); // 9776 ms
//        long start3 = System.currentTimeMillis();
//        intList.sortedInsert(testArray3);
//        System.out.println("Время выполнения метода sortInsert " + (System.currentTimeMillis() - start3)); // 23644 ms

        intList.add(577);
        intList.add(301);
        intList.add(45);
        intList.add(117);
        intList.add(3011);
        intList.add(125);
        intList.quickSort(intList.toArray());
    }
}