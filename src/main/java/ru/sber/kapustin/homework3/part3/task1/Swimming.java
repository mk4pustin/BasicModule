package ru.sber.kapustin.homework3.part3.task1;

public interface Swimming {

    default void swim() {
        System.out.println("Swim");
    }
}
