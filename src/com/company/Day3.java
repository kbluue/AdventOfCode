package com.company;

import java.util.stream.Collectors;

public class Day3 implements Day{

    class Row{

        String value;

        public Row(String value) {
            this.value = value;
        }

        boolean hasTreeAt(int pos){
            final int length = value.length();
            return value.charAt(pos%(length)) == '#';
        }
    }
    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public Integer getTask1Solution() {
        var rows = readLines(INPUT).stream().map(Row::new).collect(Collectors.toList());
        int y = 0;
        int trees = 0;
        for (Row row : rows) {
            trees += row.hasTreeAt(y) ? 1 : 0;
            y += 3;
        }
        return trees;
    }

    @Override
    public Integer getTask2Solution() {
        return null;
    }
}
