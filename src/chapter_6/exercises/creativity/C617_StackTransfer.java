package chapter_6.exercises.creativity;

import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 31/05/2017.
 */

/*Show how to use the transfer method, described in Exercise R-6.4, and two temporary stacks,
to replace the contents of a given stack S with those same elements,
but in reversed order.*/

/*Mostre como usar o método de transferência, descrito no Exercício R-6.4,
e duas pilhas temporárias, para substituir o conteúdo de uma determinada pilha S com esses mesmos elementos, mas em ordem inversa.*/

public class C617_StackTransfer {

    public static void main(String[] args) {
        ArrayStack<Integer> stackS = new ArrayStack<>();
        ArrayStack<Integer> stackT = new ArrayStack<>();
        ArrayStack temp1 = new ArrayStack();
        ArrayStack temp2 = new ArrayStack();

        stackS.push(1);
        stackS.push(2);
        stackS.push(3);

        stackT.push(5);

        System.out.println("Imprimindo pilha S");
        System.out.println(stackS.toString());
        System.out.println();

        System.out.println("Imprimindo pilha T");
        System.out.println(stackT.toString());
        System.out.println();

        System.out.println("Stack transfer from S to T");
        //stackS.transferSameOrderRecursive(stackS, stackT);
        stackS.transferInverseRecursive(stackS, stackT);

        System.out.println(stackT.toString());


    }
}
