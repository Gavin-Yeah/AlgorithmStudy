package binaryTree.traversal;

import java.util.LinkedList;
import java.util.List;

import com.jiada.binarytree.traversal.Preorder.TreeNode;

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
}
