package ru.sber.kapustin.homework3.part3.task2;

public class BestCarpenterEver {

    public boolean canFixFurniture(Furniture furniture) {
        if (furniture == null) return false;

        return furniture instanceof Fixable;
    }
}
