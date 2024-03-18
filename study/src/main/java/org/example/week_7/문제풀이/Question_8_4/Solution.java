package org.example.week_7.문제풀이.Question_8_4;

import java.util.ArrayList;

public class Solution {

    //재귀
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSets;
        if (set.size() == index) { // 조기 사례 - 공집합 추가
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>()); //공집합
        } else {
        }
        allSubSets = getSubsets(set, index + 1);
        int item = set.get(index);
        ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<>();
        for (ArrayList<Integer> subset : allSubSets) {
            ArrayList<Integer> newSubSet = new ArrayList<>();
            newSubSet.addAll(subset);
            newSubSet.add(item);
            moreSubSets.add(newSubSet);
        }
        allSubSets.addAll(moreSubSets);
        return allSubSets;
    }

    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();

        /* 2^n 계산 */
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubSets.add(subset);
        }
        return allSubSets;
    }

    ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}
