package ru.sber.kapustin.homework3.part3;

import java.util.List;

public class ConsoleWriter {

    private ConsoleWriter() {
    }

    public static <E> void printArrayListMatrix(List<List<E>> list) {
        if (list == null) return;

        for (var innerList : list) {
            printListToLine(innerList);
            System.out.println();
        }
    }

    public static <E> void printList(List<E> list) {
        printList(list, '\n');
    }

    public static <E> void printListToLine(List<E> list) {
        printList(list, ' ');
    }

    private static <E> void printList(List<E> list, char ch) {
        list.forEach(elem -> System.out.print(elem + String.valueOf(ch)));
    }
}
