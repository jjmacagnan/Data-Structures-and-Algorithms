package chapter_3.exercises.reinforcement;

import chapter_3.code.CircularlyLinkedList;

/*Consider the implementation of CircularlyLinkedList.addFirst, in Code Fragment 3.16.
The else body at lines 39 and 40 of that method relies on a locally
declared variable, newest. Redesign that clause to avoid use of any local variable.*/

/*R-3.7 Considere a implementação do CircularlyLinkedList.addFirst, no trecho de código 3.16 (pág. 131).
O corpo do else nas linhas 39 e 40 desse método conta com uma variável declarada localmente, newest.
Redesenhe essa cláusula para evitar o uso de qualquer variável local.
*/
public class R37 {

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();

        list.addFirstNotLocalVariable(1);
        list.addLast(3);
        list.addFirstNotLocalVariable(4);
        list.addLast(2);
        list.addLast(0);
        list.addFirstNotLocalVariable(47);
        list.addLast(6);

        System.out.println(list.toString());

    }
}
