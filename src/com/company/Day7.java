package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7 implements Day {

    static class Rule {
        String container;
        ArrayList<String> contains;

        public Rule(String container, ArrayList<String> contains) {
            this.container = container;
            this.contains = contains;
        }

        public String getContainer() {
            return container;
        }

        static Rule of(String line) {
            var split = line.split("contain");
            return new Rule(getColors(split[0]).get(0), getColors(split[1]));
        }

        static ArrayList<String> getColors(String line) {
            var colors = new ArrayList<java.lang.String>();
            var split = line.split(", ");
            for (java.lang.String color : split) {
                var toBeRemoved = List.of(" bags.", " bags", " bag.", " bag");
                for (java.lang.String word : toBeRemoved) {
                    color = color.replaceAll(word, "");
                }
                var numbers = IntStream.range(0, 10).toArray();
                for (int i : numbers) {
                    color = color.replaceAll(java.lang.String.valueOf(i), "");
                }
                colors.add(color.trim());
            }
            return colors;
        }
    }

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    public Integer getTask1Solution() {
        var rules = readLines(INPUT).stream()
                .map(Rule::of)
                .collect(Collectors.toList());

        int count = 0;
        var checking = new ArrayList<String>();
        checking.add("shiny gold");
        while (!checking.isEmpty() && !rules.isEmpty()) {
            Set<String> tbc = new HashSet<>();
            for (String color : checking) {
                var result = rules.stream()
                        .filter(rule -> rule.contains.contains(color))
                        .collect(Collectors.toList());
                count += result.size();
                result.stream().map(Rule::getContainer).forEach(tbc::add);
                rules.removeAll(result);
            }
            checking = new ArrayList<String>();
            checking.addAll(tbc);
        }

        return count;
    }

    @Override
    public Integer getTask2Solution() {
        return null;
    }
}
