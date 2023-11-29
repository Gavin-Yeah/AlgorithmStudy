package binaryTree.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Inorder {
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        inorder(root,list);
	       
	        return list;
	    }
	 //左中右
	    private void inorder(TreeNode node,List<Integer> list){
	        if(node==null)return;
	        inorder(node.left,list);
	        list.add(node.val);
	        inorder(node.right,list);
	        
	    }
	   
	    public List<Integer> inorderTraversalRe(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        Deque<TreeNode> stack = new LinkedList<>();
	        while(root!=null||!stack.isEmpty()){
	            while(root!=null){
	                stack.push(root);
	                root=root.left;
	            }
	            root=stack.pop();
	            list.add(root.val);
	            root=root.right; 
	        }
	        return list;
	        
	}


}
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
}