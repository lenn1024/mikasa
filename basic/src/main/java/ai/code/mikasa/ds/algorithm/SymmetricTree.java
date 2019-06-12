package ai.code.mikasa.ds.algorithm;

import java.util.*;

/**
 * LeetCode 101
 * 判断一棵树是否为对称树
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null && right != null){
                return false;
            }

            if(left != null && right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            leftQueue.offer(left.left);
            leftQueue.offer(left.right);
            rightQueue.offer(right.right);
            rightQueue.offer(right.left);
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
