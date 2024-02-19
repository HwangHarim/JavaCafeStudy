package org.example.week_4.문제풀이.Question_4_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    /**
     * 깊이의 리스트. <br/> 이진 트리가 주어졌을 때 같은 깊이에 있는 노드를 연결리스 트로 연결해 주는 알고리즘을 설계하라. <br/> 즉， 트리의 깊이가 D라면
     * D개의 연 결리스트를 만들어야 한다.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root.buildCompleteBinaryTree(4));

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Level " + (i+1) + ":");
            for (TreeNode node : list.get(i)) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }

    }


    static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        /*루트 ’방문’ */
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // 이전 갚이 주가
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();// 다음 current =new LinkedList();
            for (TreeNode parent : parents) {
                /* 자식 노드들 방문 */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    static class TreeNode {
        public int data;

       TreeNode left;
       TreeNode right;
       TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
        TreeNode buildCompleteBinaryTree(int level) {
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
}