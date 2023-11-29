package ChallengeSet.paypal;

/**
 * LinkedListCycle
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode node1 = head, node2 = head;
        if (node1.next != null && node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if(node1 == node2) {
                return true;
            }
        }
        return false;
    }
}