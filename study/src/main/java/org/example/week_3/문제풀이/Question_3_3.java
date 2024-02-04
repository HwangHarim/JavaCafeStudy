package org.example.week_3.문제풀이;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Question_3_3 {
    // 추가적 공부 필요
    public static class SetOfStacks{
        ArrayList stacks = new ArrayList();
        public int capacity;

        public SetOfStacks(int capacity){
            this.capacity = capacity;
        }

        public Stack getLastStack() {
            if (stacks.size() == 0)
                return null;
            return (Stack) stacks.get(stacks.size() - 1);

        }


        public void push(int v) {
            Stack last = getLastStack();
            if (last != null && !last.isFull()) {
                last.push(v);
            } else {
                Stack stack = new Stack(capacity);
                stack. push(v);
                stacks.add(stack);
            }
        }

        public int pop() {
            Stack last = getLastStack();
            if (last == null) {
                throw new EmptyStackException();
            }

            int v = last.pop();

            if (last.size() == 0) {
                stacks.remove(stacks.size() - 1);
            }

            return v;
        }

    }

    static public class Stack{
        private int capacity;
        public Node top, bottom;
        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public void join(Node above, Node below){
            if (below != null){
                below.above = above;
            }
            if (above != null){
                above.below = below;
            }
        }

        public boolean push(int v) {
            if (size >= capacity){
                return false;
            }

            size++ ;

            Node n = new Node(v);

            if (size == 1){
                bottom =n;
            }

            join(n, top);
            top  = n;

            return true;
        }

        public int pop() {
            Node t =top;
            top =top.below;
            size--;
            return t.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom =bottom.above;

            if (bottom != null)
                bottom.below = null;
            size--;
            return b.value;
        }

        public int size(){
            return size;
        }

        public boolean isFull(){
            return
        }
    }

    static class Node{
        Node above;
        Node below;
        int value;

        public Node(Node above, Node below){
            this.above = above;
            this.below = below;
        }

        public Node(int value){
            this.value = value;
        }
    }
}
