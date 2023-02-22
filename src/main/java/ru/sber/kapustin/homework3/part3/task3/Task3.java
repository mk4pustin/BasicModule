package ru.sber.kapustin.homework3.part3.task3;

import ru.sber.kapustin.homework3.part3.ConsoleReader;
import ru.sber.kapustin.homework3.part3.ConsoleWriter;

public class Task3 {

    public static void main(String[] args) {
        final int colsCount = ConsoleReader.readIntFromConsole();
        final int rowsCount = ConsoleReader.readIntFromConsole();

        ConsoleWriter.printArrayListMatrix(ArrayListCreator.createListMatrixMultiplyingRowByCol(rowsCount, colsCount));
    }
}
