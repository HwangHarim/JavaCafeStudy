package org.example.algorithm.week_3.문제풀이;

import java.util.EmptyStackException;


public class Question_3_1 {
    /**
     * 한 개로 세개 : 배열 한 개로 스택 세 개를 어떻게 구현할지 설명하라
     *
     * @TODO 배열 마다 영역을 나누어 싪행한다.(os : 경계주소, 임계값);
     */

    static class FixedMultiStack {

        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            this.stackCapacity = stackSize;
            this.values = new int[stackSize * numberOfStacks];
            this.sizes = new int[numberOfStacks];
        }

        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        public boolean isEmpty(int stackNum){
            return sizes[stackNum] == 0;
        }

        private int indexOfTop(int stackNum){
            int offset = stackNum*stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }

        public void push(int stackNum, int value) throws StackOverflowError{
            if(isFull(stackNum)){
                throw new StackOverflowError();
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum){
            if(isEmpty(stackNum)){
                throw new EmptyStackException();
            }
            int topIndex = indexOfTop(stackNum);
            int top = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return top;
        }

        public int peek(int stackNum){
            if(isEmpty(stackNum)){
                throw new EmptyStackException();
            }
            int topIndex = indexOfTop(stackNum);
            return values[topIndex];
        }

    }
}