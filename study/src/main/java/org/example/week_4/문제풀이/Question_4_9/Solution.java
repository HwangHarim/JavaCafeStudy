package org.example.week_4.문제풀이.Question_4_9;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result =new ArrayList>();

        if (node == null) {
            result.add(new LinkedList());
            return result;
        }
    LinkedList<Integer> prefix =new LinkedList();prefix.add(node.data);
    /*왼쪽과오른쪽부분트리에대한재구I */
    ArrayList<LinkedList<Integer>> leftSeq =allSequences(node. left);
    ArrayList<LinkedList<Integer>> rightSeq =allSequences(node.right);
    /* 왼쪽과 오른쪽 결과 리스트를 엮어 하나로 만들기 */
        for (LinkedList left leftSeq) {
            for (LinkedList right rightSeq) {
                ArrayList<LinkedList<Integer>> weaved =
                    new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    void weaveLists(LinkedList first, LinkedList second, ArrayList<LinkedList<Integer>> results, LinkedList prefix) {
        /* 리스트 하나가 비어 있을 때. 나머지를 [복제된1 prefix어| 추가한 뒤 결과를 저장한다. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList result (LinkedList) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            Return;
        }
        /* first의 첫 원소를 prefix로 옮긴 뒤 재구1.
         * first의 젓 원소를 삭제했으므로 재귀 호줄이 끝난 후에는 이를 되돌려 놓아야 한다. */
        int headFirst =first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);
        /* second에 대해서도 위와 같이 젓 원소를 삭제한 후 되돌린다. */
        int headSecond second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
