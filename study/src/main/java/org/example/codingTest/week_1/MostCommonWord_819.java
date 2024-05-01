package org.example.codingTest.week_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+"," ").toLowerCase().split(" ");
        for(String word : words){
            if(!ban.contains(word)){
                counts.put(word, counts.getOrDefault(word, 0)+1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
