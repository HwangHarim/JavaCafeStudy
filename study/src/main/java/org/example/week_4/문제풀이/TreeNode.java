package org.example.week_4.문제풀이;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int data;

    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode buildCompleteBinaryTree(int level) {
        Queue<TreeNode> nodes = new LinkedList<>();
        int numNodes = (int) Math.pow(2, level) - 1;
        for (int i = 1; i <= numNodes; i++) {
            nodes.offer(new TreeNode(i));
        }

        TreeNode root = nodes.poll();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes.isEmpty()) {
                node.left = nodes.poll();
                if (node.left != null) {
                    node.left.parent = node;
                    queue.add(node.left);
                }
            }
            if (!nodes.isEmpty()) {
                node.right = nodes.poll();
                if (node.right != null) {
                    node.right.parent = node;
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}