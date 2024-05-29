package org.example.codingTest.week_4;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int last = stack.pop();
                answer[last] = i - last;
            }
            stack.push(i);
        }

        return answer;
    }
}
