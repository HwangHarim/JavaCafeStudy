package org.example.codingTest.week_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> results = new HashMap<>();

            for(String s : strs){
                char[] words = s.toCharArray();

                Arrays.sort(words);
                String key = String.valueOf(words);

                if(!results.containsKey(key)){
                    results.put(key, new ArrayList<>());
                }
                results.get(key).add(s);
            }
            return new ArrayList<>(results.values());
        }
}
