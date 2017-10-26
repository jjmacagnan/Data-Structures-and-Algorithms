package capitulo_3.exercicios.C326L;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class DoubleList<E> {

    private int size;
    private Node<E> header;
    private Node<E> trailer;

    public DoubleList() {
        size = 0;
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, null, this.header);
        this.header.setNext(this.trailer);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node<E> getHeader() {
        return header;
    }

    public Node<E> getTrailer() {
        return trailer;
    }

    //insere no final
    public void insert(E element) {
        Node<E> novo = new Node<>(element, trailer, trailer.prev);
        trailer.prev.next = novo;
        trailer.prev = novo;
        size++;
    }

    public void imprime() {
        Node<E> walk = this.header;
        while(walk != this.header) {
            System.out.println(walk.getElement());
            walk = walk.getNext();
        }
    }

    public void imprimeReverso() {
        Node<E> walk = this.trailer.prev;
        while(walk != this.header) {
            System.out.println(walk.getElement());
            walk = walk.getPrev();
        }
    }

    //Recebe duas listas, cria uma terceira e adiciona no final de forma sequencial
    public static DoubleList juntaListas(DoubleList list1, DoubleList list2) {
        //Cria a terceira lista que sera retonada
        DoubleList list3 = new DoubleList();

        //Passa os elementos da lista 1 para a lista 3
        Node walk = list1.header.getNext();
        while(walk != list1.trailer) {
            list3.insert(walk.getElement());
            walk = walk.getNext();
        }

        //Passa os elementos da lista 2 para a lista 3
        walk = list2.header.getNext();
        while(walk != list2.trailer) {
            list3.insert(walk.getElement());
            walk = walk.getNext();
        }

        return list3;
    }

    private static class Node<E> {
        E element;
        private Node<E> next;
        private Node<E> prev;

        public Node (E element, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        DoubleList list1 = new DoubleList();
        DoubleList list2 = new DoubleList();
        DoubleList list3;

        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);

        list2.insert(5);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);

        list3 = DoubleList.juntaListas(list1, list2);
        list3.imprime();

    }
}
