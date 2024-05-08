package org.example.codingTest.week_2;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        for(int start= 0; start<nums.length; start++){
            for(int index = start+1; index<nums.length; index++){
                int sum = nums[start] + nums[index];

                if(sum == target){
                    return new int[]{start, index};
                }

            }
        }
        return null;
    }
}
