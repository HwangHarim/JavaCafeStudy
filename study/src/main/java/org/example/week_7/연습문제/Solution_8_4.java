package org.example.week_7.연습문제;

import java.util.ArrayList;
import java.util.List;

public class Solution_8_4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 예시 입력
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), subsets);
        ArrayList<Integer> set = new ArrayList<>(List.of(1,2,3));
        getSubsets(set, 0);

//        for (List<Integer> subset : subsets) {
//            System.out.println(subset);
//        }
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    //재귀
    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSets;
        if (set.size() == index) { // 조기 사례 - 공집합 추가
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>()); // 공집합
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

    // 조합론
    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        int max = 1 << set.size(); /* 2^n 계산 */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubSets.add(subset);
        }
        return allSubSets;
    }
    ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        new ArrayList<Integer>();
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}