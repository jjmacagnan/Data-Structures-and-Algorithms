package chapter_7.exercises.creativity;

import chapter_7.code.array_list.ArrayList;
import chapter_7.code.array_list.List;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
/*Considere uma variante do Exercício C-7.29, na qual um conjunto de capacidade N é redimensionado
para a capacidade precisamente do número de elementos, sempre que o número de elementos na matriz
for estritamente abaixo de N / 4.
Forneça uma prova formal de que qualquer seqüência de n operações de push ou pop em uma
matriz dinâmica inicialmente vazia leva tempo de O (n).*/
public class C732 {

    public static void main(String[] args) {
        List list = new ArrayList(10);

        for (int i = 0; i < 100; i++) {
            list.add(i, i * 3);
        }
        System.out.println(list.size());

        while (!list.isEmpty())
            System.out.println("removendo elemento: " + list.remove(list.size() - 1));
    }
}

/*protected void resizeN() {
        E[] temp = (E[]) new Object[size]; 2 operações

        for (int k = 0; k < size; k++) { 1 + 2n operações
            temp[k] = data[k]; 3n operações
        }

        data = temp; 1 operação
    }

    5n + 4 operações, ou seja:
    Executa em tempo O(n)

    */
