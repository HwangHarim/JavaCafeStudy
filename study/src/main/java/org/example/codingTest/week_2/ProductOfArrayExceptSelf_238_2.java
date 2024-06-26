package org.example.codingTest.week_2;
public class ProductOfArrayExceptSelf_238_2 {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int p =1;

        for(int i =0; i<nums.length;i++){
            result[i] = p;
            p *= nums[i];
        }

        p= 1;

        for(int i = nums.length-1; i>=0; i--){
            result[i] *=p;
            p *= nums[i];
        }
        return result;
    }
}
