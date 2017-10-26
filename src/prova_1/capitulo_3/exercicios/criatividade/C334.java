package prova_1.capitulo_3.exercicios.criatividade;

import prova_1.capitulo_3.codigos_livro.CircularlyLinkedList;

/*C-3.34 Implement the clone() method for the CircularlyLinkedList class.*/
public class C334 {

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        CircularlyLinkedList clone;

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println("Lista original: " + list.toString());

        try {
            clone  = list.clone();

            System.out.println("Lista clone: " + clone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
