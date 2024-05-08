package org.example.codingTest.week_2;

import java.util.*;

public class TwoSum_1 {
    // 4 ms
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            numsMap.put(nums[i], i);
        }

        for(int i =0; i<nums.length; i++){
            if(numsMap.containsKey(target -nums[i])&& i != numsMap.get(target -nums[i])){
                return new int[]{i, numsMap.get(target-nums[i])};
            }
        }
        return null;
    }

    // 0ms
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 1; i < nums.length; i++) {
//            for (int l = i; l < nums.length; l++) {
//                if (nums[l] + nums[l - i] == target) {
//                    return new int[] { l, l - i };
//                }
//            }
//        }
//        return null;
//    }

}
