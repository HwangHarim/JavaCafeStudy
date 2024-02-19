package org.example.week_4.문제풀이.Question_4_4;


import org.example.week_4.문제풀이.TreeNode;

public class Solution {

    /**
     *균형 확인:<br/>
     * 이진 트리가 균형 잡혀있는지 확인하는 함수를 작성하라.<br/>
     *  이 문 제에서 균형 잡힌트리란모든 노드에 대해서<br/>
     *  왼쪽부분트리의 높이와 오른 쪽 부분 트리의 높이의 차이가 최대 하나인 트리를 의미한다.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(isBalanced(root.buildCompleteBinaryTree(5)));

    }
    static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);

        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // 에러 발견 • 반환
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
