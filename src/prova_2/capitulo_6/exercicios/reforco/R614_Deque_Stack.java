package prova_2.capitulo_6.exercicios.reforco;

import prova_2.capitulo_6.deque.Deque;
import prova_2.capitulo_6.deque.LinkedDeque;
import prova_2.capitulo_6.queue.LinkedQueue;
import prova_2.capitulo_6.stack.LinkedStack;

/*
 * Created by jjmacagnan on 31/05/2017.
 */

/*Suppose you have a deque D containing the numbers (1,2,3,4,5,6,7,8), in this
        order. Suppose further that you have an initially empty queue Q. Give a code
        fragment that uses only D and Q (and no other variables) and results in D storing
        the elements in the order (1,2,3,5,4,6,7,8)

        Repeat the previous problem using the deque D and an initially empty stack S.*/
public class R614_Deque_Stack {
    public static void main(String[] args) {
        Deque<Integer> D = new LinkedDeque<>();
        LinkedStack<Integer> S = new LinkedStack<>();

        D.addFirst(1);
        D.addLast(2);
        D.addLast(3);
        D.addLast(4);
        D.addLast(5);
        D.addLast(6);
        D.addLast(7);
        D.addLast(8);

        while (D.size() > 0) {
            S.push(D.removeLast());
        }

        System.out.println("imprimindo pilha");
        S.imprime();

        while (!S.isEmpty()) {
            D.addLast(S.pop());
        }

    }
}
