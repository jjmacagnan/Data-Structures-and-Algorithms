package capitulo_7.exercicios.reforco;

import capitulo_7.positional_list.LinkedPositionalList;

/*R-7.13 Suponha que queremos estender o tipo de dados abstratos PositionalList com um método, findPosition (e),
que retorna a primeira posição contendo um elemento igual a e (ou nulo se nenhuma posição existir).
Mostre como implementar este método usando apenas métodos existentes da interface PositionalList (não detalhes da nossa implementação LinkedPositionalList).*/
public class R713 {

    public static void main(String args[]) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst("A");
        list.addLast("B");
        list.addLastAlt("C");

        list.addBefore(list.first(), 1);
        list.addBeforeAlt(list.last(), 2);
        list.addBeforeAlt(list.first(), "D");

        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        System.out.println("Position: " + list.findPosition("D"));
        System.out.println("Position: " + list.findPosition("C"));

        System.out.println(list.toString());
    }
}
