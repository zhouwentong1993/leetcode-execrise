package com.wentong.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!match(pop, c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char s, char t) {
        switch (s) {
            case '{':
                return t == '}';
            case '[':
                return t == ']';
            case '(':
                return t == ')';
            default:
                return false;
        }
    }

}
