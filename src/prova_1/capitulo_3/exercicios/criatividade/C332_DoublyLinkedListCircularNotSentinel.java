package prova_1.capitulo_3.exercicios.criatividade;

/*Implement a circular version of a doubly linked list, without any sentinels, that
supports all the public behaviors of the original as well as two new update methods, rotate() and rotateBackward().*/
public class C332_DoublyLinkedListCircularNotSentinel<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;


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

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private int size = 0;

    public C332_DoublyLinkedListCircularNotSentinel() {

    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

//    public E first() {
//        if (isEmpty())
//            return null;
//        else
//            return
//    }


}
