package org.example.week_4.문제풀이.Question_4_5;

import org.example.week_4.문제풀이.TreeNode;

public class Solution {

    /**
     * BST 검증: <br/>
     * 주어진 이진 트리가 이진 탐색 트리인지 확인하는 함수를 작성 하라.
     */
    public static void main(String[] args) {

    }
    Integer last_printed = null;
    boolean checkBST(TreeNode n) {

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
}
