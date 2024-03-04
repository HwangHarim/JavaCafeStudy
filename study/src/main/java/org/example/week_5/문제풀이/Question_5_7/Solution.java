package org.example.week_5.문제풀이.Question_5_7;

public class Solution {

    int swapOddEvenBits(int x) {
        return ( ((x &0xaaaaaaaa) >>> 1) | ((x &0x55555555) << 1) );
    }
}
