package binaryTree.traversal;

public class LowestCommonAncestor {

	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null||root==p||root==q) return root;
	        TreeNode leftChild=lowestCommonAncestor(root.left,p,q);
	        TreeNode rightChild=lowestCommonAncestor(root.right,p,q);
	        return leftChild==null?rightChild:rightChild==null?leftChild:root;
	    }
}
