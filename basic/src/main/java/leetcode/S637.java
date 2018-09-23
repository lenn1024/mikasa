package leetcode;

import java.util.*;

public class S637 {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Double> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode p = root;
        queue.push(root);
        while (!queue.isEmpty()){
            list.add(averageOfLevel(queue));
        }

        return list;
    }

    /**
     * 求其中一层的平均值
     * @param queue
     * @return
     */
    private Double averageOfLevel(Deque<TreeNode> queue){
        Double sum = 0d;
        int count = 0;

        Deque<TreeNode> newQueue = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            sum += node.val;

            // 子节点进队列
            if(node.left != null){
                newQueue.push(node.left);
            }
            if(node.right != null){
                newQueue.push(node.right);
            }
            count++;
        }
        // 重新赋值
        queue.addAll(newQueue);

        return sum / count;
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
