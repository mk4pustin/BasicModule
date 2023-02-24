package ru.sber.kapustin.homework3.part3.task1;

public interface Flying {

    default void fly() {
        System.out.println("Fly");
    }
}
