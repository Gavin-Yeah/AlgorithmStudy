import java.util.Stack;
;

public class linkedList {
    static class Node {
        Node next;
        int val;
        Node ran;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2 = n3;
        System.out.println(n1.next.val);
    }

    // 奇数为中点 偶数为前一个
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next; // 2 3 4
        Node fast = head.next; // 23 45 56
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head; // 1 2 3
        Node fast = head.next.next; // 3 5 7
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head; // 1 2 3
        Node fast = head.next; // 2 4 6
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindromNode(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;// 1 2 3
        Node fast = head;// 1 3 5
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        Node cur = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;

    }

    // O(1) extra space
    public static boolean isPalindromNode2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node node1 = head;// 1 2 3
        Node node2 = head;// 1 3 5
        while (node2.next != null && node2.next.next != null) {
            node2 = node2.next.next;
            node1 = node1.next;
        }
        node2 = node1.next;
        node1.next = null;
        Node node3 = null;
        while (node2 != null) { // node3: next node2: cur node1: prev
            node3 = node2.next; // save next node
            node2.next = node1; // next of node convert
            node1 = node2;// prev move
            node2 = node3; // cur move
        }
        node3 = node1;
        node2 = head;
        boolean res = true;
        while (node1 != null && node2 != null) {
            if (node2.val != node1.val) {
                res = false;
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        node1 = node3.next;
        node3.next = null;
        while (node1 != null) {
            node2 = node1.next;
            node1.next = node3;
            node3 = node1;
            node1 = node2;
        }

        return res;

    }

    // 小于pivot放左边 pivot的nodes放中间 大于的放右边
    public static Node listPartition(Node head, int pivot) {
        Node node = head;
        Node sl = null, sr = null;
        Node el = null, er = null;
        Node bl = null, br = null;
        while (node != null) {
            if (node.val < pivot) {
                if (sl == null) {
                    sl = node;
                    sr = node;
                } else {
                    sr.next = node;
                    sr = sr.next;
                }
            } else if (node.val == pivot) {
                if (el == null) {
                    el = node;
                    er = node;
                } else {
                    er.next = node;
                    er = er.next;
                }
            } else {
                if (bl == null) {
                    bl = node;
                    br = node;
                } else {
                    br.next = node;
                    br = br.next;
                }
            }
            node = node.next;
        }
        if (sl != null) {
            sr.next = el;
            er = er == null ? sr : er;
        }
        if (el != null) {
            er.next = bl;
        }
        return sl != null ? sl : (el != null ? el : bl);

    }

    public static Node copyListWithRand(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = node;
        Node curCopy = null;
        Node head = cur.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.ran = cur.ran != null ? cur.ran.next : null;
            cur = next;
        }
        cur = node;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return head;
    }
    //两链表若有相交 返回相交节点 无返回null
    public static Node noLoop(Node head1, Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        int diff = 0;
        while(cur1.next != null) {
            cur1 = cur1.next;
            diff++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            diff--;
        }
        if(cur1 != cur2) {
            return null;
        }
        cur1 = diff > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        diff = Math.abs(diff);
        while(diff != 0){
            cur1 = cur1.next;
            diff--;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //两环链表 返回第一个香蕉节点 不相交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        int n = 0;
        //在进入环前相交
        if(loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            while(cur1 != head1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != head2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n > 0) {
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
