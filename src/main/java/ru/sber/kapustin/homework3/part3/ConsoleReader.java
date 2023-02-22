package ru.sber.kapustin.homework3.part3;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner CONSOLE = new Scanner(System.in);

    private ConsoleReader() {
    }

    public static int readIntFromConsole() {
        return CONSOLE.nextInt();
    }

    public static String readStringFromConsole() {
        return CONSOLE.next();
    }
}
