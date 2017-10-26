package prova_2.capitulo_6.exercicios.criatividade;

import prova_2.capitulo_6.deque.Deque;
import prova_2.capitulo_6.deque.LinkedDeque;
import prova_2.capitulo_6.stack.ArrayStack;
import prova_2.capitulo_6.stack.Stack;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*Suppose you have two nonempty stacks S and T and a deque D. Describe how
to use D so that S stores all the elements of T below all of its original elements,
with both sets of elements still in their original order*/
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
