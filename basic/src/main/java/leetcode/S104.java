package leetcode;

/**
 * 计算一棵树的深度
 */
public class S104 {


    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? leftDepth +1 : rightDepth +1;
    }

    /**
     *  Definition for a binary tree node.
     */

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
