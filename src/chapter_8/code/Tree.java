package chapter_8.code;

import chapter_7.code.positional_list.Position;

import java.util.Iterator;

/*
 * Created by jjmacagnan on 27/05/2017.
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalStateException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalStateException;
    int numChildren(Position<E> p) throws IllegalStateException;
    boolean isInternal(Position<E> p) throws IllegalStateException;
    boolean isExternal(Position<E> p) throws IllegalStateException;
    boolean isRoot(Position<E> p) throws IllegalStateException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
