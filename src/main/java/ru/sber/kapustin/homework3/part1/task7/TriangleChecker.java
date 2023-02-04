package ru.sber.kapustin.homework3.task7;

public class TriangleChecker {

    public static boolean isSameTriangleSides(double firstSide, double secondSide, double thirdSide) {
        if (firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            throw new IllegalArgumentException();
        }

        return firstSide + secondSide > thirdSide && secondSide + thirdSide > firstSide && thirdSide + firstSide > secondSide;
    }
}
