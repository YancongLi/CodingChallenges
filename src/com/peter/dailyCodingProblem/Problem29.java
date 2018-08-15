package com.peter.dailyCodingProblem;

/*
Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*/
public class Problem29 {
    public static void main(String[] args) {
        testRunLength("AAAABBBCCDAA");
        testRunLength("wwwwaaadexxxxxx");
        testRunLength("G");
        testRunLength("GG");
        testRunLength("AB");
        testRunLength("");
        testRunLength("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW");
    }

    private static void testRunLength(String origin) {
        String encoded = encodeStr(origin);
        System.out.println(encoded);
        String decoded = decodeStr(encoded);
        System.out.println(decoded);
        System.out.println(origin.equals(decoded));
        System.out.println("----");
    }

    private static String encodeStr(String string) {
        if (string.length() == 1) {
            return "1" + string;
        } else if (string.isEmpty()) {
            return "0";
        }
        int length = string.length();
        int pointer1 = 0;
        int pointer2 = 1;
        int lastIndex = length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int counterForEachLetter = 1;
        Character letter = string.charAt(pointer1);
        while (pointer2 < length) {
            if (string.charAt(pointer1) == string.charAt(pointer2)) {
                counterForEachLetter++;
                pointer2++;
            } else {
                stringBuilder.append(counterForEachLetter);
                stringBuilder.append(letter);
                counterForEachLetter = 1;
                pointer1 = pointer2;
                letter = string.charAt(pointer1);
                pointer2++;
            }
            if (pointer2 > lastIndex) {
                stringBuilder.append(counterForEachLetter);
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();

    }

    private static String decodeStr(String encoded) {
        if (encoded.equals("0")) {
            return "";
        } else if (encoded.length() == 2 && encoded.charAt(0) == 1) {
            return encoded.charAt(1) + "";
        }
        int repeatTimesForEachLetter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : encoded.toCharArray()) {
            if (Character.isDigit(character)) {
                repeatTimesForEachLetter = repeatTimesForEachLetter * 10 + Character.getNumericValue(character);
            } else {
                for (int i = 0; i < repeatTimesForEachLetter; i++) {
                    stringBuilder.append(character);
                }
                repeatTimesForEachLetter = 0;
            }
        }
        return stringBuilder.toString();
    }

}
