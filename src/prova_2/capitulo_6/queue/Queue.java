package prova_2.capitulo_6.queue;

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
