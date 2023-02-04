package ru.sber.kapustin.homework3.part1;

public class TimeUnit {
    private int hours;
    private int minutes;
    private int seconds;

    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MAX_SINGLE_NUMBER = 9;

    public TimeUnit(int hours, int minutes, int seconds) {
        if (isDaytimeIncorrect(hours, minutes, seconds)) {
            throw new IllegalArgumentException();
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimeUnit(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public TimeUnit(int hours) {
        this(hours, 0, 0);
    }

    private boolean isDaytimeIncorrect(int hours, int minutes, int seconds) {
        final var isDaytimeIncorrect = hours > HOURS_PER_DAY - 1 || minutes > MINUTES_PER_HOUR - 1 || seconds > SECONDS_PER_MINUTE - 1;

        return isDaytimeIncorrect || isTimeIncorrect(hours, minutes, seconds);
    }

    private boolean isTimeIncorrect(int hours, int minutes, int seconds) {
        return hours < 0 || minutes < 0 || seconds < 0;
    }


    public void output24hoursFormat() {
        printTime(hours, minutes, seconds);
    }

    public void output12hoursFormat() {
        final var hoursPerHalfDay = HOURS_PER_DAY / 2;

        printTime(hours % hoursPerHalfDay, minutes, seconds);
        System.out.print(hours / hoursPerHalfDay == 0? " am" : " pm");
    }

    private void printTime(int hours, int minutes, int seconds) {
        System.out.print(toTimeFormat(hours) + ":" + toTimeFormat(minutes) + ":" + toTimeFormat(seconds));
    }

    private String toTimeFormat(int number) {
        return number > MAX_SINGLE_NUMBER? String.valueOf(number) : "0" + number;
    }

    public void addTime(int hours, int minutes, int seconds) {
        if (isTimeIncorrect(hours, minutes, seconds)) {
            throw new IllegalArgumentException();
        }

        minutes += (seconds + this.seconds) / SECONDS_PER_MINUTE;
        hours += (minutes + this.minutes) / MINUTES_PER_HOUR;

        this.seconds = (seconds + this.seconds) % SECONDS_PER_MINUTE;
        this.minutes = (minutes + this.minutes) % MINUTES_PER_HOUR;
        this.hours = (hours + this.hours) % HOURS_PER_DAY;
    }
}
