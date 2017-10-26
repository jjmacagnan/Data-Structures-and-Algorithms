package prova_1.capitulo_3.exercicios.reforco;

import prova_1.capitulo_3.codigos_livro.SinglyLinkedList;

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
