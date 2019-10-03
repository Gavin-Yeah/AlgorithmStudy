package ChallengeSet.Leetcode;

public class FloydCycleDetection {

	 //Definition for singly-linked list.
	  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * the distance from the head to the first node in the cycle is A and the distance slow pointert 
	 * travels until two pointers meet is B. Then, A+B+N=2(A+B)   N=A+B     2(A+B)=2N   2(A+B)+A=2N +A
	 * @param head
	 * @return
	 */
	
    public ListNode detectCycle(ListNode head) {
    	ListNode slow=head,fast=head;
    	do {
    		if(fast==null||fast.next==null)return null;
    		slow=slow.next;
    		fast=fast.next.next;
    	}while(slow!=fast);
    	ListNode s1=head;
    	while(s1!=slow) {
    		s1=s1.next;
    		slow=slow.next;
    	}
    	return s1;
    }
}
