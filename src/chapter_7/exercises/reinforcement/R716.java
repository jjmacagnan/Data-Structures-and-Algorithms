package chapter_7.exercises.reinforcement;

import chapter_7.code.iterators.LinkedPositionalList;

/*R-7.16 Descreva como implementar um método, alternateIterator(),
para uma lista de posição que retorna um iterador que relata apenas os elementos com índice igual na lista.*/
public class R716 {

    public static void main(String args[]) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addAfter(list.first(), 4);
        list.addBefore(list.last(), 5);

        System.out.println(list.toString());

        list.iterator();

        while (list.iterator().hasNext()) {
            System.out.println("iterator");
        }
    }






}
