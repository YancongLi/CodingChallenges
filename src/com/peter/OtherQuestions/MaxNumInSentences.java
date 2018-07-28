package com.peter.OtherQuestions;

public class MaxNumInSentences {

    public static void main(String[] args) {
        // write your code here
        String test1 = "The quick brown fox jumps over the lazy dog. Wow! What?";
        String test2 = "We test coders. Give us a try?";
        String test3 = "Forget  CVs..Save time . x x";

        System.out.println(solution(test1)); //9 : The quick brown fox jumps over the lazy dog
        System.out.println(solution(test2)); //4 : Give us a try
        System.out.println(solution(test3)); //2 : Save time
    }

    /*
        A function that returns the maximum number of words a sentence in a given String(multiple sentences) ,separating by (. ! ?)
    */
    public static int solution(String str) {
        int max = 0;

        final String[] sentences = str.split("\\.|\\!|\\?");

        for (String s : sentences) {
            int i, counter = 0;
            char ch[] = new char[s.length()];
            for (i = 0; i < s.length(); i++) {
                ch[i] = s.charAt(i);
                if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0))) {
                    counter++;
                }
            }

            if (counter > max) {
                max = counter;
            }
        }

        return max;
    }
}
