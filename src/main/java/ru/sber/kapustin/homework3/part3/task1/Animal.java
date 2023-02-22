package ru.sber.kapustin.homework3.part3.task1;

import java.util.Arrays;

public abstract class Animal {
    private int flightSpeed;
    private int swimmingSpeed;
    private int walkingSpeed;

    final void sleep() {
        System.out.println("Sleep");
    }

    final void eat() {
        System.out.println("Eat");
    }

    abstract void wayOfBirth();

    void setSpeed(MovementType type, int speed) {
        if (speed < 0) return;

        if (Arrays.stream(this.getClass().getInterfaces())
                .noneMatch(i -> i.toString().equals(type.toString())))
            throw new IllegalArgumentException("The animal cannot move like this.");

         switch (type) {
             case WALKING -> walkingSpeed = speed;
             case FLYING -> flightSpeed = speed;
             case SWIMMING -> swimmingSpeed = speed;
         }
    }
}
