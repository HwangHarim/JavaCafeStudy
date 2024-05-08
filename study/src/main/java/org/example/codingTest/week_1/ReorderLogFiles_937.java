package org.example.codingTest.week_1;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> words = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        for(String log : logs){
            String[] a = log.split(" ");
            if(Character.isDigit(a[1].charAt(0))){
                numbers.add(log);
            }

            words.add(log);
        }

        words.sort((o1, o2) -> {
            String[] o1x = o1.split(" ",2);
            String[] o2x = o2.split(" ",2);

            int compared = o1x[1].compareTo(o2x[1]);

            if(compared == 0){
                return o1x[0].compareTo(o2x[0]);
            }

            return compared;
        });

        words.addAll(numbers);

        return words.toArray(new String[0]);

    }
}
