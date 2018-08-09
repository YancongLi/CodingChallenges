package com.peter.dailyCodingProblem;

/*
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem22 {
    public static void main(String[] args) {
        String[] setOfWords1 = {"quick", "brown", "the", "fox"};
        String string1 = "thequickbrownfox";
        System.out.println(Arrays.toString(reconstructWordsFromString(setOfWords1, string1)));
        //should return ['the', 'quick', 'brown', 'fox']

        String[] setOfWords2 = {"bed", "bath", "bedbath", "and", "beyond"};
        String string2 = "bedbathandbeyond";
        System.out.println(Arrays.toString(reconstructWordsFromString(setOfWords2, string2)));
        //should return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond']
    }

    private static String[] reconstructWordsFromString(String[] dict, String string) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(dict));
        ResultObject resultObject = helper(set, string);
        if (resultObject.aBoolean) {
            return resultObject.strings.toArray(new String[resultObject.strings.size()]);
        }
        return null;
    }

    private static ResultObject helper(Set<String> set, String string) {
        if (string.length() == 0) {
            return new ResultObject(new ArrayList<>(), true);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i< string.length() + 1; i ++) {
            String prefix = string.substring(0, i);
            String suffix = string.substring(i);
            if (set.contains(prefix)) {
                ResultObject  resultObject = helper(set, suffix);
                if (resultObject.aBoolean) {
                    resultObject.strings.add(0, prefix);
                    return new ResultObject(resultObject.strings, true);
                }
            }
        }
        return new ResultObject(new ArrayList<>(), false);
    }

    static class ResultObject {
        ArrayList<String> strings;
        boolean aBoolean;

        ResultObject(ArrayList<String> strings, Boolean aBoolean) {
            this.strings = strings;
            this.aBoolean = aBoolean;
        }
    }
}
