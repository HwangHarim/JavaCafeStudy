package org.example.week_5.문제풀이.Question_5_2;

public class Solution {

    String printBinary(double num){
        if(num >=1 || num <=0){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0){
            if(binary.length() >= 32){
                return "ERROR";
            }
            double r = num*2;
            if(r >= 1){
                binary.append(1);
                num = r-1;
            }else{
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
    String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder binary =new StringBuilder();
        double frac =0.5;
        binary.append (" . ");
        while (num > 0) {
        /* 길이 제한 설정: 문자 딘위로 32 */
            if (binary.length() > 32) {
                return "ERROR";
            }
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }
}
