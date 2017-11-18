package chapter_6.exercises.reinforcement;

import chapter_6.code.queue.ArrayQueue;
import chapter_6.code.queue.Queue;

/*
 * Created by jjmacagnan on 29/05/2017.
 */

/*R-6.7 Suponha que uma fila inicialmente vazia Q tenha realizado um total de 32 operações emqueue,
10 first operações e 15 operações de dequeue, 5 das quais retornaram null para indicar uma fila vazia.
Qual é o tamanho atual do Q?*/

/*O tamanho atual de Q será 22, pois das 15 operações dequeue apenas 5 retiram um elemento da fila
* 32 - 10 = 22*/

public class R67_Queue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(30);

        queue.enqueue(1);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        System.out.println(queue.first());
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        queue.enqueue(8);
        System.out.println(queue.first());
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println(queue.dequeue());
        queue.enqueue(12);
        System.out.println(queue.first());
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        System.out.println(queue.first());
        queue.enqueue(16);
        System.out.println(queue.dequeue());
        queue.enqueue(17);
        queue.enqueue(18);
        System.out.println(queue.first());
        queue.enqueue(19);
        queue.enqueue(20);
        System.out.println(queue.first());
        queue.enqueue(21);
        queue.enqueue(22);
        System.out.println(queue.first());
        queue.enqueue(23);
        System.out.println(queue.dequeue());
        queue.enqueue(24);
        queue.enqueue(25);
        queue.enqueue(26);
        System.out.println(queue.first());
        queue.enqueue(27);
        queue.enqueue(28);
        queue.enqueue(29);
        System.out.println(queue.first());
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        queue.enqueue(31);
        queue.enqueue(32);

        System.out.println("size: " + queue.size());

    }
}
