package prova_2.capitulo_7.exercicios.reforco;

import prova_2.capitulo_6.deque.Deque;
import prova_2.capitulo_7.array_list.ArrayList;
import prova_2.capitulo_7.array_list.List;

/*
 * Created by jjmacagnan on 04/06/2017.
 */
/*R-7.3 Dê uma implementação do DEQUE de ADT usando uma lista de matriz para armazenamento.*/
public class R73<E> implements Deque<E> {
    List<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        if (isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public E last() {
        if (isEmpty())
            return null;
        return list.get(size()-1);
    }

    @Override
    public void addFirst(E e) {
        list.add(0, e);
    }

    @Override
    public void addLast(E e) {
        list.add(size(), e);
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        return list.remove(0);
    }

    @Override
    public E removeLast() {
        if (isEmpty())
            return null;
        return list.remove(size()-1);
    }

    public static void main(String[] args) {
        Deque deque = new R73<>();

        deque.addFirst(2);
        deque.addLast(1);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(0);
        deque.addLast(45);
        deque.addFirst(78);

        System.out.println("First: " + deque.first());
        System.out.println("Last: " + deque.last());

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println("First: " + deque.first());
        System.out.println("Last: " + deque.last());

    }
}
