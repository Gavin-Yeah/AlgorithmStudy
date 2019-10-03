package ChallengeSet.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;
        LinkedList<TreeNode> q = new LinkedList();
        
       
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.val != right.val )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
            
        }
        return true;
            
    }
	 public boolean isSymmetric(TreeNode root) {
	     if(root==null) return true;
	       return isSymmetric(root.left,root.right);
	    }
	     public boolean isSymmetric(TreeNode node1, TreeNode node2){
	    if(node1==null&&node2==null) return true;
	         if(node1==null||node2==null)return false;
	         if(node1.val!=node2.val) return false;
	        return isSymmetric(node1.left,node2.right)&&isSymmetric(node1.right,node2.left);
	       
	     }
}
