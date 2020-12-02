package com.company;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Day2 implements Day{

    static class Password{
        int x;
        int y;
        String marker;
        String password;

         Password(String line){
            var parts = line.split(" ");
            marker = String.valueOf(parts[1].charAt(0));
            password = parts[2];
            parts = parts[0].split("-");
            x = parseInt(parts[0]);
            y = parseInt(parts[1]);
        }

        boolean isValid(){
             long count = Arrays.stream(password.split(""))
                     .filter(marker::equals)
                     .count();
             return x <= count && count <= y;
        }
    }
    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public Integer getTask1Solution() {
        return Math.toIntExact(readLines(INPUT).stream()
                .map(Password::new)
                .filter(Password::isValid)
                .count());
    }

    @Override
    public Integer getTask2Solution() {
        return null;
    }
}
