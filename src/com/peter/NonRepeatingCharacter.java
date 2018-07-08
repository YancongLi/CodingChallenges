package com.peter;

/*
Implement a function that takes a string and returns first character that does not appear
twice and more.

Example:
- "abacc" -> 'b'
- "xxyzx" -> 'y' ('y' appears first)

*/

import java.util.ArrayList;
import java.util.HashMap;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Character c1 = nonRepeating("abcab"); // should return 'c'
        System.out.println(c1);
        Character c2 = nonRepeating("abab"); // should return null
        System.out.println(c2);
        Character c3 = nonRepeating("aabbbc"); // should return 'c'
        System.out.println(c3);
        Character c4 = nonRepeating("aabbdbc"); // should return 'd'
        System.out.println(c4);
    }

    // Implement your solution below.
    public static Character nonRepeating(String s) {
        Character result;
        ArrayList<Character> characters = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            char key = c;
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
                characters.add(key);
            } else {
                map.put(key, value + 1);
                if (value + 1 == 2) {
                    characters.remove(characters.indexOf(key));
                }
            }
        }
        result = characters.size() == 0 ? null : characters.get(0);

        return result;
    }
}
