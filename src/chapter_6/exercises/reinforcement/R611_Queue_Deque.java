package chapter_6.exercises.reinforcement;

import chapter_6.code.deque.Deque;
import chapter_6.code.deque.LinkedDeque;
import chapter_6.code.queue.Queue;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*R-6.10 Implemente o ADT da Queue usando uma instância de
um deque para armazenamento.*/
public class R611_Queue_Deque<E> implements Queue<E> {
    Deque<E> deque = new LinkedDeque<>();

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        deque.addLast(e);
    }

    @Override
    public E first() {
        return deque.first();
    }

    @Override
    public E dequeue() {
        return deque.removeFirst();
    }

    public  static void main(String[] args) {
        Queue<Integer> queue = new R611_Queue_Deque<>();


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("first: " + queue.first());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
    }
}
