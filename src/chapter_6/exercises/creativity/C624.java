package chapter_6.exercises.creativity;

import chapter_6.code.queue.ArrayQueue;
import chapter_6.code.queue.Queue;
import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 03/06/2017.
 */

/*Suppose you have a stack S containing n elements and a queue Q that is initially empty. Describe how you can use Q to scan S to see if it contains a certain
element x, with the additional constraint that your algorithm must return the elements back to S in their original order. You may only use S, Q, and a constant
number of other primitive variables.*/
public class C624 {

    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>();
        Queue<Integer> Q = new ArrayQueue<>();
        int x = 7;

        for (int i = 0; i < 10; i++)
            S.push(i);

        while (S.size() > 0) {
            Q.enqueue(S.pop());
        }

        while (Q.size() > 0) {
            S.push(Q.dequeue());
        }

        while (S.size() > 0) {
            Q.enqueue(S.pop());
        }

        while (Q.size() > 0) {
            int aux = Q.dequeue();
            S.push(aux);
            if (aux == x) {
                System.out.println("Achou X:" + aux);
            }
        }
    }
}
