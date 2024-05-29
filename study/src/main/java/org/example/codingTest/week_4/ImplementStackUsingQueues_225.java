package org.example.codingTest.week_4;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    Queue<Integer> queue = new LinkedList<>();

    ImplementStackUsingQueues_225(){

    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
