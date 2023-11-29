package binaryTree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		bfs(root, 1, list);
		return list;

	}

	public void bfs(TreeNode node, int level, List<List<Integer>> list) {
		if (node == null)
			return;
		if (list.size() < level) {
			List<Integer> cur = new ArrayList<>();
			cur.add(node.val);
			list.add(cur);
		} else {
			list.get(level - 1).add(node.val);
		}

		bfs(node.left, level + 1, list);
		bfs(node.right, level + 1, list);

	}

	public void shortestPathBinaryMatrix(int[][] grid) {
		int length = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			length++;// depth
			int size = q.size(); // the number of nodes in each layer
			for (int m = 0; m < size; m++) {
				int[] curr = q.poll();
				int x = curr[0];
				int y = curr[1];
				for (int j = -1; j <= 1; j++) {
					if (grid[x + 1][y + 1] == 0) {
						q.add(new int[] { x + 1, y + 1 });

					}
				}
			}
		}
	}

	public static void breadth(TreeNode head) {
		if (head != null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(head);
		HashMap<TreeNode, Integer> levelMap = new HashMap<>();
		levelMap.put(head, 1);
		int curLevel = 1;
		int curLevelNodes = 1;
		int max = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int curNodeLevel = levelMap.get(cur);
			if(curLevel == curNodeLevel) {
				curLevelNodes++;
			}else{
				max = Math.max(max, curLevelNodes);
				curLevelNodes = 1;
			}
			if(cur.left != null){
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}

	}

}
