package capitulo_3.exercicios;

import capitulo_3.codigos.SinglyLinkedList;

/* Implement a rotate() method in the SinglyLinkedList class, which has semantics
equal to addLast(removeFirst()), yet without creating any new node.*/

/*R-3.12 Implemente um método rotate() na classe SinglyLinkedList,
no qual possui semântica igual a addLast(removeFirst()),
sem a necessidade de se criar um novo nó.*/
public class R312 {

    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);

        System.out.println(list.toString());
        System.out.println("rotate");
        list.rotate();
        System.out.println(list.toString());
        System.out.println("rotate");
        list.rotate();
        System.out.println(list.toString());

        int[] backup = {0,1,2,3,4,5};

        int[] a = backup;
        int b[] = backup;


        for (int i = 0; i < a.length; i++) {
            System.out.print("," + a[i]);
        }

        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print("," + b[i]);
        }
    }
}
