package ru.sber.kapustin.homework3.part3.task1;

public enum MovementType {
    SWIMMING(Swimming.class.toString()),
    FLYING(Flying.class.toString()),
    WALKING(Walking.class.toString());
    
    private final String movementType;

    MovementType(String movementType) {
        this.movementType = movementType;
    }

    @Override
    public String toString() {
        return movementType;
    }
}
