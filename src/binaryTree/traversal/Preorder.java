package binaryTree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Preorder {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversalIn(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		return list;
	}

	private void dfs(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		list.add(node.val);
		dfs(node.left, list);
		dfs(node.right, list);
	}

	private List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node == null)
				continue;
			list.add(node.val);
			stack.push(node.right);
			stack.push(node.left);
		}
		return list;
	}
}