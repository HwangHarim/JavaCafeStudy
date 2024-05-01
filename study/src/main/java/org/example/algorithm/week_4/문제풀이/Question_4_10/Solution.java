package org.example.algorithm.week_4.문제풀이.Question_4_10;//package org.example.week_4.문제풀이.Question_4_10;
//
//public class Solution {
//    boolean containsTree(TreeNode t1 , TreeNode t2) {
//        StringBuilder string1 =new StringBuilder();
//        StringBuilder string2 =new StringBuilder();
//        getOrderString(t1, string1);
//        getOrderString(t2, string2);
//        return string1.indexOf(string2.toString()) != -1;
//    }
//    void getOrderString(TreeNode node, StringBuilder sb) {
//        if (node == null) {
//            sb.append("X"); // 널 (null) 표현 문자 추가
//             Return;
//        }
//        sb.append(node.data + " "); // 루드 추가
//        getOrderString(node. left , sb); // 왼쪽 추가
//         getOrderString(node.right , sb); // 오른쪽 추가
//    }
//}
