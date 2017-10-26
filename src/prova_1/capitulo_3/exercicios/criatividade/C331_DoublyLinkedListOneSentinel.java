package prova_1.capitulo_3.exercicios.criatividade;

/*Our implementation of a doubly linked list relies on two sentinel nodes, header
and trailer, but a single sentinel node that guards both ends of the list should
suffice. Reimplement the DoublyLinkedList class using only one sentinel node.*/
public class C331_DoublyLinkedListOneSentinel<E> {

    public static class Node<E> {
        private E element;
        private Node next;
        private Node prev;

        public Node (E e, Node<E> p, Node<E> n) {
            this.element = e;
            this.next = n;
            this.prev = p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node p) {
            this.prev = p;
        }

        public void setNext(Node n) {
            this.next = n;
        }
    }

    private Node<E> sentinel;
    private int size = 0;

    public C331_DoublyLinkedListOneSentinel() {
        sentinel = new Node<>(null, null, null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        else {
            return sentinel.getNext().getElement();
        }
    }

    public E last() {
        if (isEmpty())
            return null;
        else {
            return sentinel.getPrev().getElement();
        }
    }

    public void addFirst(E e) {
        addBetween(e, sentinel, sentinel.getNext());
    }

    public void addLast(E e) {
        addBetween(e, sentinel.getPrev(), sentinel);
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        else {
            return remove(sentinel.getNext());
        }
    }

    private E remove(Node<E> node) {
       Node<E> predecessor = node.getPrev();
       Node<E> sucessor  = node.getNext();
       predecessor.setNext(sucessor);
       sucessor.setPrev(predecessor);
       size--;
       return node.getElement();

    }

    private void addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newest = new Node<>(e, prev, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = sentinel.getNext();
        while (walk != sentinel) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != sentinel)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public C331_DoublyLinkedListOneSentinel clone() throws CloneNotSupportedException {
        C331_DoublyLinkedListOneSentinel<E> other = new C331_DoublyLinkedListOneSentinel<>();

        if (!isEmpty()) {
            other.sentinel = new Node<>(null, null, null);
            other.sentinel.setPrev(other.sentinel);
            other.sentinel.setNext(other.sentinel);
            Node<E> walk = sentinel.getNext();
            Node<E> otherwalk = other.sentinel;

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
        C331_DoublyLinkedListOneSentinel list = new C331_DoublyLinkedListOneSentinel();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.toString());
        System.out.println("Size: " + list.getSize());
        System.out.println("Last: " + list.last());
        System.out.println("First " + list.first());
        System.out.println("Lista está vazia: " + list.isEmpty());
    }

}
