package org.example.codingTest.week_3;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        ListNode current = head;

        while (current != null) {
            odd.next = current;
            odd = odd.next;
            current = current.next;

            if (current != null) {
                even.next = current;
                even = even.next;
                current = current.next;
            }
        }

        odd.next = evenDummy.next;
        even.next = null;

        return oddDummy.next;
    }
}
