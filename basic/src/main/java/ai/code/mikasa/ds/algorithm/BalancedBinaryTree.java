package ai.code.mikasa.ds.algorithm;

/**
 * 判断一棵树是否为平衡树
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(Math.abs(left - right) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取到树高
     * @param root
     * @return
     */
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return left > right ? left + 1 : right + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
