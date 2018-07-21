package com.peter.dailyCodingProblem;

/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/

public class Problem7 {
    public static void main(String[] args) {
        String str1 = "111";
        System.out.println(numOfWays(str1)); // should return 3 ("aaa", "ka", and "ak").

        String str2 = "";
        System.out.println(numOfWays(str2)); // should return 1

        String str3 = "011";
        System.out.println(numOfWays(str3)); // should return 0

        String str4 = "1234";
        System.out.println(numOfWays(str4)); // should return 3 ("abcd", "lcd", "awd")

        String str5 = "0";
        System.out.println(numOfWays(str5)); // should return 0

        String str6 = "1203";
        System.out.println(numOfWays(str6)); // should return 1 ("atc")

        String str7 = "226";
        System.out.println(numOfWays(str7)); // should return 3 ("bz", "vf", "bbf")
    }

    private static int numOfWays(String str) {
        if (str.length() >=1 ){
            if (str.charAt(0) == '0') {
                return 0;
            }
        }
        if (str.length() <= 1) {
            return 1;
        }
        int sum = 0;
        if (Integer.parseInt(str.substring(0, 2)) <= 26) {
            sum = numOfWays(str.substring(2));
        }
        sum += numOfWays(str.substring(1));
        return sum;
    }
}
