package ru.sber.kapustin.homework3;

public class Student {
    private String name;
    private String surname;

    private int[] grades;

    private int currentGradesNumber;

    public static final int MAX_GRADES_NUMBER = 10;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.grades = new int[MAX_GRADES_NUMBER];
        this.currentGradesNumber = 0;
    }

    public void addGrade(int grade) {
        if (currentGradesNumber == MAX_GRADES_NUMBER) {
            for (var index = 0; index < MAX_GRADES_NUMBER - 1; index++) {
                grades[index] = grades[index + 1];
            }

            currentGradesNumber--;
        }

        grades[currentGradesNumber++] = grade;
    }

    public double getAverageGrade() {
        var sum = 0;
        for (var index = 0; index < currentGradesNumber; index++) {
            sum += grades[index];
        }

        return sum == 0 ? 0 : (double) sum / currentGradesNumber;
    }

    private int getNewCurGradesNumber() {
        if (grades == null) {
            grades = new int[MAX_GRADES_NUMBER];
            return 0;
        }

        var gradesNumber = 0;

        for (var grade : grades) {
            if (grade != 0) {
                gradesNumber++;
            }
        }

        return gradesNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
        this.currentGradesNumber = getNewCurGradesNumber();
    }
}
