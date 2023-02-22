package ru.sber.kapustin.homework3.part3.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Contest {
    public static final int WINNERS_COUNT = 3;
    public static final int JUDGES_COUNT = 3;

    public final List<Participant> participants;

    public Contest(int participantsCount) {
        participants = new ArrayList<>(participantsCount);
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void addParticipantScore(int index, int score) {
        participants.get(index).addScore(score);
    }

    public void addParticipantDog(int index, Dog dog) {
        participants.get(index).setDog(dog);
    }

    public List<Participant> getWinners() {
        return participants.stream()
                .sorted(Comparator.reverseOrder())
                .limit(WINNERS_COUNT)
                .toList();
    }
}
