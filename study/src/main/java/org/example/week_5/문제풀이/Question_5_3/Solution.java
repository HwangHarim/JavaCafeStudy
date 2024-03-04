package org.example.week_5.문제풀이.Question_5_3;

public class Solution {

    public static void main(String[] args) {
        Integer.toBinaryString(1024);
    }

    private String convert1bit(int data) {
        String[] d = String.valueOf(data).split("0");
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i].length() > max) {
                max = d[i].length();
                maxIndex = i;
            }
        }
        String result = "";
        if (maxIndex < d.length-1 && d[maxIndex+1] != "") {
            result = d[maxIndex] + "1" + d[maxIndex+1];
        }
        if (maxIndex > 0 && d[maxIndex-1] != "") {
            String re = d[maxIndex-1] + "1" + d[maxIndex];
            if (result.length() < re.length()) {
                return re;
            }
        }
        return result;
    }

}
