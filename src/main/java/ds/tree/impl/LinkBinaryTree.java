package ds.tree.impl;

import ds.tree.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by lenn on 17/3/3.
 */
public class LinkBinaryTree<E extends Comparable> implements Tree<E> {

    private Node<E> root = null;
    private int count = 0;

    public LinkBinaryTree(){
    }

    public int size(){
        return count;
    }

    public void add(E element){
        count ++;
        Node<E> node = new Node<>(element);

        // root is empty.
        if(root == null){
            root = node;
            return;
        }


        Node<E> p = root;
        Node<E> q = p;

        while (true){
            if (q.element.compareTo(element) > 0){
                q = q.left;
                if(q == null){
                    p.left = node;
                    break;
                }
            }else {
                q = q.right;
                if(q == null){
                    p.right = node;
                    break;
                }
            }
            p = q;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterator<E> it = iterator();
        while (it.hasNext()){
            E element = it.next();
            action.accept(element);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class TreeIterator<E> implements Iterator{
        private Node<E> p = (Node<E>) root;
        private Queue<Node<E>> queue = new LinkedList<>();

        public TreeIterator() {
            if(p != null)
                queue.add(p);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            Node<E> node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            return node.element;
        }
    }


    protected class Node<E>{
        public E element;
        public Node<E> left;
        public Node<E> right;

        public Node(E element) {
            this.element = element;
        }
    }
}
