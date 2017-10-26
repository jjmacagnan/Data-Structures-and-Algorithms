package chapter_6.exercises.creativity;

import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by jjmacagnan on 31/05/2017.
 */

/*Show how to use the transfer method, described in Exercise R-6.4, and two temporary stacks, to replace the contents of a given stack S with those same elements,
but in reversed order.*/
public class C617_StackTransfer {

    public static void main(String[] args) {
        ArrayStack<Integer> stackS = new ArrayStack<>();
        ArrayStack<Integer> stackT = new ArrayStack<>();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);

        System.out.println(stackS.size());

        System.out.println("Top stackS: " + stackS.top());

        Stack st = stackS.transferInverso(stackS, stackT);

        System.out.println("Top stackT: " + st.top());
    }
}
