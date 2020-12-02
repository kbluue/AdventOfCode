package com.company;

import static java.lang.Integer.parseInt;
import static java.lang.Math.toIntExact;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;

public class Day2 implements Day {

    class Password {
        int x;
        int y;
        String marker;
        String password;

        Password(String line) {
            var parts = line.split(" ");
            marker = valueOf(parts[1].charAt(0));
            password = parts[2];
            parts = parts[0].split("-");
            x = parseInt(parts[0]);
            y = parseInt(parts[1]);
        }

        boolean isValid() {
            long count = stream(password.split(""))
                    .filter(marker::equals)
                    .count();
            return x <= count && count <= y;
        }

        boolean isValidTobaggan() {
            int count = password.charAt(x - 1) == marker.charAt(0) ? 1 : 0;
            count += (password.charAt(y - 1) == marker.charAt(0) ? 1 : 0);
            return count == 1;
        }
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public Integer getTask1Solution() {
        return toIntExact(readLines(INPUT).stream()
                .map(Password::new)
                .filter(Password::isValid)
                .count());
    }

    @Override
    public Integer getTask2Solution() {
        return toIntExact(readLines(INPUT).stream()
                .map(Password::new)
                .filter(Password::isValidTobaggan)
                .count());
    }
}
