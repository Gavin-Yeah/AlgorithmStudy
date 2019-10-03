package ChallengeSet.Leetcode;

import java.util.HashMap;
import java.util.List;

public class ValidateBinarySearchTree {
	TreeNode prev=null;
/**
 * LEETCODE 98 SERVICETITAN	
 * @param x
 */
	public boolean isValidBST(TreeNode root) {
         if(root==null)return true;
       //  ArrayList<Integer>list= new ArrayList<>();
       return isBSTHelper(root,null,null);
     //    isBST(list,root);
       //  for(int i=1;i<list.size();i++){
         //    if(list.get(i)<=list.get(i-1))return false;
        // }
      //   return true;
       
      
    }

    public boolean isBSTHelper(TreeNode node, Integer lower_limit,Integer upper_limit){
    if(lower_limit!=null&&node.val<=lower_limit)return false;
    if(upper_limit!=null&&node.val>=upper_limit)return false;
    boolean left=node.left!=null?  isBSTHelper(node.left,lower_limit,node.val):true;
    if(left){
        boolean right=node.right!=null? isBSTHelper(node.right,node.val,upper_limit):true;
        return right;
    }else return false;
}
    
   
    public void isBST(List<Integer> list,TreeNode root){
     if(root==null) return;
        isBST(list,root.left);
        list.add(root.val);
        isBST(list,root.right);
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        if(!helper(root.left))return false;
        if(prev!=null&&prev.val>=root.val){
            return false;
        }
        prev=root;
        return helper(root.right);
    }
   public static void main(String[] args) {
	   HashMap <Integer,Integer>map= new HashMap<>();
	   System.out.println(map.get(1));
} 
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}