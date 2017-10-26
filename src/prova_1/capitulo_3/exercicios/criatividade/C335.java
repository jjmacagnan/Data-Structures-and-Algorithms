package prova_1.capitulo_3.exercicios.criatividade;

import prova_1.capitulo_3.codigos_livro.CircularlyLinkedList;
import prova_1.capitulo_3.codigos_livro.DoublyLinkedList;

/*C-3.35 Implement the clone() method for the DoublyLinkedList class.*/
public class C335 {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList clone;

        list.addLast(1);
        list.addLast(2);

        System.out.println("Lista original: " + list.toString());

        try {
            clone  = list.clone();

            System.out.println("Lista clone: " + clone.toString());
            clone.removeFirst();
            System.out.println("Lista clone: " + clone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
