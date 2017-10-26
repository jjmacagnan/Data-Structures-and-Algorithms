package prova_2.capitulo_7.exercicios.criatividade;

import prova_2.capitulo_7.iterators.LinkedPositionalList;

/*C-7.44 Descreva um método para executar um shuffle de cartas de uma lista de elementos 2n,
convertendo-o em duas listas. Um shuffle de cartão é uma permutação onde uma lista L é cortada em duas listas,
L1 e L2, onde L1 é a primeira metade de L e L2 é a segunda metade de L e, em seguida,
 essas duas listas são mescladas em uma, tomando o primeiro elemento em L1, então o primeiro elemento em L2,
 seguido pelo segundo elemento em L1, o segundo elemento em L2, e assim por diante.*/
public class C744 {

    public static void main(String[] args) {
        LinkedPositionalList list = new LinkedPositionalList();
        LinkedPositionalList list1;

        list.addFirst(1);
        list.addLast(45);
        list.addFirst("a");
        list.addLast(1000);
        list.addFirst("Star wars");
        list.addLast("abcde");
        list.addFirst(3);
        list.addLast(8);
        System.out.println(list.toString());

        list1 = list.cardShuffle(list);

        System.out.println(list1.toString());

    }
}
