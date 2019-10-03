package ChallengeSet.Leetcode;

public class LowestCommonAncestor {
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null||root==p||root==q) return root;
	        TreeNode leftChild=lowestCommonAncestor(root.left,p,q);
	        TreeNode rightChild=lowestCommonAncestor(root.right,p,q);
	        return leftChild==null?root.right:rightChild==null?root.left:root;
	    }
}
