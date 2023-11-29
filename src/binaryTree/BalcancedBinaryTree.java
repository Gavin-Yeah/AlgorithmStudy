package binaryTree;

/**
 * BalcancedBinaryTree
 */
public class BalcancedBinaryTree {

    public static boolean isBalanced(Node head){
        return process2(head).isBalanced;
    }
    public static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static Info process2(Node X) {
        if(X == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height)>1){
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }
}