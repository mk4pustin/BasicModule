package ru.sber.kapustin.homework3.part1.task7;

public class Test {

    public static void main(String[] args) {
        //false
        System.out.println(TriangleChecker.isSameTriangleSides(12, 3, 4));
        System.out.println(TriangleChecker.isSameTriangleSides(1, 2, 3));

        //true
        System.out.println(TriangleChecker.isSameTriangleSides(2, 3, 4));
        System.out.println(TriangleChecker.isSameTriangleSides(12, 13, 24));
    }
}
