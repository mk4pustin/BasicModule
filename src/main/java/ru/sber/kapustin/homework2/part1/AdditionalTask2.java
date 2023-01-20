package ru.sber.kapustin.homework2.part1;

import java.util.Arrays;
import java.util.Scanner;

public class AdditionalTask2 {

    public static void main(String[] args) {
        final var arr = readArray();
        final var squaredArr = createSquaredArray(arr);

        printArray(squaredArr);
    }

    private static int[] readArray() {
        final var console = new Scanner(System.in);

        final var length = console.nextInt();
        final var arr = new int[length];

        for (var index = 0; index < length; index++) {
            arr[index] = console.nextInt();
        }

        return arr;
    }

    private static int[] createSquaredArray(int[] arr) {
        var firstPositiveElemIndex = 0;
        for (var index = 0; index < arr.length; index++) {
            if (arr[index] >= 0) {
                firstPositiveElemIndex = index;
                break;
            }
        }

        var leftIndex = firstPositiveElemIndex - 1;
        var squaredArrIndex = 0;
        final var squaredArr = new int[arr.length];

        while (squaredArrIndex < squaredArr.length) {
            if (firstPositiveElemIndex == arr.length || leftIndex >= 0 && -arr[leftIndex] < arr[firstPositiveElemIndex]) {
                squaredArr[squaredArrIndex++] = (int) Math.pow(arr[leftIndex--], 2);
            } else {
                squaredArr[squaredArrIndex++] = (int) Math.pow(arr[firstPositiveElemIndex++], 2);
            }
        }

        return squaredArr;
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
