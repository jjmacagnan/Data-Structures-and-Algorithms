package capitulo_7.exercicios.criatividade;

import capitulo_7.iterators.LinkedPositionalList;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
/*C-7.36 Suponha que queremos estender a interface PositionalList para incluir um método,
positionAtIndex (i), que retorna a posição do elemento com índice i (ou lança uma IndexOutOfBoundsException, se for garantido).
Mostre como implementar este método, usando apenas os métodos existentes da interface PositionalList,
atravessando o número apropriado de etapas da frente da lista.*/
public class C736  {

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
        System.out.println(list.positionAtIndex(2).getElement());
        System.out.println(list.positionAtIndex(6).getElement());
    }
}
