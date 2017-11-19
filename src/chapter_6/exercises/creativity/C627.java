package chapter_6.exercises.creativity;


import chapter_6.code.stack.ArrayStack;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*Implement the clone() method for the ArrayStack class. (See Section 3.6 for a
discussion of cloning data structures.)*/

/*Implementar o método clone() para a classe ArrayStack. (Consulte a Seção 3.6 para uma discussão de estruturas de dados de clonagem.)*/
public class C627 {

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayStack S = new ArrayStack();

        S.push("a");
        S.push("b");
        S.push("c");
        S.push("d");
        S.push("e");

        ArrayStack stack = S.clone();
        stack.size();

        System.out.println("Pilha original: " + S.toString());
        System.out.println("Pilha clone: " + stack.toString());

        while (stack.size() > 0) {
            System.out.println("pop pilha clone: " + stack.pop());
        }

        System.out.println("Pilha original após pop da clone: " + S.toString());
        System.out.println("Pilha clone após pop da clone: " + stack.toString());


    }
}
