package capitulo_6.exercicios.reforco;

import capitulo_6.codigos.stack.ArrayStack;
import capitulo_6.codigos.stack.Stack;

/*
 * Created by jjmacagnan on 29/05/2017.
 */

/*R-6.4 Implementar um método com transferência de assinatura (S, T)
que transfere todos os elementos da pilha S para a pilha T,
de modo que o elemento que começa na parte superior de S é o primeiro a ser
inserido em T e o elemento no fundo de S acaba na parte superior de T.*/
public class R64_Stack {
    public static void main(String[] args) {
        ArrayStack<Integer> stackS = new ArrayStack<>();
        ArrayStack<Integer> stackT = new ArrayStack<>();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);

        stackT.push(5);

        System.out.println(stackS.size());


        System.out.println("Top stackS: " + stackS.top());

        Stack st = stackS.transfer(stackS, stackT);

        System.out.println("Top stackT: " + st.top());
    }
}
