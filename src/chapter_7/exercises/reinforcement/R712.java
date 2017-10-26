package chapter_7.exercises.reinforcement;

import chapter_7.code.positional_list.LinkedPositionalList;

/*
 * Created by jjmacagnan on 04/06/2017.
 */
/*R-7.12 Suponha que queremos estender o tipo de dados abstratos PositionalList com um método indexOf (p),
que retorna o índice atual do elemento armazenado na posição p.
Mostre como implementar este método usando apenas outros métodos da interface PositionalList (não detalhes da nossa implementação LinkedPositionalList).*/
public class R712 {

    public static void main(String args[]) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst("A");
        list.addLast("B");
        list.addLastAlt("C");

        list.addBefore(list.first(), 1);
        list.addBeforeAlt(list.last(), 2);
        list.addBeforeAlt(list.first(), "D");

        System.out.println("index: " + list.indexOf(list.last()));
        System.out.println("index: " + list.indexOf(list.before(list.last())));

        System.out.println(list.toString());
    }


}
