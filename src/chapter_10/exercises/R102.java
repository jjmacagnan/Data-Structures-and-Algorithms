package chapter_10.exercises;

import chapter_10.code.maps.AbstractMap;
import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.Entry;

public class R102<K,V> extends AbstractMap<K,V> {

    private LinkedPositionalList<MapEntry<K, V>> list = new LinkedPositionalList<>();

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public V get(K key) {
        MapEntry<K, V> entryFound = null;
        for(Position p : list.positions()) {
            MapEntry entry = (MapEntry<K, V>) p.getElement();
            if(entry.getKey().equals(key))  {
                entryFound = entry;
            }
        }

        return (V) entryFound.getValue();
    }

    @Override
    public V put(K key, V value) {
        MapEntry<K, V> entryFound = null;
        Position<MapEntry<K, V>> pFound = null;
        for(Position p : list.positions()) {
            MapEntry entry = (MapEntry<K, V>) p.getElement();
            if(entry.getKey().equals(key))  {
                pFound = p;
                entryFound = entry;
            }
        }

        if(entryFound == null) {
            list.addLast(new MapEntry<>(key, value));
        } else {

            return (V) list.set(pFound, new MapEntry<>(key, value)).getValue();
        }

        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {

        R102 unsortedtablemap = new R102();
        unsortedtablemap.put(1, "Star Wars");
        unsortedtablemap.put(2, 2);
        unsortedtablemap.put(3, "Toy Story");



        System.out.println(unsortedtablemap.put(3, "Vida de inseto"));
        System.out.println(unsortedtablemap.get(2));
        System.out.println(unsortedtablemap.get(1));
        System.out.println(unsortedtablemap.get(3));

    }
}
