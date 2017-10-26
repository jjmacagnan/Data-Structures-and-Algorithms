package prova_2.capitulo_6.stack;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public interface Stack<E> {

    int size();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();
}
