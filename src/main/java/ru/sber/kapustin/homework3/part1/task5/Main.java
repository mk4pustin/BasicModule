package ru.sber.kapustin.homework3.part1.task5;

public class Main {

    public static void main(String[] args) {
        DayOfWeek[] weekDays = new DayOfWeek[7];
        weekDays[0] = new DayOfWeek((byte) 1, "Monday");
        weekDays[1] = new DayOfWeek((byte) 2, "Tuesday");
        weekDays[2] = new DayOfWeek((byte) 3, "Wednesday");
        weekDays[3] = new DayOfWeek((byte) 4, "Thursday");
        weekDays[4] = new DayOfWeek((byte) 5, "Friday");
        weekDays[5] = new DayOfWeek((byte) 6, "Saturday");
        weekDays[6] = new DayOfWeek((byte) 7, "Sunday");

        for (var day : weekDays) {
            System.out.println(day.serialNumber() + " " + day.name());
        }
    }
}
