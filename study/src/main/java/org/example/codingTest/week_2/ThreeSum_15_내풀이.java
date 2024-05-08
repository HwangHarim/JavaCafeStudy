package org.example.codingTest.week_2;

import java.util.*;

public class ThreeSum_15_내풀이 {

    boolean[] visited;
    int[] nums;
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        for (int i = 0; i < nums.length; i++) {
            this.visited = new boolean[nums.length];
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(1, i, nums[i], list);
        }

        return answer;
    }

    public void dfs(int level, int index, int sum, List<Integer> list) {
        if (sum == 0 && list.size() == 3) {
            List<Integer> result = new ArrayList<>(list);

            for (List<Integer> aw : answer) {
                if (Objects.equals(aw.get(0), result.get(0)) && Objects.equals(aw.get(1),
                    result.get(1)) && Objects.equals(aw.get(2), result.get(2))) {
                    return;
                }
            }

            answer.add(result);
            return;
        }

        if (3 < list.size()) {
            return;
        }

        for (int i = index + 1; i < this.nums.length; i++) {
            if (!this.visited[i]) {
                visited[i] = true;
                list.add(this.nums[i]);
                dfs(level + 1, i, sum + this.nums[i], list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
