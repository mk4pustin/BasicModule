package ru.sber.kapustin.homework3.part3;

public class NumberUtils {

    private NumberUtils() {
    }

    public static double cutOffShot(double value) {
        value *= 10;

        return (double) (int) value / 10;
    }
}
