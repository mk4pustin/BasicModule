package ru.sber.kapustin.homework3.part3.task4;

import ru.sber.kapustin.homework3.part3.ConsoleReader;
import ru.sber.kapustin.homework3.part3.ConsoleWriter;

public class Task4 {

    public static void main(String[] args) {
        final var participantsCount = ConsoleReader.readIntFromConsole();
        final var contest = new Contest(participantsCount);

        for (int i = 0; i < participantsCount; i++) {
            contest.addParticipant(new Participant(ConsoleReader.readStringFromConsole()));
        }

        for (int i = 0; i < participantsCount; i++) {
            contest.addParticipantDog(i, new Dog(ConsoleReader.readStringFromConsole()));
        }

        for (int i = 0; i < participantsCount; i++) {
            for (int count = 0; count < Contest.JUDGES_COUNT; count++) {
                contest.addParticipantScore(i, ConsoleReader.readIntFromConsole());
            }
        }

        ConsoleWriter.printList(contest.getWinners());
    }
}
