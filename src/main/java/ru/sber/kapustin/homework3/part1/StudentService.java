package ru.sber.kapustin.homework3.part1;

import java.util.*;

public class StudentService {

    public static Student bestStudent(Student[] students) {
        return Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getAverageGrade))
                .toArray(Student[]::new)[students.length - 1];
    }

    public static Student[] sortBySurname(Student[] students) {
        return Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getSurname))
                .toArray(Student[]::new);
    }
}
