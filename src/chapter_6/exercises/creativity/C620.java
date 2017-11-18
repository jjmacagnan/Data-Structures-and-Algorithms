package chapter_6.exercises.creativity;

import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 31/05/2017.
 */

/*Suppose you have three nonempty stacks R, S, and T .
Describe a sequence of operations that results in S storing all elements originally in T below all of S’s original elements,
with both sets of those elements in their original order. The final
configuration for R should be the same as its original configuration. For example,
if R = (1,2,3), S = (4,5), and T = (6,7,8,9), when ordered from bottom to top,
then the final configuration should have R = (1,2,3) and S = (6,7,8,9,4,5).*/

/*Suponha que você tenha três pilhas não vazias R, S e T.
Descreva uma seqüência de operações que resulte em S armazenando todos os
 elementos originalmente em T abaixo de todos os elementos originais de S,
com ambos os conjuntos desses elementos em sua ordem original.
A configuração final para R deve ser a mesma configuração original.
Por exemplo, se R = (1,2,3), S = (4,5) e T = (6,7,8,9), quando ordenados de baixo para cima,
 a configuração final deve ter R = (1,2,3) e S = (6,7,8,9,4,5).*/
public class C620 {

    public static void main(String[] args) {
        ArrayStack<Integer> R = new ArrayStack<>();
        ArrayStack<Integer> S = new ArrayStack<>();
        ArrayStack<Integer> T = new ArrayStack<>();
        R.push(1);
        R.push(2);
        R.push(3);
        S.push(4);
        S.push(5);
        T.push(6);
        T.push(7);
        T.push(8);
        T.push(9);

        int size = R.size();

        while (S.size() > 0)
            R.push(S.pop());

        while (T.size() > 0)
            R.push(T.pop());

        while (R.size() > size)
            S.push(R.pop());

        System.out.println("R: " + R.toString());
        System.out.println();
        System.out.println("S: " + S.toString());
        System.out.println();
        System.out.println("T: " + T.toString());

    }
}
