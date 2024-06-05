package org.example.codingTest.week_5;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    HashMap<String, Integer> map = new HashMap<>();

    public String solution(String[] participant, String[] completion) {

        String answer = "";

        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for (String goal : completion) {
            map.put(goal, map.get(goal) - 1);
        }

        for (Map.Entry<String, Integer> num : map.entrySet()) {
            if (num.getValue() != 0) {
                answer = num.getKey();
                break;
            }
        }

        return answer;
    }
}

