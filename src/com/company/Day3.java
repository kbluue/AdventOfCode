package com.company;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day3 implements Day {

    class Row {

        String value;

        public Row(String value) {
            this.value = value;
        }

        boolean hasTreeAt(int pos) {
            final int length = value.length();
            return value.charAt(pos % (length)) == '#';
        }
    }

    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public Integer getTask1Solution() {
        var rows = readLines(TEST).stream().map(Row::new).collect(toList());
        return travel(rows, 3, 1);
    }

    @Override
    public Integer getTask2Solution() {
        var rows = readLines(INPUT).stream().map(Row::new).collect(toList());
        return travel(rows, 1, 1)
                * travel(rows, 3, 1)
                * travel(rows, 5, 1)
                * travel(rows, 7, 1)
                * travel(rows, 1, 2);
    }

    private int travel(List<Row> rows, int right, int down) {
        int x = 0;
        int trees = 0;
        for (int y = 0; y < rows.size(); y += down) {
            trees += rows.get(y).hasTreeAt(x) ? 1 : 0;
            x += right;
        }
        return trees;
    }
}
