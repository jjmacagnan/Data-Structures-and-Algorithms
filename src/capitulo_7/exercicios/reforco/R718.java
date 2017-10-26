package capitulo_7.exercicios.reforco;

import capitulo_7.array_list.ArrayList;

/*
 * Created by jjmacagnan on 07/06/2017.
 */
/*
R-7.18 A interface java.util.Collection inclui um método,
contains(o), que retorna verdadeiro se a coleção contiver
qualquer objeto igual a Object o.
Implementar esse método na classe ArrayList da Seção 7.2..*/
public class R718 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(2);

        for (int i = 0; i < 100; i++)
            list.add(i, i*10);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        boolean temElemento = list.contains(200);

        System.out.println("Existe elemento: " + temElemento);
        System.out.println(list.size());
        System.out.println(list.isEmpty());


    }
}
