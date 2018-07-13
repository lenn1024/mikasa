package ai.code.mikasa.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 二叉树
 */
public class BinaryTree {

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildBinaryTree(new Integer[]{0, 1, 2, 3, 4, 5, 6});

        // 先序遍历
        List<TreeNode> list = binaryTree.preOrderTraversal();
        for(TreeNode node: list){
            System.out.print(node.element);
        }
        System.out.println();
        // 中序遍历
        list = binaryTree.middleOrderTraversal();
        for(TreeNode node: list){
            System.out.print(node.element);
        }
        System.out.println();
        // 后序遍历
        list = binaryTree.postOrderTraversal();
        for(TreeNode node: list){
            System.out.print(node.element);
        }

    }

    /**
     * 根节点
     */
    private TreeNode root;

    /**
     * 先序遍历(遍历结果放入list中)
     * @return
     */
    public List<TreeNode> preOrderTraversal(){
        List<TreeNode> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = this.root;

        while (node != null || !stack.isEmpty()){
            while (node != null){
                // visit this node
                list.add(node);
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }

        return list;
    }

    /**
     * 中序遍历（遍历结果放入list中）
     * @return
     */
    public List<TreeNode> middleOrderTraversal(){
        List<TreeNode> list = new ArrayList<>();

        TreeNode node = this.root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                // visit
                list.add(node);
                node = node.right;
            }
        }

        return list;
    }


    /**
     * 后序遍历
     * @return
     */
    public List<TreeNode> postOrderTraversal(){
        List<TreeNode> list = new ArrayList<>();

        TreeNode node = root;
        TreeNode lastVisit = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            // 取栈顶元素，但不从栈中删除
            node = stack.peek();
            if(node.right == null || node.right == lastVisit){
                // visit it
                list.add(node);
                stack.pop();
                lastVisit = node;
                node = null;
            }else {
                node = node.right;
            }
        }

        return list;
    }

    /**
     * 根据一个数组构建一棵二叉树
     * @param array
     * @param <T>
     */
    public <T> void  buildBinaryTree(T[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array can not be empty.");
        }

        // 转换为list
        List<TreeNode<T>> list = Arrays.stream(array)
                .map(item -> new TreeNode<T>(item, null, null))
                .collect(Collectors.toList());

        // 遍历数组，构造对应的树
        for(int i = 1; i < array.length; i++){
            if(array[i] == null){
                continue;
            }

            int parentIndex = (i - 1) / 2;
            TreeNode<T> parentNode = list.get(parentIndex);

            if(parentNode == null){
                throw new IllegalArgumentException("invalid array.");
            }

            if(i % 2 != 0){
                parentNode.left = list.get(i);
            }else {
                parentNode.right = list.get(i);
            }
        }

        this.root = list.get(0);
    }


    /**
     * 二叉树节点
     * @param <E>
     */
    class TreeNode<E>{
        public E element;
        public TreeNode<E> left;
        public TreeNode<E> right;

        /**
         *
         * @param element
         * @param left
         * @param right
         */
        public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
