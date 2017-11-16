package chapter_6.exercises.creativity;

import chapter_6.code.deque.Deque;
import chapter_6.code.deque.LinkedDeque;
import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*tradut*/
public class C632 {

    public static void main(String[] args) {
        Stack S = new ArrayStack();
        Stack T = new ArrayStack();
        Deque D = new LinkedDeque();

        S.push("Casa");
        S.push("Carro");
        T.push(5);
        T.push(23);

        while (S.size() > 0)
            D.addFirst(S.pop());
        while (T.size() > 0)
            D.addFirst(T.pop());

        while (D.size() > 0) {
            S.push(D.removeFirst());
        }

        while (S.size() > 0)
            System.out.println("pop: " + S.pop());
    }
}
