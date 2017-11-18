package chapter_7.exercises.reinforcement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * Created by jjmacagnan on 09/06/2017.
 */
/*R-7.20 Demonstrar como usar o método java.util.Colletions.reverse para reverter uma série de objetos..*/
public class R720 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < 10; i++)
            list.add(i, i*10);

        System.out.println("Array original");
        System.out.println(list.toString());

        System.out.println("Array reverso");
        Collections.reverse(list);

        System.out.println(list.toString());
    }
}
