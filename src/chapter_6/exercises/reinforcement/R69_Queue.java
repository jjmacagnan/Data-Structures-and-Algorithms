package chapter_6.exercises.reinforcement;

import chapter_6.code.queue.ArrayQueue;
import chapter_6.code.queue.Queue;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*What values are returned during the following sequence of queue operations, if
        executed on an initially empty queue? enqueue(5), enqueue(3), dequeue(),
        enqueue(2), enqueue(8), dequeue(), dequeue(), enqueue(9), enqueue(1),
        dequeue(), enqueue(7), enqueue(6), dequeue(), dequeue(), enqueue(4),
        dequeue(), dequeue().*/
public class R69_Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(30);

        queue.enqueue(5);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(9);
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(7);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("first: " + queue.first());
        System.out.println("size: " + queue.size());

    }
}
