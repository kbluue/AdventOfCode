package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 implements Day {

    private int[] getNumbers() {
        final ArrayList<Integer> inputs = readInput();
        for (int i = 0; i < inputs.size() - 1; i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                if (inputs.get(i) + inputs.get(j) == 2020) {
                    return new int[]{inputs.get(i), inputs.get(j)};
                }
            }
        }
        return null;
    }

    private int[] get3Numbers() {
        final ArrayList<Integer> inputs = readInput();
        for (int i = 0; i < inputs.size() - 2; i++) {
            for (int j = i + 1; j < inputs.size() - 1; j++) {
                for (int k = j + 1; k < inputs.size(); k++) {
                    if (inputs.get(i) + inputs.get(j) + inputs.get(k) == 2020) {
                        return new int[]{inputs.get(i), inputs.get(j), inputs.get(k)};
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public Integer getTask1Solution() {
        final int[] solution = getNumbers();
        return solution[0] * solution[1];
    }

    @Override
    public Integer getTask2Solution() {
        final int[] solution = get3Numbers();
        return solution[0] * solution[1] * solution[2];
    }
}
