package com.peter.OtherQuestions;

/*
Find the number of vowels and consonants in a given string

Create a method that takes a string input and prints out and number of vowels and the number of consonants in that string input

(Vowels: a,e,i,o,u,y)
*/

import javafx.util.Pair;
import java.util.ArrayList;

public class numOfVowels {
    public static void main(String[] args) {
        String str1 = "HellO";
        String str2 = "there is a quiet Mouse";
        String str3 = "I am happy";

        System.out.println(numOfVowelsSolution(str1).getKey() + " vowel(s), " + numOfVowelsSolution(str1).getValue() + " consonant(s).");//should return 2 vowels, 3 consonants
        System.out.println(numOfVowelsSolution(str2).getKey() + " vowel(s), " + numOfVowelsSolution(str2).getValue() + " consonant(s).");//should return 10 vowels, 8 consonants
        System.out.println(numOfVowelsSolution(str3).getKey() + " vowel(s), " + numOfVowelsSolution(str3).getValue() + " consonant(s).");//should return 4 vowels, 4 consonants
    }

    private static Pair<Integer, Integer> numOfVowelsSolution(String str) {
        ArrayList<Character> listOfVowels = new ArrayList<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('y');
        }};
        int numOfVowels = 0;
        String[] normalized = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: normalized) {
            stringBuilder.append(string);
        }
        String normalizedStr = stringBuilder.toString();
        int length = normalizedStr.length();

        for (Character c : normalizedStr.toLowerCase().toCharArray()) {
            if (listOfVowels.contains(c)) {
                numOfVowels++;
            }
        }
        return new Pair<>(numOfVowels, length - numOfVowels);
    }
}
