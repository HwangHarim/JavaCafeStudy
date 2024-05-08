package org.example.codingTest.week_2;
import java.util.*;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int sum =1;
        List<Integer> zeroList = new ArrayList<>();

        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroList.add(i);
                continue;
            }

            sum *= nums[i];
        }

        int[] answer = new int[nums.length];

        if(!zeroList.isEmpty()&&nums.length == zeroList.size()){
            return nums;
        }

        for(int i =0; i<answer.length;i++){
            if(zeroList.isEmpty()){

                answer[i] = sum/nums[i];
            }else{
                if(zeroList.contains(i)){
                    if(1<zeroList.size()){
                        answer[i] = 0;
                        continue;
                    }
                    answer[i] = sum;
                } else{
                    answer[i] = 0;
                }
            }

        }

        return answer;
    }
}
