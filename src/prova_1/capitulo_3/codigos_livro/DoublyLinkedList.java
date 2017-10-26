package prova_1.capitulo_3.codigos_livro;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DoublyLinkedList<E> {

    //---------------- nested Node class ----------------

    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;               // reference to the element stored at this node

        /**
         * A reference to the preceding node in the list
         */
        private Node<E> prev;            // reference to the previous node in the list

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;            // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param p reference to a node that should precede the new node
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // public accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that precedes this one (or null if no such node).
         *
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods

        /**
         * Sets the node's previous reference to point to Node n.
         *
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /**
     * Sentinel node at the beginning of the list
     */
    private Node<E> header;                    // header sentinel

    /**
     * Sentinel node at the end of the list
     */
    private Node<E> trailer;                   // trailer sentinel

    /**
     * Number of elements in the list (not including sentinels)
     */
    private int size = 0;                      // number of elements in the list

    /**
     * Constructs a new empty list.
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    // public accessor methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    public int sizeNotInstance() {
        int size = 0;

        while (header.getNext() != trailer) {
            header = header.getNext();
            size++;
        }

        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();   // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();    // last element is before trailer
    }

    // public update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());    // place just after the header
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty())
            return null;                  // nothing to remove
        return remove(header.getNext());             // first element is beyond header
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty())
            return null;                  // nothing to remove
        return remove(trailer.getPrev());            // last element is before trailer
    }

    // private update methods

    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor node just before the location where the new element is inserted
     * @param successor   node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     *
     * @param node the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public void inverte(DoublyLinkedList<E> l1, Node<E> inf, Node<E> sup) {
        if (l1.first() == null) {
            return;
        } else if (inf == sup) {
            System.out.println("Teste1");

        } else {

            Node<E> temp = header.getNext();
            inf = sup;
            sup = temp;

            Node<E> inferior = inf.getNext();
            Node<E> superior = sup.getPrev();

            System.out.println(l1.toString());


            inverte(l1, inferior, superior);
        }
    }

    public Node encontraNoMeioDaLista() {
        Node middle = null;

        while ((header != trailer) && (header.getNext() != trailer)) {
            header = header.getNext();
            trailer = trailer.getPrev();

            middle = header;
        }

        System.out.println("Elemento: " + middle.getElement());
        return middle;
    }

    /*R-3.16 Implement the equals() method for the DoublyLinkedList class.*/
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        DoublyLinkedList other = (DoublyLinkedList) o;
        if (size != other.size) {
            return false;
        }

        Node walkA = header.getNext();
        Node walkB = other.header.getNext();

        while (walkA.getNext() != null) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false;
            }
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;

    }

    public static DoublyLinkedList concatenarListas(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList listConcatenada = new DoublyLinkedList();

        Node walk = list1.header.getNext();
        /*insere elementos da lista 1 na lista concatenada*/
        while (walk != list1.trailer) {
            listConcatenada.addLast(walk.getElement());
            walk = walk.getNext();
        }

        walk = list2.header.getNext();
        /*insere elementos da lista 2 na lista concatenada*/
        while (walk != list2.trailer) {
            listConcatenada.addLast(walk.getElement());
            walk = walk.getNext();
        }

        return listConcatenada;
    }

    /*C-3.27 Describe in detail how to swap two nodes x and y (and not just their contents) in
a singly linked list L given references only to x and y. Repeat this exercise for the
case when L is a doubly linked list. Which algorithm takes more time?*/
    public void swap(Node x, Node y) {
        Node n = x.getPrev();
        Node v = y.getPrev();

        n.setNext(y);
        y.setPrev(n);
        y.setNext(x);
        x.setPrev(y);
        x.setNext(v);
        v.setPrev(x);

    }

    public DoublyLinkedList clone() throws CloneNotSupportedException {
        DoublyLinkedList<E> other = new DoublyLinkedList<>();

        if (size > 0) {
            other.header = new Node<>(null, null, null);
            other.trailer = new Node<>(null, other.header, null);
            other.header.setNext(other.trailer);
            Node<E> walk = header.getNext();
            Node<E> otherwalk = other.header;

            for (int i = 0; i < size; i++) {
                Node<E> newest = new Node<>(walk.getElement(), otherwalk, otherwalk.getNext());
                otherwalk.getNext().setPrev(newest);
                otherwalk.setNext(newest);
                otherwalk = otherwalk.getNext();
                walk = walk.getNext();
                other.size++;
            }
        }

        return other;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);

        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);

        if (list.equals(list2)) {
            System.out.println("Listas iguais");
        } else {
            System.out.println("Listas diferentes");
        }


        //list.encontraNoMeioDaLista();
        //System.out.println(list.toString());

        //list.inverte(list, list.header, list.trailer);

        //System.out.println("Lista original: " + list.toString());
        list.swap(list.header.next, list.header.next.next);
        System.out.println(list.toString());


    }
} //----------- end of DoublyLinkedList class -----------





