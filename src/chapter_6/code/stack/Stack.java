package chapter_6.code.stack;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public interface Stack<E> {

    int size();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();

    String toString();
}
