package chapter_7.exercises.creativity;

import chapter_7.code.iterators.LinkedPositionalList;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
/*C-7.41 Modifique nossa implementação LinkedPositionalList para suportar a interface Cloneable, conforme descrito na Seção 3.6.*/
public class C741 {

    public static void main (String[] args) {

        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst(1);
        list.addLast(45);
        list.addFirst("a");
        list.addLast(1000);
        list.addFirst("Star wars");
        list.addLast("abcde");
        list.addFirst(3);
        System.out.println("Lista original: " + list.toString());

        try {
            LinkedPositionalList list1 = list.clone();
            System.out.println("Lista clone: " + list1.toString());

            LinkedPositionalList list2 = list.clone2();
            System.out.println("Lista clone 2: " + list2.toString());

            while (list1.iterator().hasNext()) {
                System.out.println("Removendo elemento clone: " + list1.remove(list1.first()));
                System.out.println("Removendo elemento clone: " + list2.remove(list2.first()));
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Lista original: " + list.toString());

    }
}
