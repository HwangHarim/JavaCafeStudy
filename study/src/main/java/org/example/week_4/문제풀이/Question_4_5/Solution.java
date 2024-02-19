package org.example.week_4.문제풀이.Question_4_5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * BST 검증: <br/>
     * 주어진 이진 트리가 이진 탐색 트리인지 확인하는 함수를 작성 하라.
     */
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var init = root.buildCompleteBinaryTree(5);
        printTree(init);
        System.out.println(checkBST(init));
    }

    static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
    static Integer last_printed = null;
    static boolean checkBST(TreeNode n) {

        if (n == null) {
            return true;
        }
        // 왼쪽을 재귀적으로 검사
        if (!checkBST(n.left)) {
            return false;
        }
        // 현재 노드 검사
        if (last_printed != null && n.data <= last_printed) {
            return false;
        }
        last_printed = n.data;

        // 오른쪽을 재궈적으로 검사
        return checkBST(n.right);// 검사 통과!
    }

    static class TreeNode {
        public int data;

        public TreeNode left;
        public TreeNode right;
        private static int count = 0;

        public TreeNode(int data) {
            this.data = data;
        }
        public TreeNode buildCompleteBinaryTree(int level) {
            if (level == 0) {
                return null;
            }

            TreeNode node = new TreeNode(0);
            node.left = buildCompleteBinaryTree(level - 1);
            node.data = ++count;
            node.right = buildCompleteBinaryTree(level - 1);

            return node;
        }
    }
}
