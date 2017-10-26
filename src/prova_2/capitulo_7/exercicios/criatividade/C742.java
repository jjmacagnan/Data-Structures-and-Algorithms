package prova_2.capitulo_7.exercicios.criatividade;

import prova_2.capitulo_7.iterators.LinkedPositionalList;

/*
 * Created by jjmacagnan on 10/06/2017.
 */

/*C-7.42 Descreva um método não recursivo para reverter uma positional list representada com uma lista duplamente vinculada usando um único passe na lista.*/

public class C742 {

    public static void main(String[] args) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst(1);
        list.addLast(45);
        list.addFirst("a");
        list.addLast(1000);
        list.addFirst("Star wars");
        list.addLast("abcde");
        list.addFirst(3);
        list.addLast(8);
        System.out.println(list.toString());
        System.out.println("Revertendo a lista");
        list.reverse();
        System.out.println(list.toString());


    }
}
