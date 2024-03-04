package org.example.week_5.문제풀이.Question_5_1;

public class Solution {

    public static void main(String[] args) {

    }

    public int bitInsert(int m, int n, int i, int j) {
        m = bitDeleteFrom(m, j, i);
        n = leftBitShift(n, i);
        System.out.println("m: " + Integer.toBinaryString(m) + ", n: " + Integer.toBinaryString(n)
            + ", m + n: " + Integer.toBinaryString(m+n));
        return m + n;
    }

    private int bitDeleteFrom(int num, int start, int end) {
        int mask = (1 << (start + 1)) - 1;
        mask = mask >> end;
        mask = mask << end;
        return num & ~mask;
    }

    private int leftBitShift(int num, int j) {
        return num << j;
    }
}