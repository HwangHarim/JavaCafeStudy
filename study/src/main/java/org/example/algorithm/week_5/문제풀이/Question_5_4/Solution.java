package org.example.algorithm.week_5.문제풀이.Question_5_4;

public class Solution {
    int getPrev(int n) {
        int temp = n;
        int c0 =0;
        int c1 =0;
        while ((temp & 1) == 1){
            c0++;
            temp>>=1;
        }
        if (temp == 0) return -1;
        while (((temp & 1) == 0) &&(temp != 0)) {
                c0++;
                temp >>= 1;
        }
        int p = c0 + c1; // 1수열로 끝나지 않으면서 밴 오른쪽에 위치한 1비트의 위치
        n &= ((~0) << (p + 1)); // p번째 비트부터 차례로 삭제
        int mask = (1 << (c1 + 1)) - 1; // 1비트가 (c1 + 1)개인 1수열
        n = mask << (c0 - 1);
        return n;
    }
}
