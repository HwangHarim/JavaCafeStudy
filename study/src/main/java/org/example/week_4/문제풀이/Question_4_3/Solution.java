package org.example.week_4.문제풀이.Question_4_3;

import java.util.ArrayList;
import java.util.LinkedList;
import org.example.week_4.문제풀이.TreeNode;


public class Solution {

    /**
     * 깊이의 리스트. <br/> 이진 트리가 주어졌을 때 같은 깊이에 있는 노드를 연결리스 트로 연결해 주는 알고리즘을 설계하라. <br/> 즉， 트리의 깊이가 D라면
     * D개의 연 결리스트를 만들어야 한다.
     */
    public static void main(String[] args) {

    }

    static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return; // 초기 사례
        }
        LinkedList list = null;
        if (lists.size() == level) { // 리스트에 해당 레벨이 없다.
            list = new LinkedList();
            /* 갚이가 증가하는 순서로 순회했다는 사실에 유의하자. 따라서 깅이 #i를 처음
             * 마주졌다연， 0부터 i-1번째까지는 이전에 이미 lists어| 추가되어야 한다.
             * 따라서 새로운 갚이 #i를 lists21 끝에 추가해도 안전하다. */
            lists.add(list);

        } else {
            list = lists.get(level);
            list.add(root);
            createLevelLinkedList(root.left, lists, level + 1);
            createLevelLinkedList(root.right, lists, level + 1);

        }
    }
}