package org.example.week_4.문제풀이.Question_4_2;


public class Solution {

    /**
     * 최소 트리 :<br/>
     * 오름차순으로 정렬된 배여이 있다. 이 배열 안에 들어 있는 원소는 정수이며 중복된 값이 없다고 했을 때 <br/>
     * 높이가 최소가 되는 이진 탐색 트리를 만드는 알고리즘을 작성해라
     */
    public static void main(String[] args) {
        int[] treeArr = {1,2,3,4,5,6,7,8,9};
        var answer = createMinimalBST(treeArr);
        System.out.println(answer);

    }

    static TreeNode createMinimalBST(int[] arr){
        return createMinimalBST(arr, 0, arr.length-1);
    }

    static TreeNode createMinimalBST(int[] arr, int start, int end){
        if(end<start){
            return null;
        }

        int mid = (start +end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid-1);
        n.right = createMinimalBST(arr, mid+1, end);

        return n;
    }

    static class TreeNode {
        public int data;

        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
