package chapter_7.exercises.reinforcement;

import chapter_7.code.array_list.ArrayList;
import chapter_7.code.array_list.List;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*R-7.1 Desenhe uma representação, semelhante ao Exemplo 7.1,
de uma lista inicialmente vazia L após realizar a seguinte sequência de operações:
add(0, 4), add(0, 3), add(0, 2), add(2, 1), add(1, 5), add(1, 6), add(3, 7), add(0, 8).*/
public class R71 {

    public static void main (String[] args) {
        List list = new ArrayList<>();

        list.add(0, 4);
        list.add(0, 3);
        list.add(0, 2);
        list.add(2, 1);
        list.add(1, 5);
        list.add(1, 6);
        list.add(3, 7);
        list.add(0, 8);

    }
}
