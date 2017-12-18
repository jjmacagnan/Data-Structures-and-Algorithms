package chapter_12.exercises;


import chapter_7.code.iterators.LinkedPositionalList;

/*
C-12.29 Augment the PositionalList class (see Section 7.3) to support a method named
merge with the following behavior. If A and B are PositionalList instances whose
elements are sorted, the syntax A.merge(B) should merge all elements of B into
A so that A remains sorted and B becomes empty. Your implementation must
accomplish the merge by relinking existing nodes; you are not to create any new
nodes.
 */
public class C1229 {

    public static void main(String[] args) {

        LinkedPositionalList a = new LinkedPositionalList();
        LinkedPositionalList b = new LinkedPositionalList();


        a.addFirst(8);
        a.addFirst(5);
        a.addFirst(2);

        System.out.println("A antes " + a.toString());

        b.addFirst(4);
        b.addFirst(3);
        b.addFirst(1);

        System.out.println("B antes " + b.toString());

        a.merge(b);

        System.out.println(a.toString());

    }
}
