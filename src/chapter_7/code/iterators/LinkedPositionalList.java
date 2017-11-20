package chapter_7.code.iterators;

import chapter_7.code.positional_list.Position;
import chapter_7.code.positional_list.PositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Created by JJMacagnan on 21/05/2017.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();
        private Position<E> recent = null;

        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null)
                throw new NoSuchElementException("nothing left");

            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (recent == null)
                throw new IllegalStateException("nothing to remove");

            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    @Override
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterator<E> alternateIterator() {


        return null;
    }

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalStateException {
        if (!(p instanceof Node))
            throw new IllegalStateException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalStateException("p is no longer in the list");
        return node;
    }


    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    @Override
    public int indexOf(Position<E> p) {
        Node node = validate(p);
        Node walk = (Node) first();

        for (int i = 0; i < size; i++) {
            if (node == walk) {
                return i;
            } else {
                walk = walk.getNext();
            }
        }
        return -1;
    }

    @Override
    public Position<E> findPosition(E e) {
        Node walk = validate(first());

        for (int i = 0; i < size; i++) {
            if (walk.getElement() == e) {
                return walk;
            }
            walk = walk.getNext();
        }

        return null;
    }

    public Position positionAtIndexInEnd(int i) throws IndexOutOfBoundsException {

        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException(" Invalid index");

        Position t;

        if (i > size / 2) {
            t = last();
            for (int k = size - 1; k > i; k--) {
                t = before(t);
            }
        } else {
          t = positionAtIndex(i);
        }
        return t;
    }

    public Position positionAtIndex(int i) throws IndexOutOfBoundsException {

        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException(" Invalid index");

        Position t = first();
        for (int k = 0; k < i; k++)
            t = after(t);

        return t;
    }

    public Position<E> positionAtIndex2(int i) {
        int aux = 0;
        Node p = (Node) this.first();

        while (aux < i) {
            p = p.getNext();
            aux++;
        }

        return p;
    }

    @Override
    public void moveToFront(Position p) {
        Node<E> node = validate(p);
        if (node != first()) {
            E e = remove(node);
            addFirst(e);
        }
    }

    public void moveToFrontAlt(Position p) {
        Node<E> node = validate(p);
        if (node != first()) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            header.getNext().setPrev(node);
            node.setNext(header.getNext());
            header.setNext(node);
            node.setPrev(header);
        }
    }

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

    public LinkedPositionalList<E> clone() throws CloneNotSupportedException {
        LinkedPositionalList<E> other = new LinkedPositionalList<>();

        if (size > 0) {
            other.header = new Node<>(null, null, null);
            other.trailer = new Node<>(null, other.header, null);
            other.header.setNext(other.trailer);
            Node<E> walk = header.getNext();
            Node<E> otherwalk = other.header;

            while (walk.getNext() != null) {
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

    public LinkedPositionalList<E> clone2() throws CloneNotSupportedException {
        LinkedPositionalList otherList = new LinkedPositionalList();
        Node node = (Node) first();

        while (node.getNext() != null) {
            otherList.addLast(node.getElement());
            node = node.getNext();
        }

        return otherList;
    }

    public void reverse() {
        Node head = header;
        Node tail = trailer.getPrev();

        for (int i = 0; i < size; i++) {
            Position<E> p = tail;
            addAfter(head, p.getElement());
            head = head.getNext();
            tail = tail.getPrev();
            remove(last());
        }
    }


    public void reverseRecursivo() {
        if (!isEmpty()) {
            E e = first().getElement();
            remove(first());
            reverse();
            addLast(e);
        }
    }

    public LinkedPositionalList cardShuffle(LinkedPositionalList<E> L) {
        LinkedPositionalList<E> M = new LinkedPositionalList<>();
        LinkedPositionalList<E> N = new LinkedPositionalList<>();

        int size = L.size;

        for (int i = 0; i < size / 2; i++) {
            M.addLast(L.remove(L.first()));
        }

        for (int i = 0; i < size / 2; i++) {
            N.addLast(L.remove(L.first()));
        }

        System.out.println("Lista M: " + M.toString());
        System.out.println("Lista N: " + N.toString());

        while (M.size > 0 && N.size > 0) {
            L.addLast(M.remove(M.first()));
            L.addLast(N.remove(N.first()));
        }

        return L;
    }

    public void swap(Position<E> p, Position<E> q) {
        set(p, set(q, p.getElement()));
    }

    public static void main(String[] args) {
        LinkedPositionalList list = new LinkedPositionalList();
        Iterator iterator = list.iterator();
        Iterable iterable = list.positions();

        System.out.println(list.addFirst(1).getElement());
        System.out.println(list.addFirst(2).getElement());
        System.out.println(list.addLast(0).getElement());


    }
}
