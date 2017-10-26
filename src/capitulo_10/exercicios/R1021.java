package capitulo_10.exercicios;

import capitulo_10.maps.sorted_maps.SortedTableMap;

/*
 * Created by Jasie on 17/06/2017.
 */
/*R-10.21 Consider the following variant of the findIndex method of the SortedTableMap
class, originally given in Code Fragment 10.11:
1 private int findIndex(K key, int low, int high) {
2 if (high < low) return high + 1;
3 int mid = (low + high) / 2;
4 if (compare(key, table.get(mid)) < 0)
5 return findIndex(key, low, mid − 1);
6 else
7 return findIndex(key, mid + 1, high);
8 }
Does this always produce the same result as the original version? Justify your
answer*/
public class R1021 {

    public static void main(String[] args) {
        SortedTableMap map = new SortedTableMap();

        map.put(1, "A");
        map.put(2, "E");
        map.put(3, "I");
        map.put(4, "O");
        map.put(5, "U");

        System.out.println(map.get(3));
        System.out.println(map.get(1));
        System.out.println(map.get(4));



    }
}
