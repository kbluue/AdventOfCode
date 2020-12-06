package com.company;

import java.util.ArrayList;

import static java.lang.Math.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Day6 implements Day {

    class Group {
        int people;
        String answers = "";

        void build(String line) {
            people++;
            answers += line;
        }

        int getYes() {
            return toIntExact(answers.chars()
                    .distinct()
                    .count());
        }

        int getSameYes() {
            return toIntExact(answers.chars()
                    .boxed()
                    .collect(groupingBy(identity(), counting()))
                    .values()
                    .stream()
                    .filter(aLong -> people == aLong)
                    .count());
        }
    }

    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public Integer getTask1Solution() {
        var groups = getGroups(INPUT);
        return groups.stream()
                .mapToInt(Group::getYes)
                .sum();
    }

    @Override
    public Integer getTask2Solution() {
        var groups = getGroups(INPUT);
        return groups.stream()
                .mapToInt(Group::getSameYes)
                .sum();
    }

    public ArrayList<Group> getGroups(String input) {
        var groups = new ArrayList<Group>();
        groups.add(new Group());
        readLines(input)
                .forEach(line -> {
                    if (line.isBlank()) {
                        groups.add(new Group());
                    } else {
                        groups.get(groups.size() - 1).build(line);
                    }
                });
        return groups;
    }
}
