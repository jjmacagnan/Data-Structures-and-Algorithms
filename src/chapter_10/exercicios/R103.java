package chapter_10.exercicios;

import chapter_10.maps.UnsortedTableMap;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
public class R103 {

    public static void main(String[] args) {

        UnsortedTableMap map = new UnsortedTableMap();

        map.put("A", "Avião");
        map.put(1, "Barco");
        map.put("D", "Dinheiro");
        map.put(null, null);

        System.out.println(map.containsKey("A"));
        System.out.println(map.containsKey(4));
        System.out.println(map.containsKey(null));


    }
}
