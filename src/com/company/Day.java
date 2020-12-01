package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Day {

    int getDay();

    Integer getTask1Solution();

    Integer getTask2Solution();

    default void printSolutions(){
        System.out.printf("#%6s * * Day %2s * * %6s#%n", "", getDay(), "");
        System.out.printf("%-10s%20s%n", "Part One: ", nullWrap(getTask1Solution()));
        System.out.printf("%-10s%20s%n", "Part Two: ", nullWrap(getTask2Solution()));
        System.out.println();
    }

    private Object nullWrap(Integer solution) {
        return solution == null ? "Result not ready yet" : getTask1Solution();
    }

    default ArrayList<Integer> readInput(){
        return readFile("input");
    }

    default ArrayList<Integer> readTest(){
        return readFile("test");
    }

    private ArrayList<Integer> readFile(String directory) {
        var input = new ArrayList<Integer>();
        try {
            var scanner = new Scanner(new File(String.format("src/res/%s/day%s", directory, getDay())));
            while (scanner.hasNext()) {
                input.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Kindly add input file and name appropriately");
        }
        return input;
    }
}
