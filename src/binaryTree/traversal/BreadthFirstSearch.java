package binaryTree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.jiada.binarytree.traversal.Preorder.TreeNode;

public class BreadthFirstSearch {
	  public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> list= new ArrayList<>();
	        if(root==null) return list;
	        bfs(root,1,list);
	        return list;
	    }
	    public void bfs(TreeNode node, int level, List<List<Integer>> list){
	        if(node==null) return;
	        if(list.size()<level){
	            List<Integer> cur= new ArrayList<>();
	            cur.add(node.val);
	            list.add(cur);
	        }else{
	            list.get(level-1).add(node.val);
	        }
	        
	        bfs(node.left,level+1,list);
	        bfs(node.right,level+1,list);
	        
	    }
}
