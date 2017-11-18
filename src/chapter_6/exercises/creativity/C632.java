package chapter_6.exercises.creativity;

import chapter_6.code.deque.Deque;
import chapter_6.code.deque.LinkedDeque;
import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*Suponha que você tenha duas pilhas não vazias S e T e um deque D.
Descreva como usar D para que S armazene todos os elementos de T abaixo de todos os seus elementos originais,
com ambos os conjuntos de elementos ainda em sua ordem original.*/
public class C632 {

    public static void main(String[] args) {
        ArrayStack S = new ArrayStack();
        ArrayStack T = new ArrayStack();
        LinkedDeque D = new LinkedDeque();

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

        System.out.println("S:" + S.toString());
        System.out.println();
        System.out.println("T: " + T.toString());
        System.out.println();
        System.out.println("D: " + D.toString());


    }
}
