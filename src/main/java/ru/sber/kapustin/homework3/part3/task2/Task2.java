package ru.sber.kapustin.homework3.part3.task2;

public class Task2 {

    public static void main(String[] args) {
        final var carpenter = new BestCarpenterEver();

        //true
        System.out.println(carpenter.canFixFurniture(new Stool(100, 40)));

        //false
        System.out.println(carpenter.canFixFurniture(new Closet(150, 200)));

        //false
        System.out.println(carpenter.canFixFurniture(new Table(60, 60)));
    }
}
