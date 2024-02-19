package org.example.week_4.문제풀이.Question_4_6;

import org.example.week_4.문제풀이.TreeNode;

public class Solution {

    /**
     * 후속자:<br/> 이진 탐색 트리 에서 주어진 노드의 ‘다음’ 노드(중위 후속자Cin-order successor))를 찾는<br/> 알고리즘을 작성하라. 각 노드에는
     * 부모 노드를 가리키 는 링크가 존재한다고 가정하자.
     */
    public static void main(String[] args) {

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