package ru.sber.kapustin.homework3.part3.task3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCreator {

    private ArrayListCreator() {
    }

    public static List<List<Integer>> createListMatrixMultiplyingRowByCol(int rowsCount, int colsCount) {
        if (rowsCount < 0 || colsCount < 0) return null;

        final var list = new ArrayList<List<Integer>>(rowsCount);

        var innerList = new ArrayList<Integer>(colsCount);
        for (var row = 0; row < rowsCount; row++) {
            for (var col = 0; col < colsCount; col++) {
                innerList.add(row + col);
            }
            list.add(innerList);

            innerList = new ArrayList<>();
        }

        return list;
    }
}
