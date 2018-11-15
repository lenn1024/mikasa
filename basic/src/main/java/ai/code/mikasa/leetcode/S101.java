package ai.code.mikasa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S101 {

    public static void main(String[] args){

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(p);
        while (p != null && stack.size() > 0){
            if(p == null){
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }else {
                stack.push(p.left);
                p = p.left;
            }
        }

        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
