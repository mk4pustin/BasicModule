package ru.sber.kapustin.homework3.part2;

class Utils {
    private Utils() {
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.trim().equals("");
    }
}
