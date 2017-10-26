package chapter_6.code.queue;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
