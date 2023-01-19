package ru.sber.kapustin.homework2.part1;

import java.util.Arrays;
import java.util.Scanner;

public class AdditionalTask2 {

    public static void main(String[] args) {
        int[] arr = readArray();
        int[] squaredArr = createSquaredArray(arr);

        printArray(squaredArr);
    }

    private static int[] readArray() {
        Scanner console = new Scanner(System.in);

        int length = console.nextInt();
        int[] arr = new int[length];

        for (int index = 0; index < length; index++) {
            arr[index] = console.nextInt();
        }

        return arr;
    }

    private static int[] createSquaredArray(int[] arr) {
        int firstPositiveElemIndex = 0;

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] >= 0) {
                firstPositiveElemIndex = index;
                break;
            }
        }

        int leftIndex = firstPositiveElemIndex - 1, squaredArrIndex = 0;
        int[] squaredArr = new int[arr.length];
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
