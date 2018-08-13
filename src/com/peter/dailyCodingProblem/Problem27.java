package com.peter.dailyCodingProblem;

import java.util.*;

/*
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
*/
public class Problem27 {
    public static void main(String[] args) {
        System.out.println(areBracketsBalanced("([])[]({})"));//should return true
        System.out.println(areBracketsBalanced("()[]{}"));//should return true
        System.out.println(areBracketsBalanced("{[]}"));//should return true
        System.out.println(areBracketsBalanced("([)]"));//should return false
        System.out.println(areBracketsBalanced("((()"));//should return false
    }

    private static boolean areBracketsBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(c) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
