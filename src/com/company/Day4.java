package com.company;

import java.util.ArrayList;

public class Day4 implements Day {

    class Passport {
        String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;

        Passport buildFrom(String line) {
            var keyValues = line.split(" ");
            for (var keyValue : keyValues) {
                setField(keyValue.split(":"));
            }
            return this;
        }

        void setField(String[] keyValue) {
            if (keyValue.length < 2) return;
            if ("byr".equals(keyValue[0])) byr = keyValue[1];
            if ("iyr".equals(keyValue[0])) iyr = keyValue[1];
            if ("eyr".equals(keyValue[0])) eyr = keyValue[1];
            if ("hgt".equals(keyValue[0])) hgt = keyValue[1];
            if ("hcl".equals(keyValue[0])) hcl = keyValue[1];
            if ("ecl".equals(keyValue[0])) ecl = keyValue[1];
            if ("pid".equals(keyValue[0])) pid = keyValue[1];
            if ("cid".equals(keyValue[0])) cid = keyValue[1];
        }

        boolean isValid() {
            return byr != null && iyr != null && eyr != null && hgt != null && hcl != null
                    && ecl != null && pid != null;
        }
    }

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public Integer getTask1Solution() {
        var passports = new ArrayList<Passport>();
        passports.add(new Passport());
        readLines(INPUT).forEach(s -> {
            if (s.isEmpty()) {
                passports.add(new Passport());
            } else {

                passports.get(passports.size() - 1).buildFrom(s);
            }
        });
        return Math.toIntExact(passports.stream().filter(Passport::isValid).count());
    }

    @Override
    public Integer getTask2Solution() {
        return null;
    }
}
