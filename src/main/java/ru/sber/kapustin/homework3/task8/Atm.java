package ru.sber.kapustin.homework3.task8;

public class Atm {
    private final double dollarsToRublesCourse;
    private final double rublesToDollarsCourse;

    private static int atmsCount = 0;

    public Atm(double course, CurrencyTransfer transfer) {
        if (course < 0) {
            throw new IllegalArgumentException();
        }

        if (transfer == CurrencyTransfer.RUBLES_TO_DOLLARS) {
            rublesToDollarsCourse = course;
            dollarsToRublesCourse = 1 / course;
        } else {
            rublesToDollarsCourse = 1 / course;
            dollarsToRublesCourse = course;
        }

        atmsCount++;
    }

    public double toDollars(double rubles) {
        return rubles / rublesToDollarsCourse;
    }

    public double toRubles(double dollars) {
        return dollars / dollarsToRublesCourse;
    }

    public int getAtmsCount() {
        return atmsCount;
    }
}
