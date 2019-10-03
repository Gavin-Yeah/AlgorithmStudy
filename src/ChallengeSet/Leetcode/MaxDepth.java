package ChallengeSet.Leetcode;

public class MaxDepth {
	int answer=0;
    public int maxDepth(TreeNode root) {
//         if(root==null)return 0;
//         int leftDepth=maxDepth(root.left);
//         int rightDepth=maxDepth(root.right);
       
//         return Math.max(leftDepth,rightDepth)+1;
   
         helper(root,1);
        return answer;
       
    }
    private void helper(TreeNode node, int depth){
        if(node==null) return ;
        if (node.left == null && node.right == null) {
        answer = Math.max(answer, depth);
    }
    helper(node.left, depth + 1);
   helper(node.right, depth + 1);
    }
}
