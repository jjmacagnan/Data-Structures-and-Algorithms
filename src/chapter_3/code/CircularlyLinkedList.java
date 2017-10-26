package chapter_3.code;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class CircularlyLinkedList<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmptty() {
        return getSize() == 0;
    }

    public E first() {
        if (isEmptty())
            return null;

        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmptty())
            return null;

        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**/
    public void addFirstNotLocalVariable(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmptty()) {
            return null;
        }

        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }

        size--;

        return head.getElement();
    }

    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            if (walk != null)
                sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    /*R-3.15 Implement the equals() method for the CircularlyLinkedList class, assuming that
two lists are equal if they have the same sequence of elements, with corresponding elements currently at the front of the list.*/
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        CircularlyLinkedList other = (CircularlyLinkedList) o;
        if (size != other.size) {
            return false;
        }

        Node walkA = tail;
        Node walkB = other.tail;

        for (int i = 0; i < size; i++) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false;
            }

            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }

    public boolean isEqualContents(CircularlyLinkedList listL, CircularlyLinkedList listM) {
        Node nodeL = listL.tail;
        Node nodeM = listM.tail;
        boolean x = false;

        while (nodeM.getNext() != tail) {
            if (nodeL.getElement().equals(nodeM.getElement())) {
                x = true;
                break;
            }

            nodeM = nodeM.getNext();

            for (int i = 0; i < listM.size; i++) {
                nodeM = nodeM.getNext();
                nodeL = nodeL.getNext();

                if (!nodeL.getElement().equals(nodeM.getElement())) {
                    return false;
                }
            }
        }

        return true;
    }

    public CircularlyLinkedList clone() throws CloneNotSupportedException {
        CircularlyLinkedList other = new CircularlyLinkedList();

        if (size > 0) {
            other.tail = new Node(tail.getElement(), null);
            Node<E> walk = tail.getNext();
            Node<E> temp = other.tail;

            for (int i = 0; i < size; i++) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                temp.setNext(newest);
                temp = newest;
                walk = walk.getNext();
                other.size++;
            }
        }
        return other;
    }


    public static void split(CircularlyLinkedList L) {
        CircularlyLinkedList M = new CircularlyLinkedList();
        CircularlyLinkedList N = new CircularlyLinkedList();

        int size = L.size;

        for (int i = 0; i < size / 2; i++) {
            M.addLast(L.removeFirst());
        }

        for (int i = 0; i < size / 2; i++) {
            N.addLast(L.removeFirst());
        }

        System.out.println("Lista M: " + M.toString());
        System.out.println("Lista N: " + N.toString());
    }

    public int sizeNotInstance() {
        int size = 0;

        if (tail != null) {
            size++;
            Node<E> walk = tail.getNext();

            while (walk != tail) {
                walk = walk.getNext();
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        CircularlyLinkedList list2 = new CircularlyLinkedList();

        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");

        list2.addFirst("a");
        list2.addFirst("b");
        list2.addFirst("c");

        if (list.equals(list2)) {
            System.out.println("Listas iguais");
        } else {
            System.out.println("Listas diferentes");
        }

//        System.out.println(list.toString());
//        System.out.println("rotate");
//        list.rotate();
//        System.out.println(list.toString());
//        System.out.println("rotate");
//        list.rotate();
//        System.out.println(list.toString());
    }
}
