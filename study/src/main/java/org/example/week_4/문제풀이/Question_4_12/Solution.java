package org.example.week_4.문제풀이.Question_4_12;

public class Solution {
    int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        /* 루트에서 시작해서 합의 조견을 만족하는 경로의 개수를 셰준다. */
        int pathsFromRoot countPathsWithSumFro빼 ode(root， targetSum, 0);
        /* 같은 방법으로 왼쪽 노드와 오른쪽 노드에서 정로를 시작한다. */
        int pathsOnLeft =countPathsWithSum(root.left, targetSum);
        int pathsOnRight =countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }
    /* 현재 노드에서 시작해서 합의 조건을 만족하는 경로의 개수를 반환한다. */
    int countPathsWithSumFro빼 ode(TreeNode node , int targetSum , int currentSum) {
        if (node == null) return 0;
        currentSum += node.data;
        int totalPaths =0;
        if (currentSum == targetSum) { // 합의 조건올 만족하는 정로를 찾았다.
            totalPaths++;
            totalPaths += countPathsWithSumFro빼 ode(node.left， targetSum, currentSum);
            totalPaths += countPathsWithSumFro빼ode(node.right， targetSum, currentSum);
            return totalPaths;
        }
    }
}
