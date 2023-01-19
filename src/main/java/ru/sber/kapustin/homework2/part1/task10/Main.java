package ru.sber.kapustin.homework2.part1.task10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SimpleGame game = new SimpleGame();

        System.out.println("The game started.");
        while (!game.isGameEnd()) {
            int compareValue = game.compareWithHiddenNumber(readNumber());

            switch (compareValue) {
                case -1 -> System.out.println("This number is less than expected.");
                case 0 -> System.out.println("Victory!");
                case 1 -> System.out.println("This number is more than expected.");
            }
        }
    }

    private static int readNumber() {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a number (between 0 and 1000): ");
        try {
            int number = console.nextInt();
            if (number < 0 || number > SimpleGame.MAX_HIDDEN_NUMBER) {
                System.out.println("Error! The number must be between 0 and 1000. Please try again...");

                return readNumber();
            }

            return number;
        } catch (InputMismatchException e) {
            System.out.println("Error! The entered string is not a number. Please try again...");

            return readNumber();
        }
    }
}