package chapter_6.exercises.creativity;

import chapter_6.code.queue.LinkedQueue;

/*
 * Created by jjmacagnan on 18/06/2017.
 */
/*Implement a method with signature concatenate(LinkedQueue<E> Q2) for the
LinkedQueue<E> class that takes all elements of Q2 and appends them to the
end of the original queue. The operation should run in O(1) time and should
result in Q2 being an empty queue.*/
public class C629 {

    public static void main(String[] args) {
        LinkedQueue<String> Q = new LinkedQueue<>();
        LinkedQueue<String> Q1 = new LinkedQueue<>();

        Q.enqueue("a");
        Q.enqueue("b");
        Q.enqueue("c");
        Q1.enqueue("d");
        Q1.enqueue("e");

        Q.concatenate(Q1);

        System.out.println("Q: " + Q.toString());
        System.out.println();
        System.out.println("Q1: " + Q1.toString());
    }
}
