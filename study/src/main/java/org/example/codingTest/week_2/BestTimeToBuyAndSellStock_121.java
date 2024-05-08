package org.example.codingTest.week_2;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int target =Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < target) {
                target = price;
            } else {
                max = Math.max(max, price - target);
            }
        }

        if(max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
