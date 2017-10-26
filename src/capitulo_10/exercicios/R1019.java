package capitulo_10.exercicios;

import capitulo_10.maps.sorted_maps.SortedTableMap;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
public class R1019 {

    public static void main(String[] args) {

        SortedTableMap map = new SortedTableMap();

        map.put("A", "Avião");
        map.put(1, "Barco");
        map.put("D", "Dinheiro");
        map.put(null, null);

        System.out.println(map.containsKey("A"));
        System.out.println(map.containsKey(4));
        System.out.println(map.containsKey(null));


    }
}
