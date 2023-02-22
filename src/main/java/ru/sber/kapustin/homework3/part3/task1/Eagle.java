package ru.sber.kapustin.homework3.part3.task1;

public class Eagle extends Bird implements Walking, Flying {
    @Override
    public void fly() {
        System.out.println("Fly");
    }

    @Override
    public void walk() {
        System.out.println("Walk");
    }
}
