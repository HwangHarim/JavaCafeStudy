package org.example.codingTest.week_2;
import java.util.*;

public class ArrayPartition_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        for(int i =0; i<nums.length-1; i+=2){
            sum += Math.min(nums[i], nums[i+1]);
        }

        return sum;
    }
}
