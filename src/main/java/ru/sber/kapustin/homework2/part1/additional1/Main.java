package ru.sber.kapustin.homework2.part1.additional1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int passwordLength = readLength();

        printPassword(PasswordGenerator.createPassword(passwordLength));
    }

    private static int readLength() {
        Scanner console = new Scanner(System.in);

        try {
            System.out.print("Enter password length: ");
            int length = console.nextInt();

            if (length < 8) {
                System.out.println("Password with " + length + " number of characters is insecure. Please try again...");

                return readLength();
            }

            return length;
        } catch (InputMismatchException e) {
            System.out.println("Error! The entered string is not a number. Please try again...");

            return readLength();
        }
    }

    private static void printPassword(String password) {
        System.out.println("Your password: " + password);
    }
}
