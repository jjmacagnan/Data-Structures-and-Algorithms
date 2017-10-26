package prova_2.capitulo_7.exercicios.reforco;

import prova_2.capitulo_7.array_list.ArrayList;

/*
 * Created by jjmacagnan on 07/06/2017.
 */
/*R-7.19 A interface java.util.Collection inclui um método, clear (),
que remove todos os elementos de uma coleção. Implementar esse método na classe ArrayList da Seção 7.2./
 */
public class R719 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(2);

        for (int i = 0; i < 100; i++)
            list.add(i, i*10);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        list.clear();

        System.out.println(list.size());
        System.out.println(list.isEmpty());


    }
}
