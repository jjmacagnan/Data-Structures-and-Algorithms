package chapter_6.code.deque;

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
