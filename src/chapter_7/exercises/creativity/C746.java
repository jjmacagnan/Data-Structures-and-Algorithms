package chapter_7.exercises.creativity;

import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;

/*
 * Created by jjmacagnan on 10/06/2017.
 */

/*C-7.46 Modify the LinkedPositionalList class to support a method swap(p, q) that causes
the underlying nodes referenced by positions p and q to be exchanged for each
other. Relink the existing nodes; do not create any new nodes.*/

/*C-7.46 Modifique a classe LinkedPositionalList para suportar um método swap(p, q)
que faz com que os nós subjacentes referenciados pelas posições p e q sejam trocados um pelo outro.
Relink os nós existentes; não crie novos nós.*/
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

        list.swap(list.last(), list.first());
        System.out.println(list.toString());

        list.swap(list.before(list.last()), list.after(list.first()));
        System.out.println(list.toString());


    }


}


