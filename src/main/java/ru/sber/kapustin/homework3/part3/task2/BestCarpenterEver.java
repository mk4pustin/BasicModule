package ru.sber.kapustin.homework3.part3.task2;

public class BestCarpenterEver {

    public boolean canFixFurniture(Furniture furniture) {
        if (furniture == null) return false;

        if (furniture instanceof Stool) return true;

        return false;
    }
}
