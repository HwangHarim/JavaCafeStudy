package org.example.codingTest.week_2;
import java.util.*;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int volume =0;

        for(int i =0; i<height.length; i++){
            while(!stack.isEmpty()&& height[i]>height[stack.peek()]){
                Integer top = stack.pop();

                if(stack.isEmpty()){
                    break;
                }

                int distance = i - stack.peek() - 1;

                int waters = Math.min(height[i], height[stack.peek()]) - height[top];
                volume += distance*waters;
            }

            stack.push(i);
        }

        return volume;
    }
}
