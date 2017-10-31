package chapter_11.code;

import chapter_7.code.positional_list.Position;
import chapter_8.code.LinkedBinaryTree;
import chapter_9.code.PriorityQueue.Entry;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {

    protected static class BSTNode<E> extends Node<E> {
        int aux = 0;

        public BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            super(e, parent, leftChild, rightChild);
        }

        public int getAux() {
            return aux;
        }

        public void setAux(int aux) {
            this.aux = aux;
        }
    }

    public int getAux(Position<Entry<K, V>> p) {
        return ((BSTNode<Entry<K, V>>) p).getAux();
    }

    public void setAux(Position<Entry<K, V>> p, int value) {
        ((BSTNode<Entry<K, V>>) p).setAux(value);
    }

    protected Node<Entry<K, V>> createNode(Entry<K, V> e, Node<Entry<K, V>> parent,
                                           Node<Entry<K, V>> left, Node<Entry<K, V>> right) {
        return new BSTNode<>(e, parent, left, right);
    }

    private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
        child.setParent(parent);
        if (makeLeftChild)
            parent.setLeft(child);
        else
            parent.setRight(child);
    }

    public void rotate(Position<Entry<K, V>> p) {
        Node<Entry<K, V>> x = validate(p);
        Node<Entry<K, V>> y = x.getParent(); // we assume this exists
        Node<Entry<K, V>> z = y.getParent(); // grandparent (possibly null)
        if (z == null) {
            root = x; // x becomes root of the tree
            x.setParent(null);
        } else
            relink(z, x, y == z.getLeft()); // x becomes direct child of z
        // now rotate x and y, including transfer of middle subtree
        if (x == y.getLeft()) {
            relink(y, x.getRight(), true); // x’s right child becomes y’s left
            relink(x, y, false); // y becomes x’s right child
        } else {
            relink(y, x.getLeft(), false); // x’s left child becomes y’s right
            relink(x, y, true); // y becomes left child of x
        }
    }

    public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        Position<Entry<K, V>> y = parent(x);
        Position<Entry<K, V>> z = parent(y);
        if ((x == right(y)) == (y == right(z))) { // matching alignments
            rotate(y); // single rotation (of y)
            return y; // y is new subtree root
        } else { // opposite alignments
            rotate(x); // double rotation (of x)
            rotate(x);
            return x; // x is new subtree root
        }
    }

    protected void rebalanceInsert(Position<Entry<K,V>> p) { }
    protected void rebalanceDelete(Position<Entry<K,V>> p) { }
    protected void rebalanceAccess(Position<Entry<K,V>> p) { }


}
