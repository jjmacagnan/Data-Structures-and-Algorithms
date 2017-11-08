package chapter_9.exercises;

import chapter_7.code.positional_list.Position;
import chapter_8.code.AbstractBinaryTree;

/*C-9.31 Assume that we are using a linked representation of a complete binary tree T , and
an extra reference to the last node of that tree. Show how to update the reference
to the last node after operations insert or remove in O(logn) time, where n is the
current number of nodes of T . Be sure to handle all possible cases, as illustrated
in Figure 9.12.*/

public class C931<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            this.element = e;
        }

        public void setParent(Node<E> parentNode) {
            this.parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    }

    protected Node<E> createNodde(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;
    private Node<E> lastNode;

    public C931() {
    }

    protected Node<E> validate(Position<E> p) throws IllegalStateException {
        if (!(p instanceof Node))
            throw new IllegalStateException("not valide position type");
        Node<E> node = (Node<E>) p;
        if ((node.getParent() == node))
            throw new IllegalStateException("p is no longer in the tree");
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty())
            throw new IllegalStateException("tree is not empty");
        root = createNodde(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalStateException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalStateException("p already has a left child");
        Node<E> child = createNodde(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalStateException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalStateException("p already has a right child");
        Node<E> child = createNodde(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void updateLastNode() {

    }


    public static void main(String[] args) {

        C931 tree = new C931();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.right(tree.root()), "E");
        tree.addRight(tree.left(tree.root()), "F");


    }


}
