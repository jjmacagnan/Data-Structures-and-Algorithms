package chapter_7.exercises.creativity;

import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;

/*C-7.40 Refazer o problema anterior, mas fornecer uma implementação dentro da classe LinkedPositionalList que não cria ou destrói nenhum nós.*/
public class C740 {

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
        Position p = list.before(list.last());
        System.out.println("Move to front: " + p.getElement());
        list.moveToFrontAlt(p);
        System.out.println(list.toString());
    }
}
