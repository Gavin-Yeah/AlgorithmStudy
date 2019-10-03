package ChallengeSet.Leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ListNode mergeKLists(List<ListNode> list) {
		 PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
		 for (ListNode node : list) {
	            if (node != null) {
	                queue.add(node);
	            }
	        }
		 ListNode dummy = new ListNode(-1), cur = dummy;
		   while(!queue.isEmpty()) {
	            cur.next = queue.poll();
	            if (cur.next.next != null) {
	                queue.add(cur.next.next);
	            }
	            cur = cur.next;
	        }
	        return dummy.next;
	}
}
 class ListNode {
	      int val;
	     ListNode next;
	      ListNode(int x) { val = x; }
	  }