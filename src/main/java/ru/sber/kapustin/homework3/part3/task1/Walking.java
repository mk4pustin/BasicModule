package ru.sber.kapustin.homework3.part3.task1;

public interface Walking {

    default void walk() {
        System.out.println("Walk");
    }
}
