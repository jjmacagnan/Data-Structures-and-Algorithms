package prova_2.capitulo_7.exercicios.reforco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * Created by jjmacagnan on 09/06/2017.
 */
/*R-7.20 Demonstrar como usar o método java.util.Colletions.verse para reverter uma série de objetos..*/
public class R720 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < 10; i++)
            list.add(i, i*10);

        System.out.println("Array original");
        for (Integer elemento : list){
            System.out.println(elemento);
        }

        System.out.println("Array reverso");
        Collections.reverse(list);

        for (Integer elemento : list){
            System.out.println(elemento);
        }
    }
}
