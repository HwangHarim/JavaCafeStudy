package org.example.week_4.문제풀이.Question_4_7;

import java.util.ArrayList;
import org.example.week_3.Stack;

/**
 * 순서 정하기 : 프로젝트의 리스트와 프로젝트를 간의 종속 관계
 * <br/> 죽, 프로젝트쌍이 리스트로 주어지면 각 프로젝트 쌍에서 두 번째 프로젝트가 첫 번째 프로젝트에 종속되어 있따는 뜻
 * <br/> 가 주어졌을 때 프로젝트를 수행해 나가는 순서를 찾으라, 유효한 순서가 존재하지 않으면 에러 반환
 */
public class Solution {

    Stack findBuildOrder(String [] projects , String [] [] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }


    Stack orderProjects(ArrayList projects) {
        Stack stack =new Stack();
        for (Project project projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project , stack){
                    return null;
                }
            }
        }
    return stack;
    }


    boolean doDFS(Project project ,Stack stack){
        if (project.getState() == Project.State.PARTIAL) {
            return false; // 사이클
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
             ArrayList children = project.getChildren();
             for (Project child children) {
                 if (!doDFS(child, stack)) {
                     return false;
                 }
             }
             project.setState(Project.State.COMPLETE);
             stack.push(project);
        }
        return true; // 사이클
    }
}
