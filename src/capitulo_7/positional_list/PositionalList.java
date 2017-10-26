package capitulo_7.positional_list;


import java.util.Iterator;

/*
 * Created by JJMacagnan on 20/05/2017.
 */
public interface PositionalList<E>  {

    int size();

    boolean isEmpty();

    Position<E> first();

    Position<E> last();

    Position<E> before(Position<E> p) throws IllegalStateException;

    Position<E> after(Position<E> p) throws IllegalStateException;

    Position<E> addFirst(E e);

    Position<E> addLast(E e);

    Position<E> addBefore(Position<E> p, E e) throws IllegalStateException;

    Position<E> addAfter(Position<E> p, E e) throws IllegalStateException;

    E set(Position<E> p, E e) throws IllegalStateException;

    E remove(Position<E> p) throws IllegalStateException;

    Iterator<E> iterator();

    Iterable<Position<E>> positions();

    int indexOf(Position<E> p);

    Position<E> findPosition(E e);

    Position positionAtIndex(int i);

    void moveToFront(Position p);
}
