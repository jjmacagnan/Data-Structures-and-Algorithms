package capitulo_6.exercicios.reforco;

import capitulo_6.codigos.stack.ArrayStack;

/*
 * Created by jjmacagnan on 29/05/2017.
 */
//Give a recursive method for removing all the elements from a stack.
public class R65_Stack {
    public static void main(String[] args) {
        ArrayStack<Integer> stackS = new ArrayStack<>();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);

        stackS.popAllRecursive(stackS);
        System.out.println("Size " + stackS.size());
    }
}
