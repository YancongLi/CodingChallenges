package com.peter.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;

/*
Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly

["This    is    an","example  of text","justification.    "]
["This    is    an","example  of text","justification.  "]
*/
public class Problem28 {
    public static void main(String[] args) {
        String[] listOfWords = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        System.out.println(Arrays.toString(justifyText(listOfWords, 16)));
        for (String str: justifyText(listOfWords, 16)) {
            System.out.println(str.length());//should return 16
        }
        /* should return:
        ["the  quick brown", # 1 extra space on the left
        "fox  jumps  over", # 2 extra spaces distributed evenly
        "the   lazy   dog"] # 4 extra spaces distributed evenly
        */
        System.out.println("---");
        String[] listOfWords2 = {"This", "is", "an", "example", "of", "text", "justification."};
        for (String str: justifyText(listOfWords, 16)) {
            System.out.println(str.length());//should return 16
        }
    }

    private static String[] justifyText(String[] listOfWords, int k) {
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<String> groupOfWordsInKLength = new ArrayList<>(Arrays.asList(listOfWords));
        groupOfWordsInKLength = groupWords(groupOfWordsInKLength, k);
        //System.out.println(groupOfWordsInKLength);
        ArrayList<ArrayList<String>> listOfGroupedWords = coverStringElementsToArrayOfWords(groupOfWordsInKLength);
        //System.out.println(listOfGroupedWords);
        resultList = justify(listOfGroupedWords, k);
        return resultList.toArray(new String[0]);
    }

    private static ArrayList<String> justify(ArrayList<ArrayList<String>> listOfGroupedWords, int length) {
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> listOfGroupedStrings : listOfGroupedWords) {
            //Precondition: |words| can fit in |length|.
            //    Justifies the words using the following algorithm:
            //        - Find the smallest spacing between each word (available_spaces / spaces)
            //        - Add a leftover space one-by-one until we run out
            if (listOfGroupedStrings.size() == 1) {
                String word = listOfGroupedStrings.get(0);
                int numOfSpaces = length - word.length();
                String space = "";
                for (int i = 0; i < numOfSpaces; i++) {
                    space += " ";
                }
                result.add(word + space);
                continue;
            }

            int wordsTotalLength = 0;
            for (String word : listOfGroupedStrings) {
                wordsTotalLength += word.length();
            }
            int spacesToDistribute = length - wordsTotalLength;
            int numOfSpaces = listOfGroupedStrings.size() - 1;
            int smallestSpace = (int) Math.floor(spacesToDistribute / numOfSpaces);
            int leftoverSpace = spacesToDistribute - (numOfSpaces * smallestSpace);
            StringBuilder justifiedWords = new StringBuilder();
            for (String word : listOfGroupedStrings) {
                justifiedWords.append(word);
                String currentSpace = "";
                for (int i = 0; i < smallestSpace; i++) {
                    currentSpace += " ";
                }
                if (leftoverSpace > 0) {
                    currentSpace += " ";
                    leftoverSpace -= 1;
                }
                justifiedWords.append(currentSpace);
            }
            result.add(justifiedWords.toString().trim());
        }

        return result;
    }

    private static ArrayList<String> groupWords(ArrayList<String> groupOfWordsInKLength, int k) {
        ArrayList<String> groups = new ArrayList<>();
        String currentLine = "";
        for (String word : groupOfWordsInKLength) {
            if ((currentLine + " " + word).length() > k) {
                groups.add(currentLine);
                currentLine = "";
            }
            currentLine = currentLine + (" " + word);
        }
        groups.add(currentLine);
        return groups;
    }

    private static ArrayList<ArrayList<String>> coverStringElementsToArrayOfWords(ArrayList<String> groupOfWordsInKLength) {
        //Returns groupings of |words| whose total length, including 1 space in between,
        //is less than |k|.
        ArrayList<ArrayList<String>> tempList = new ArrayList<>();
        for (String words : groupOfWordsInKLength) {
            String[] wordsInOneLine = words.split(" ");
            ArrayList<String> wordsInOneLineAsArrayList = new ArrayList<>(Arrays.asList(wordsInOneLine));
            wordsInOneLineAsArrayList.remove(0);
            tempList.add(wordsInOneLineAsArrayList);
        }
        return tempList;
    }

}
