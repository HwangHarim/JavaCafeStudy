package org.example.week_4.문제풀이.Question_4_6;

import org.example.week_4.문제풀이.TreeNode;

public class Solution {

    /**
     * 후속자:
     * <br/> 이진 탐색 트리 에서 주어진 노드의 ‘다음’ 노드(중위 후속자Cin-order successor))를 찾는
     * <br/> 알고리즘을 작성하라. 각 노드에는
     * 부모 노드를 가리키 는 링크가 존재한다고 가정하자.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);

        root.left = node10;
        root.right = node30;
        node10.parent = root;
        node30.parent = root;

        node10.left = node5;
        node10.right = node15;
        node5.parent = node10;
        node15.parent = node10;

        node5.left = node3;
        node5.right = node7;
        node3.parent = node5;
        node7.parent = node5;


        TreeNode successor = new Solution().inorderSucc(node15);
        System.out.println(successor != null ? successor.data : "No Successor!");
    }

    TreeNode inorderSucc(TreeNode n) {
        if (n == null) {
            return null;
        }

        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // 오른쪽이 아난 왼쪽에 있을 때까지 위로 올라간다.
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}