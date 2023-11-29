package binaryTree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Postorder {
	 public List<Integer> postorderTraversalIn(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    post(root,list);
    return list;
}
private void post(TreeNode node, List<Integer> list){
	//左右中
           if(node==null) return;
            post(node.left,list);
            post(node.right,list);
            list.add(node.val);
}
 public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
     while(!stack.isEmpty()||root!=null){
         while(root!=null){
             stack.push(root);
              stack.push(root);
             root=root.left;
         }
         root=stack.pop();
         if(stack.peekFirst()==root)root=root.right;
         else{
         list.add(root.val);
             root=null;
         }
         
     }
     return list;
 }
 public List<Integer> postorderTraversal2(TreeNode root){
     List<Integer> list = new LinkedList<>();
     Stack<TreeNode> stack = new Stack<>();
     Stack<TreeNode> stack2 = new Stack<>();
     stack.push(root);
     while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if(node == null) continue;
        stack2.push(node);
        if(node != null) {
            stack.push(node.left);
            stack.push(node.right);
        }
     }
     while(!stack2.isEmpty()){
         list.add(stack2.pop().val);
     }
     return list;
 }
}
