package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;
import static java.lang.Math.toIntExact;

public class Day4 implements Day {

    class Passport {
        String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;

        List<String> validEcl = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

        void buildFrom(String line) {
            var keyValues = line.split(" ");
            for (var keyValue : keyValues) {
                setField(keyValue.split(":"));
            }
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

        boolean isValidExtended() {
            return validByr()
                    && validIyr()
                    && validEyr()
                    && validHgt()
                    && validHcl()
                    && validEcl()
                    && validPid();
        }

        boolean validByr() {
            return handleException(() -> fitsRange(this.byr, 1920, 2002));
        }

        boolean validIyr() {
            return handleException(() -> fitsRange(this.iyr, 2010, 2020));
        }

        boolean validEyr() {
            return handleException(() -> fitsRange(this.eyr, 2020, 2030));
        }

        boolean validHgt() {
            return handleException(() -> {
                var unit = hgt.substring(hgt.length() - 2);
                var value = hgt.substring(0, hgt.length() - 2);
                if ("in".equals(unit)) return fitsRange(value, 59, 76);
                if ("cm".equals(unit)) return fitsRange(value, 150, 193);
                return false;
            });
        }

        boolean validHcl() {
            return handleException(() -> {
                if ('#' != hcl.charAt(0) || hcl.length() != 7) return false;
                return hcl.substring(1).chars()
                        .filter(value -> (value >= 48 && value <= 57) || (value >= 97 && value <= 122))
                        .count() == 6;
            });
        }

        boolean validEcl() {
            return handleException(() -> validEcl.contains(ecl));
        }

        boolean validPid() {
            return handleException(
                    () -> pid.chars()
                            .filter(value -> value >= 48 && value <= 57)
                            .count() == 9);
        }

        private boolean fitsRange(String possibleInt, int i, int i2) {
            var parsed = parseInt(possibleInt);
            return parsed >= i && parsed <= i2;
        }

        private boolean handleException(Supplier<Boolean> action) {
            try {
                return action.get();
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public Integer getTask1Solution() {
        var passports = getPassports(INPUT);
        return toIntExact(passports.stream().filter(Passport::isValid).count());
    }

    @Override
    public Integer getTask2Solution() {
        var passports = getPassports(INPUT);
        return toIntExact(passports.stream().filter(Passport::isValidExtended).count());
    }

    public ArrayList<Passport> getPassports(String test) {
        var passports = new ArrayList<Passport>();
        passports.add(new Passport());
        readLines(test).forEach(line -> {
            if (line.isEmpty()) {
                passports.add(new Passport());
            } else {
                passports.get(passports.size() - 1).buildFrom(line);
            }
        });
        return passports;
    }
}
