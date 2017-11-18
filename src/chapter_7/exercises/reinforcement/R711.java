package chapter_7.exercises.reinforcement;

import chapter_7.code.positional_list.LinkedPositionalList;

/* R-7.11 Descreva uma implementação dos métodos da lista de posição addLast e addBefore
realizado usando apenas métodos no set {isEmpty, first, last, before, after, addAfter, addFirst}.*/
public class R711 {

    public static void main(String args[]) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst("A");
        System.out.println(list.toString());
        list.addLast("B");
        System.out.println(list.toString());
        list.addLastAlt("C");
        System.out.println(list.toString());
        list.addBefore(list.first(), 1);
        System.out.println(list.toString());
        list.addBeforeAlt(list.last(), 2);
        System.out.println(list.toString());
        list.addBeforeAlt(list.first(), "D");
        System.out.println(list.toString());
    }
}
