package org.example.algorithm.week_7.문제풀이.Question_8_11;

public class Solution {

    int makeChange(int amount, int[] denoms, int index) {

        if (index >= denoms.length - 1) {
            return 1; // 마지막 denom
        }

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }

        return ways;
    }

    int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    /*----------------------------------------------------*/


    int makeChange2(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length]; // 이미 계산된 값
        return makeChange2(n, denoms, 0, map);
    }

    int makeChange2(int amount, int[] denoms, int index, int[][] map) {

        if(map[amount][index] > 0){
            return map[amount][index];
        }

        if (index >= denoms.length - 1) {
            return 1; // 마지막 denom
        }

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }
}