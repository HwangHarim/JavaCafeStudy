package org.example.week_3.문제풀이;

import java.util.Stack;

public class Question_3_5 {
    /**
     * 스택 정렬: 가장 작은 값이 위로 오도록 스택을 정렬하는 프로그램을 작성하라.
     * 추가적으로 하나 정도의 스택은 사용해도 괜찮지만, 스택에 보관된 요소를 배열 등의 다른 자료구조로 복사할 수는 없다.
     * 스택은 push, pop, peek. isEmpty 네가지 연산을 제공해야 한다.
     */

    //정렬 해보기

    static class SortStack <T>{
        Stack<T> stackNew = new Stack<>();

        void sort(Stack s){
            Stack<T> r = new Stack<>();
            int tmp = (int) s.pop();
            while (!r.isEmpty() && (int)r.peek()>tmp){
                s.push(r.pop());
            }
            while(!r.isEmpty()){
                s.push(r.pop());
            }
        }
    }
}
