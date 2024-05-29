package org.example.codingTest.week_4;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && !stack.isEmpty() && (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')) {
                if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                    i++;
                    continue;
                } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                    i++;
                    continue;
                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                    i++;
                    continue;
                }
                return false;
            }
            if(i<s.length()){
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}

