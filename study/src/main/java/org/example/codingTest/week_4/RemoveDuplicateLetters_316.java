package org.example.codingTest.week_4;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {


    class Solution {
        public String removeDuplicateLetters(String s) {
            char[] a = s.toCharArray();

            Stack<Character> stack = new Stack<>();
            Arrays.sort(a);

            for(int i = s.length()-1; 0<=i ;i--){
                if(stack.isEmpty()){
                    stack.push(a[i]);
                } else if(stack.peek() !=  a[i]){
                    stack.push(a[i]);
                }
            }
            StringBuffer sb = new StringBuffer();
            for(Character ch : stack){
                sb.append(ch);
            }

            return sb.toString();
        }
    }
}
