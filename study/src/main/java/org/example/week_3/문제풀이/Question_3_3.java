package org.example.week_3.문제풀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Question_3_3 {
    // 추가적 공부 필요

    public static class SetOfStacks {
        List<Stack<Integer>> stacks = new ArrayList<>();
        public int cap;

        public SetOfStacks(int cap) {
            this.cap = cap;
        }

        public Stack<Integer> getLastStack() {
            if (stacks.size() == 0) return null;
            return stacks.get(stacks.size() - 1);
        }

        public void push(int v) {
            Stack<Integer> last = getLastStack();
            if (last != null && !isFull(last)) {
                last.push(v);
            } else {
                Stack<Integer> stack = new Stack<>();
                stack.push(v);
                stacks.add(stack);
            }
        }

        public int pop() {
            Stack<Integer> last = getLastStack();
            int v = last.pop();
            if (last.size() == 0) {
                stacks.remove(stacks.size() - 1);
            }
            return v;
        }

        public boolean isFull(Stack<Integer> stack) {
            return stack.size() == cap;
        }

        public static void main(String[] args) {
            SetOfStacks set = new SetOfStacks(5);
            for (int i = 0; i < 34; i++) {
                set.push(i);
            }
            for (int i = 0; i < 34; i++) {
                System.out.println("Popped " + set.pop());
            }
        }
    }
}
