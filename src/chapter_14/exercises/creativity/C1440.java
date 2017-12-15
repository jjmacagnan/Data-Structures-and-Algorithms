package chapter_14.exercises.creativity;

import chapter_10.code.maps.Map;
import chapter_14.code.Edge;
import chapter_14.code.Graph;
import chapter_14.code.Vertex;

import java.util.Set;

public class C1440 {

    public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Vertex<V> z, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        known.add(u);                                        // u has been discovered
        if(u != z) {
            for (Edge<E> e : g.outgoingEdges(u)) {              // for every outgoing edge from u
                Vertex<V> v = g.opposite(u, e);
                if ((!known.contains(v))) {
                    forest.put(v, e);                           // e is the tree edge that discovered v
                    DFS(g, v, z, known, forest);                    // recursively explore from v
                }
            }
        }
    }

}
