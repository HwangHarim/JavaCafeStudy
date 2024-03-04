package org.example.week_5.문제풀이.Question_5_6;

public class Solution {

    int bitSwapRequired(int a, int b) {
        int count = 0;
        for(int c =a^ b;c!=0; c=c&(c-1)){
            count++;
        }
        return count;
    }
}
