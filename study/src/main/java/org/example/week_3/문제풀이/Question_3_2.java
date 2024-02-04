package org.example.week_3.문제풀이;

import java.util.Stack;

public class Question_3_2 {
    /**
     * 스택 MIN : 기보적인 push pop 기능이 구현된 스태에서 최솟값을 반환하는 min 함수를 추가하려고 한다. 어떻게 설계할 수 있겠는가?
     * push, pop, min연산은 모두 O(1)을시간에 동작해야한다.
     */

    static class MinQueue{

    }

    static class StackWithMin extends Stack {
        Stack s2;
        public StackWithMin(){
            s2 = new Stack();
        }

        public void push(int value){
            if(value <= min()){
                s2.push(value);
            }
            super.push(value);
        }

        public Integer pop(){
            int value = (int) super.pop();
            if(value == min()){
                s2.pop();
            }
            return value;
        }

        public int min(){
            if(s2.isEmpty()){
                return Integer.MAX_VALUE;
            }else{
                return (int) s2.peek();
            }
        }
    }
}