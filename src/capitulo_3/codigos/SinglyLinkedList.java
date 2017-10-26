package capitulo_3.codigos;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class SinglyLinkedList<E> {

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

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        else
            return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        else
            return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);

        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0) {
            tail = null;
        }

        return answer;
    }

    public void rotate() {
        if (head != null) {
            addLast(removeFirst());
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size != other.size) {
            return false;
        }

        Node walkA = head;
        Node walkB = other.head;

        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false;
            }

            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }

    public Node achaPenultimo() {
        Node node = head;
        while (node.getNext() != tail) {
            node = node.getNext();
        }

        return node;
    }

    public static SinglyLinkedList concatenarListas(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList listConcatenada = new SinglyLinkedList();

        Node walk = list1.head;
        /*insere elementos da lista 1 na lista concatenada*/
        while (walk != null) {
            listConcatenada.addLast(walk.getElement());
            walk = walk.getNext();
        }

        walk = list2.head;
        /*insere elementos da lista 2 na lista concatenada*/
        while (walk != null) {
            listConcatenada.addLast(walk.getElement());
            walk = walk.getNext();
        }

        return listConcatenada;
    }

    /*C-3.27 Describe in detail how to swap two nodes x and y (and not just their contents) in
a singly linked list L given references only to x and y. Repeat this exercise for the
case when L is a doubly linked list. Which algorithm takes more time?*/
    public void swap(Node x, Node y) {
        Node n = head;
        while (n.getNext() != x) {
            n = n.getNext();
        }

        Node v = y.getNext();
        n.setNext(y);
        y.setNext(x);
        x.setNext(v);
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = new SinglyLinkedList<>();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> othertail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                othertail.setNext(newest);
                othertail = newest;
                walk = walk.getNext();
                other.size++;
            }
        }
        return other;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    /*C-3.28 Describe in detail an algorithm for reversing a singly linked list L using only a
constant amount of additional space.*/
    public void inverterLista() {
        SinglyLinkedList<E> temp = new SinglyLinkedList();

        while (head != null){
          temp.addFirst(removeFirst());
        }

        while (temp.head != null) {
            addLast(temp.removeFirst());
        }
    }

    public void reverse() {
        if (!isEmpty()) {
            E node = first();
            removeFirst();
            reverse();
            addLast(node);
        }
    }

    public int sizeNotInstance() {
        int size  = 0;
        Node<E> walk = head;

        while (walk != null) {
            walk = walk.getNext();
            size++;
        }

        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list1;

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addFirst(4);
        list.addFirst(5);


        //Node node = list.achaPenultimo();

        //System.out.println(node.getElement());


//        list.removeFirst();
//        list.removeFirst();
//        list.removeFirst();

        //System.out.println(list.tail.element);

        System.out.println("Lista original: " + list.toString());

        //list.swap(list.head.next.next, list.head.next.next.next);

        //System.out.println("swap na lista: " + list.toString());

        try {
            list1 = list.clone();
            System.out.println("Lista clone: " + list1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
