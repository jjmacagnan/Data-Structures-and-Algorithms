package chapter_7.exercises.creativity;

import chapter_7.code.array_list.ArrayList;
import chapter_7.code.array_list.List;

/*
 * Created by jjmacagnan on 10/06/2017.
 */
/*C-7.29 Revise a implementação do ArrayList dada na Seção 7.2.1 para que, quando o número real de elementos, n,
no array desça abaixo de N / 4, onde N é a capacidade do array, o array diminui para metade do tamanho.*/
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
