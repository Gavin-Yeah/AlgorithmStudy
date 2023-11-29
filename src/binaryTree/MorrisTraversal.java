package binaryTree;

class Node {
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

public class MorrisTraversal {
    //O(n) time complexity  O(1) space complexity
    public static void morris(Node root) {
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                }
            }
            cur = cur.right;
        }
    }
    public static void morrisInorder(Node root) {
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                }
            }
            //print only when the left is null or the second time to cur, so overall it is when the node goes to right
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static boolean isBSTMorris(Node root) {
        if(root == null) return true;
        Node cur = root;
        Node mostRight = null;
        Integer prev = null;
        while (cur != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                }
            }
            if(prev != null && prev >= cur.val) return false;
            prev = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public static void morrisPreorder(Node root) {
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    //1st time to the parent node
                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                }
            } else {
                //no left node
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }
    public static void morrisPostorder(Node root) {
        Node cur = root;
        Node mostRight = null;
        while (cur != null) {
            mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight = null;
                    printReverseEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printReverseEdge(root);
    }
    private static void printReverseEdge(Node node) {
        Node tail = reverseEdge(node);
        Node cur = tail;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }
    private static Node reverseEdge(Node node) {
        Node before = null;
        while(node.right != null){
            Node tmp = node.right;
            node.right = before;
            before = node;
            node = tmp;
        }
        return node;
        

    }
}
