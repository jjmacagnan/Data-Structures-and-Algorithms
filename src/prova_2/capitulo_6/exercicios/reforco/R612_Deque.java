package prova_2.capitulo_6.exercicios.reforco;

import prova_2.capitulo_6.deque.Deque;
import prova_2.capitulo_6.deque.LinkedDeque;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*What values are returned during the following sequence of deque ADT
        operations, on an initially empty deque? addFirst(3), addLast(8), addLast(9),
        addFirst(1), last(), isEmpty(), addFirst(2), removeLast(), addLast(7), first(),
        last(), addLast(4), size(), removeFirst(), removeFirst()*/
public class R612_Deque {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedDeque<>();

        deque.addFirst(3);
        deque.addLast(8);
        deque.addLast(9);
        deque.addFirst(1);
        System.out.println(deque.last());
        System.out.println(deque.isEmpty());
        deque.addFirst(2);
        System.out.println(deque.removeLast());
        deque.addLast(7);
        System.out.println(deque.first());
        System.out.println(deque.last());
        deque.addLast(4);
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println("size " + deque.size());
        System.out.println("first " + deque.first());
        System.out.println("last " + deque.last());
    }
}
