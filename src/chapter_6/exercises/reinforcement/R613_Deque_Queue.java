package chapter_6.exercises.reinforcement;

import chapter_6.code.deque.LinkedDeque;
import chapter_6.code.queue.LinkedQueue;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*Suppose you have a deque D containing the numbers (1,2,3,4,5,6,7,8), in this
        order. Suppose further that you have an initially empty queue Q. Give a code
        fragment that uses only D and Q (and no other variables) and results in D storing
        the elements in the order (1,2,3,5,4,6,7,8).*/

/*Suponha que você tenha um deque D contendo os números (1,2,3,4,5,6,7,8), nesta ordem.
Suponha ainda que você tenha uma fila inicialmente vazia.
Dê um fragmento de código que use apenas D e Q (e nenhuma outra variável)
e resulte em D armazenando os elementos na ordem (1,2,3,5,4,6,7,8).*/

public class R613_Deque_Queue {
    public static void main(String[] args) {
        LinkedDeque<Integer> D = new LinkedDeque<>();
        LinkedQueue<Integer> Q = new LinkedQueue<>();

        D.addFirst(1);
        D.addLast(2);
        D.addLast(3);
        D.addLast(4);
        D.addLast(5);
        D.addLast(6);
        D.addLast(7);
        D.addLast(8);

        System.out.println("imprimindo fila");
        System.out.println(Q.toString());

        for (int i = 0; i < 3; i++)
            Q.enqueue(D.removeFirst());

        D.addLast(D.removeFirst());
        Q.enqueue(D.removeFirst());
        Q.enqueue(D.removeLast());

        for (int i = 0; i < 3; i++) {
            Q.enqueue(D.removeFirst());
        }

        while (!Q.isEmpty()) {
            D.addLast(Q.dequeue());
        }

        System.out.println("imprimindo deque");
        System.out.println(D.toString());

    }
}
