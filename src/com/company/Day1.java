package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    public ArrayList<Integer> readInputs() {
        Scanner scanner = new Scanner(System.in);
        var list = new ArrayList<Integer>();
        var next = 0;
        while (next != (-1)) {
            next = scanner.nextInt();
            list.add(next);
        }
        return list;
    }

    private int[] getNumbers() {
        final ArrayList<Integer> inputs = readInputs();
        for (int i = 0; i < inputs.size() - 1; i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                if (inputs.get(i) + inputs.get(j) == 2020) {
                    return new int[]{inputs.get(i), inputs.get(j)};
                }
            }
        }
        return null;
    }

    public void printTask1() {
        final int[] solution = getNumbers();
        System.out.println(solution[0] * solution[1]);
    }

    private int[] get3Numbers() {
        final ArrayList<Integer> inputs = readInputs();
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

    public void printTask2() {
        final int[] solution = get3Numbers();
        System.out.println(solution[0] * solution[1] * solution[2]);
    }
}
