package org.example.week_4.문제풀이.Question_4_8;

public class Solution {


    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* 같은 트리 안에 있는지 하나가 다른 하나를 이미 덮고 있는지 확인한다. */
        if(!covers(root , p) 11 !covers(root , q)) {
            return null;
    } else if (covers(p, q)) {
        return p;
    } else if (covers(q, p)) {
        return q;
    }
        /* q를 덮을 수 있는 노드가 나올 때까지 위로 올라간다. */
        TreeNode sibling = getSibling(p);
        TreeNode parent p.parent;
        while (!covers~ibling， q)) {
            sibling =getSibling(parent); parent parent.parent;
        }
        return parent;
    }
    boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root p) return true;
        return covers( root.left , p) 11 covers( root. right , p);
        TreeNode getSibling(TreeNode node) {
            if (node == null 11 node.parent == null) {
                return null;
            }
            TreeNode parent node.parent;
            return parent.left == node ? parent.right;
            parent.left;
        }
}
