package com.company;

public class Day5 implements Day {

    static class Seat{

        int row;
        int column;

        public Seat(int row, int column) {
            this.row = row;
            this.column = column;
        }

        static Seat of(String line){
            var row = line.substring(0, line.length()-3);
            row = row.replaceAll("F", "0").replaceAll("B", "1");
            var column = line.substring(line.length() -3);
            column = column.replaceAll("L", "0").replaceAll("R", "1");
            return new Seat(Integer.parseInt(row, 2), Integer.parseInt(column, 2));
        }

        int getId(){
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
        return null;
    }
}
