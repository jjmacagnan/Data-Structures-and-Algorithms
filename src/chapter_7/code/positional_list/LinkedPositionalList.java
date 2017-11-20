package chapter_7.code.positional_list;

import java.util.Iterator;

/*
 * Created by JJMacagnan on 21/05/2017.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

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

    public Position addLastAlt(E e) {
        Node<E> node = validate(last());

        return addAfter(node, e);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addBeforeAlt(Position<E> p, E e) throws IllegalStateException {
        Node node = validate(p);

        return addAfter(node.getPrev(), e);
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
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public int indexOf(Position<E> p) {
        Node node = validate(p);
        Node walk = (Node) first();

        for (int i = 0; i < size; i++) {
            if (node == walk) {
                return i;
            }
            walk = walk.getNext();

        }
        return 0;
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

    public Position positionAtIndex(int i) {

        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException(" Invalid index");

        Position t = first();
        for (int k = 0; k < i; k++)
            t = after(t);
        return t;
    }

    @Override
    public void moveToFront(Position p) {
        Node<E> node = validate(p);
        if (node != first()) {
            E e = remove(node);
            addFirst(e);
        }
    }

    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement()) {
                marker = pivot;
            } else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value) {
                    walk = list.before(walk);
                }
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
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

    public static void main(String[] args) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(0);
        list.addLast(45);

        list.toString();

        insertionSort(list);

        list.toString();

    }
}
