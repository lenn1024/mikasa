package ai.code.mikasa.leetcode;

import java.util.Stack;

/**
 * 构造一棵只有右子树的最大深度树
 */
public class S897 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        S897 instance = new S897();
        TreeNode result = instance.increasingBST(root);

        System.out.println("hahahaha");
    }

    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode resultNode = null, q = null;
        // 中序遍历
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode node = stack.pop();
                // visit node, 构造一个新节点
                TreeNode newNode = new TreeNode(node.val);
                if(resultNode == null){
                    resultNode = newNode;
                    q = newNode;
                }else {
                    q.right = newNode;
                    q = q.right;
                }

                p = node.right;
            }
        }

        return resultNode;
    }

    /**
     *  Definition for a binary tree node.
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
