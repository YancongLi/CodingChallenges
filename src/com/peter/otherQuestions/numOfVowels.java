package com.peter.otherQuestions;

/*
Find the number of vowels and consonants in a given string

Create a method that takes a string input and prints out and number of vowels and the number of consonants in that string input

(Vowels: a,e,i,o,u,y)
*/

public class numOfVowels {
    public static void main(String[] args) {
        String str1 = "HellO";
        String str2 = "there is a quiet Mouse";
        String str3 = "I am happy";

        numOfVowelsSolution(str1);//should return 2 vowels, 3 consonants
        numOfVowelsSolution(str2);//should return 10 vowels, 8 consonants
        numOfVowelsSolution(str3);//should return 4 vowels, 4 consonants
    }

    private static void numOfVowelsSolution(String str) {
        String vowels = "aeiouf";
        int numOfVowels = 0;
        int numOfConsonants = 0;
        String[] normalized = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : normalized) {
            stringBuilder.append(string);
        }
        String normalizedStr = stringBuilder.toString();
        int length = normalizedStr.length();

        for (Character c : normalizedStr.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                numOfVowels++;
            }
        }
        numOfConsonants = length - numOfVowels;
        String placeholder1 = numOfVowels > 1 ? "Number of Vowels: " : "Number of Vowel: ";
        String placeholder2 = numOfConsonants > 1 ? " | Number of consonants: " : " | Number of consonant: ";
        System.out.println(placeholder1 + numOfVowels + placeholder2 + numOfConsonants);
    }
}
