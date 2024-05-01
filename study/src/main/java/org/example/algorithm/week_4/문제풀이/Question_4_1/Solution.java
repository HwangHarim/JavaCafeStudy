package org.example.algorithm.week_4.문제풀이.Question_4_1;//package org.example.week_4.문제풀이.Question_4_1;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Solution {
//
//    /**
//     * 노드 사이의 경로 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는지 확인하는 알고리즘을 작성하라.
//     */
//
//    static boolean[][] visited;
//    static ArrayList[] board;
//    static int target;
//    static boolean answer = false;
//    public static boolean solution(int[][] map, int index, int target){
//        visited = new boolean[51][51];
//        board = new ArrayList[8];
//        target =target;
//
//        for(int i =0; i<8;i++){
//            board[i] = new ArrayList<Integer>();
//        }
//
//
//        for(int y = 0; y<map.length; y++){
//            int[] a = map[y];
//            for(int x = 0; x<a.length; x++){
//
//                board[y].add(x);
//                board[x].add(y);
//
//                visited[y][x] = true;
//                visited[x][y] = true;
//            }
//        }
//
//        return visited[index][target];
//    }
//
//    public void dfs(int index){
//        if(index == target){
//            answer =true;
//            return;
//        }
//        visited[index] = true;
//
//
//    }
//
//
//    public static void main(String[] args) {
//        // x 와 y는 연결 되어 있나요?
//        // 원소로 들어간 숫자를 1~7까지라고 제한
//        int[][] map = {{1,2},{1,4},{1,5},{7,3},{3,6}};
//    }
//}
