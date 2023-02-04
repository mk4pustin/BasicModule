package ru.sber.kapustin.homework3.part1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

public class Cat {

    public void status() {
        final var actions = Arrays.stream(getClass().getDeclaredMethods())
                .filter(p -> Modifier.isPrivate(p.getModifiers()) && p.getParameterCount() == 0)
                .toList();

        try {
            actions.get(new Random().nextInt(actions.size())).invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void sleep() {
        System.out.println("Sleep");
    }

    private void meow() {
        System.out.println("Meow");
    }

    private void eat() {
        System.out.println("Eat");
    }
}
