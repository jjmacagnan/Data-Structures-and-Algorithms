package prova_2.capitulo_7.exercicios.criatividade;

import prova_2.capitulo_7.iterators.LinkedPositionalList;
import prova_2.capitulo_7.positional_list.Position;

/*C-7.39 Suponha que queremos estender o tipo de dados abstratos PositionalList com um método, moveToFront(p),
que move o elemento na posição p para a frente de uma lista (se não estiver lá),
mantendo a ordem relativa do restante elementos inalterados.
Mostre como implementar este método usando apenas métodos existentes da interface PositionalList (não detalhes da nossa implementação LinkedPositionalList).*/
public class C739 {

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
        Position p = list.after(list.first());
        System.out.println("Move to front: " + p.getElement());
        list.moveToFront(p);
        System.out.println(list.toString());
    }
}
