package chapter_7.exercises.reinforcement;

import chapter_7.code.positional_list.LinkedPositionalList;

/*R-7.14 A implementação LinkedPositionalList de Code Fragments 7.9-7.12
não faz nenhuma verificação de erro para testar se uma determinada posição p é
realmente um membro da lista relevante. Dê uma explicação detalhada do efeito de
uma chamada L.addAfter (p, e) em uma lista L, ainda com uma posição p que pertence a alguma outra lista M.*/
public class R714 {

    public static void main(String args[]) {
        LinkedPositionalList L = new LinkedPositionalList();
        LinkedPositionalList M = new LinkedPositionalList();

        L.addFirst("A");
        L.addLast("B");
        L.addLast("C");
        L.addBefore(L.first(), 1);

        System.out.println("Lista L: " + L.toString());

        M.addFirst("F");
        M.addLast("G");
        M.addLast("H");

        System.out.println("Lista M: " +M.toString());

        L.addAfter(M.last(), 2);

        System.out.println("Lista L: " + L.toString());
        System.out.println("Lista M: " +M.toString());

        /*A execução deste teste faz com que o Position que foi pego da Lista M, faz que o o metodo L.addAfter
        * perca a referencia para adicionar na lista L e adiciona na ista M */


    }
}
