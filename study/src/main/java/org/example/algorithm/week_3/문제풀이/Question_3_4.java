package org.example.algorithm.week_3.문제풀이;

import java.util.Stack;

public class Question_3_4 {
    /**
     * 스택으로 큐 : 스택 두개로 큐 하나를 구현한 MyQueue 클래스를 구현하라.
     */

    static class MyQueue <T>{
        Stack<T> stack1;
        Stack<T> stack2;

        MyQueue() {
          stack1 = new Stack<>();
          stack2 = new Stack<>();
        }

        public int size(){
            return stack1.size() + stack2.size();
        }

        public void add(T value){
            stack1.push(value);
        }

        public void shiftStacks2(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }

        public void shiftStacks1(){
            if(stack1.isEmpty()){
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }
        }

        public T peek() {
            shiftStacks2();// stackOldest에 현재 원소들이 들어 있다.
            T reuslt = stack2.peek();
            shiftStacks1();
            return reuslt; // 가장 오래된 원소를 반환한다.
        }

        public T remove() {
            shiftStacks2();
            T reuslt = stack2.pop();// stackOldest에 현재 원소들이 들어 있다.
            shiftStacks1();
            return reuslt; // 가장 오래된 원소를 제거한다.
        }
    }
}
