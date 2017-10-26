package prova_2.capitulo_6.deque;

/*
 * Created by JJMacagnan on 20/05/2017.
 */
public interface Deque<E> {

    int size();

    boolean isEmpty();

    E first();

    E last();

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();
}
