package chapter_7.exercises.reinforcement;

import chapter_7.code.array_list.ArrayList;
/*R-7.7 Considere uma implementação de um array list ADT usando um array dinâmica,
mas em vez de copiar os elementos em um array de dobro do tamanho (isto é, de N para 2N)
quando sua capacidade é alcançada, copiamos os elementos em uma matriz com ⌈ N / 4⌉ células adicionais,
indo da capacidade N para N + ⌈N / 4⌉.
Mostre que a realização de uma seqüência de n operações de envio (ou seja, inserções no final) ainda é executado no tempo O (n) nesse caso.*/
public class R77 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(1);

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        System.out.println("Size: " + list.size());
    }
}
