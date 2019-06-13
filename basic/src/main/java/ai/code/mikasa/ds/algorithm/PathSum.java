package ai.code.mikasa.ds.algorithm;

/**
 * leetcode 112
 *
 * 判断是否存在一条从根节点到叶子节点的路径，其节点的和相加等于sum
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        // 根节点同时也是叶子节点
        if(isLeaf(root)){
            if(root == null) return false;
            return root.val == sum;
        }

        // 递归判断左子树是否存在相应路径
        if(root.left != null && hasPathSum(root.left, sum - root.val)){
            return true;
        }

        // 递归判断右子树是否存在相应路径
        if(root.right != null && hasPathSum(root.right, sum - root.val)){
            return true;
        }

        return false;
    }

    private boolean isLeaf(TreeNode node){
        if(node == null){
            return true;
        }

        if(node.left == null && node.right == null){
            return true;
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
