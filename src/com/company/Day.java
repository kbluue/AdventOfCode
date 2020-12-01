package com.company;

public interface Day {

    int getDay();

    Integer getTask1Solution();

    Integer getTask2Solution();

    default void printSolutions(){
        System.out.printf("%7s * * Day %2s * * %7s", "", getDay(), "");
        System.out.printf("%-10s%20s%n", "Part One: ", getTask1Solution());
        System.out.printf("%-10s%20s%n", "Part Two: ", getTask2Solution());
        System.out.println();
    }
}
