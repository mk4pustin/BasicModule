package ru.sber.kapustin.homework2.part1.task10;

import java.util.Random;

public class SimpleGame {
    public static final int MAX_HIDDEN_NUMBER = 1000;

    private final int hiddenNumber;

    private boolean isGameEnd;

    public SimpleGame() {
        this.hiddenNumber = new Random().nextInt(MAX_HIDDEN_NUMBER + 1);

        this.isGameEnd = false;
    }

    public int compareWithHiddenNumber(int number) {
        if (!isGameEnd) {
            final var compareValue = Integer.compare(number, hiddenNumber);

            if (compareValue == 0) {
                isGameEnd = true;
            }

            return compareValue;
        }

        throw new UnsupportedOperationException("It is impossible to compare with the " +
                "hidden number because game over.");
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }
}
