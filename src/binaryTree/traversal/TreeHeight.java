package binaryTree.traversal;

class Node {
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

public class TreeHeight {

    public static int minHeight(Node root) {
        if (root.left == null && root.right == null)
            return 1;
        int leftHeight = Integer.MAX_VALUE;
        if(root.left != null) {
            leftHeight = minHeight(root.left);
        }
        int rightHeight = Integer.MAX_VALUE;
        if(root.right != null) {
            rightHeight = minHeight(root.right);
        }
        return Math.min(leftHeight, rightHeight) + 1;

    }
    public static int minHeightMorris(Node head){
        Node cur = head;
        Node mostRight = null;
        int curLevel = 0;
        int minHeight = Integer.MAX_VALUE;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                int leftHeight = 1;
                while(mostRight.right != null && mostRight != cur) {
                    mostRight = mostRight.right;
                    leftHeight++;
                }
                if(mostRight.right == null) { //1st time
                    mostRight.right = cur;
                    cur = cur.left;
                    curLevel++;
                    continue;
                } else {//2nd time
                    if(mostRight.left == null) {
                        minHeight = Math.min(minHeight, curLevel);
                    }
                    curLevel -= leftHeight;
                    mostRight.right = null;
                }
            } else {
                curLevel++;
            }
            cur = cur.right;
        }
        int finalHeight = 1;
        cur = head;
        while(cur.right != null){
            finalHeight ++;
            cur = cur.right;
        }
        if(cur.left == null && cur.right == null) {
            minHeight = Math.min(minHeight, finalHeight);
        }
        return minHeight;
    }
}
