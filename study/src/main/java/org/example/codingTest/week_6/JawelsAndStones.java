package org.example.codingTest.week_6;

import java.util.HashMap;

class JawelsAndStones {

   static HashMap<String, Integer> map = new HashMap<>();

    public static int numJewelsInStones(String jewels, String stones) {
        int answer =0;
        for(String stone : stones.split("")){
            map.put(stone, map.getOrDefault(stone, 0)+1);
        }

        for(String jewel : jewels.split("")){
            answer += map.get(jewel);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

    }
}
