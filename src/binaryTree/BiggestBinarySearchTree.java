package binaryTree;

public class BiggestBinarySearchTree {
    public static class Info {
        public int max;
        public int min;
        public boolean isAllBST;
        public int maxSubBSTSize;

        public Info(int max, int min, boolean isAllBST, int maxSubBSTSize) {
            this.max = max;
            this.min = min;
            this.isAllBST = isAllBST;
            this.maxSubBSTSize = maxSubBSTSize;
        }

    }

    public static Info process(Node X) {
        if (X == null) {
            return null;
        }
        int max = X.val;
        int min = X.val;
        boolean isAllBST = true;

        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        // 1. left is binary search tree leftInfo == null ? true : leftInfo.isAllBST
        // 2. right is binary search tree rightInfo == null ? true : rightInfo.isAllBST
        // 3. val > left.max leftInfo == null ? true : leftInfo.max < x.val
        // val < right.min rightInfo == null ? true : rihgtInfo.min > x.val
        if ((leftInfo == null ? true : leftInfo.isAllBST) && (rightInfo == null ? true : rightInfo.isAllBST)
                && (leftInfo == null ? true : leftInfo.max < X.val)
                && (rightInfo == null ? true : rightInfo.min > X.val)) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
            isAllBST = true;

        }
        return new Info(max, min, isAllBST, maxSubBSTSize);
    }
}
