package prova_2.capitulo_7.exercicios.reforco;

import prova_2.capitulo_7.array_list.ArrayList;
import prova_2.capitulo_7.array_list.List;

/*R-7.5 O java.util.ArrayList inclui um método, trimToSize (),
que substitui o array subjacente com uma cuja capacidade é exatamente igual ao número de elementos atualmente na lista.
Implementar esse método para a nossa versão dinâmica da classe ArrayList da Seção 7.2..*/
public class R75 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(16);

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        list.trimToSize();
        System.out.println("Size: " + list.size());
    }
}
