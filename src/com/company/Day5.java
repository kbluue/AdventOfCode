package com.company;

import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Day5 implements Day {

    static class Seat {

        int row;
        int column;

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public Seat(int row, int column) {
            this.row = row;
            this.column = column;
        }

        static Seat of(String line) {
            var row = line.substring(0, line.length() - 3);
            row = row.replaceAll("F", "0").replaceAll("B", "1");
            var column = line.substring(line.length() - 3);
            column = column.replaceAll("L", "0").replaceAll("R", "1");
            return new Seat(parseInt(row, 2), parseInt(column, 2));
        }

        int getId() {
            return row * 8 + column;
        }
    }

    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public Integer getTask1Solution() {
        return readLines(INPUT).stream()
                .map(Seat::of)
                .mapToInt(Seat::getId)
                .max()
                .orElse(-1);
    }

    @Override
    public Integer getTask2Solution() {
        var possibleRow = readLines(INPUT).stream()
                .map(Seat::of)
                .collect(Collectors.groupingBy(Seat::getRow))
                .values()
                .stream()
                .filter(seats -> seats.size() == 7)
                .findAny()
                .orElseThrow();

        var row = possibleRow.get(0).getRow();
        var occupiedColumns = possibleRow.stream().map(Seat::getColumn).collect(toList());
        var column = range(0, 8)
                .filter(value -> !occupiedColumns.contains(value))
                .findFirst().orElse(-1);

        return new Seat(row, column).getId();
    }
}
