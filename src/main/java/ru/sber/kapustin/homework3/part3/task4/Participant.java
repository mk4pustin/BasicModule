package ru.sber.kapustin.homework3.part3.task4;

import ru.sber.kapustin.homework3.part3.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Comparable<Participant> {
    public final String name;

    private final List<Integer> judgesScores;

    private Dog dog;

    public Participant(String name) {
        this(name, null);
    }

    public Participant(String name, Dog dog) {
        this.name = name;
        this.dog = dog;

        judgesScores = new ArrayList<>();
    }

    public void addScore(int score) {
        judgesScores.add(score);
    }

    public double getAverage() {
        return judgesScores.size() == 0? 0 : (double) judgesScores.stream()
                .mapToInt(Integer::intValue)
                .sum() / judgesScores.size();
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public int compareTo(Participant o) {
        return Double.compare(getAverage(), o.getAverage());
    }

    @Override
    public String toString() {
        return name + ": " + dog.name() + ", " + NumberUtils.cutOffShot(getAverage());
    }
}
