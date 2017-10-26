package prova_2.capitulo_6.queue;

import prova_1.capitulo_3.codigos_livro.CircularlyLinkedList;

/*
 * Created by jjmacagnan on 28/05/2017.
 */
public class CircularLinkedQueue<E> implements CircularQueue<E> {
    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

    public CircularLinkedQueue() {
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmptty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public void rotate() {
        list.rotate();
    }

    public static <E> CircularQueue<E> buildQueue(E a[]) {
        CircularQueue<E> queue = new CircularLinkedQueue<>();
        for (int i = 0; i < a.length; i++)
            queue.enqueue(a[i]);
        return queue;
    }

    public static void main(String[] args) {
        String[ ] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[ ] a3 = {"Mike", "Roberto"};
//        System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
//        System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
//        System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
    }
}
