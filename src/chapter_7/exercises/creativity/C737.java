package chapter_7.exercises.creativity;

import chapter_7.code.iterators.LinkedPositionalList;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
/*C-7.37 Repita o problema anterior, mas use o conhecimento do tamanho da lista para percorrer o final da lista mais próximo do índice desejado.*/
public class C737  {



    public static void main(String[] args) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst(1);
        list.addLast(45);
        list.addFirst("a");
        list.addLast(1000);
        list.addFirst("Star wars");
        list.addLast("abcde");
        list.addFirst(3);
        System.out.println(list.toString());
        System.out.println(list.positionAtIndex(2).getElement());
        System.out.println(list.positionAtIndex(6).getElement());
    }
}
