package com.company;

import java.util.ArrayList;

public class Day6 implements Day {

    class Group {
        int people;
        String answers = "";

        void build(String line) {
            people++;
            answers += line;
        }

        int getYes() {
            return Math.toIntExact(answers.chars()
                    .distinct()
                    .count());
        }
    }

    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public Integer getTask1Solution() {
        var groups = new ArrayList<Group>();
        groups.add(new Group());
        readLines(TEST)
                .forEach(line -> {
                    if (line.isBlank()) {
                        groups.add(new Group());
                    } else {
                        groups.get(groups.size() - 1).build(line);
                    }
                });
        return groups.stream()
                .mapToInt(Group::getYes)
                .sum();
    }

    @Override
    public Integer getTask2Solution() {
        return null;
    }
}
