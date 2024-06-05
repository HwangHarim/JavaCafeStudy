package org.example.codingTest.week_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    HashMap<Integer, Integer> map = new HashMap<>();


    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }


    int[][] scoreArr = new int[map.size()][2];
    int index =0;

    for(Map.Entry<Integer, Integer> number : map.entrySet()){
        scoreArr[index] = new int[] {(int)number.getKey(), (int)number.getValue()};
        index++;
    }

    Arrays.sort(scoreArr, (o1, o2) -> o2[1] - o1[1]);
    int[] answer = new int[k];

    for(int i =0; i<k; i++){
        answer[i] = scoreArr[i][0];
    }

    return answer;
    }
}
