package capitulo_7.exercicios.criatividade;

import capitulo_7.iterators.LinkedPositionalList;
import capitulo_7.positional_list.Position;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
public class C746 {

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

        Position p = list.first();
        Position q = list.last();

        list.swap(list.last(), list.first());


        System.out.println(list.toString());


    }


}


