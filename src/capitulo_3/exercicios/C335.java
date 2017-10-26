package capitulo_3.exercicios;

import capitulo_3.codigos.DoublyLinkedList;

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
