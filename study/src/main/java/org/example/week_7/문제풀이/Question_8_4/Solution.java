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

        }
        return allSubSets;
    }

     /*
    집합 [1, 2, 3]의 모든 부분집합을 구하는 예를 들어보겠습니다.

        집합 크기는 3이므로, max = 1 << 3 = 8입니다.
            - 이는 0부터 7까지의 숫자를 이진수로 표현했을 때의 모든 경우의 수와 같습니다.
            - 0부터 7까지 각 숫자를 이진수로 표현하면 000, 001, 010, 011, 100, 101, 110, 111입니다.
                이는 집합 [1, 2, 3]의 부분집합을 나타냅니다.
                - 예를 들어, 3을 이진수로 표현하면 011이고, 이는 집합 [1, 2]에 해당합니다.
                - 5를 이진수로 표현하면 101이며, 이는 집합 [1, 3]에 해당합니다.
     */

    ArrayList<ArrayList<Integer>> getSubsets2 (ArrayList < Integer > set) {
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();

        /* 2^n 계산 */
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubSets.add(subset);
        }
        return allSubSets;
    }

    ArrayList<Integer> convertIntToSet ( int x, ArrayList<Integer > set){
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