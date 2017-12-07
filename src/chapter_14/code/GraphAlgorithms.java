package chapter_14.code;

import chapter_10.code.hash_tables.ProbeHashMap;
import chapter_10.code.maps.Map;
import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.PositionalList;

import java.util.HashSet;
import java.util.Set;

public class GraphAlgorithms<V, E> {

    /**
     * Performs depth-first search of the unknown portion of Graph g starting at Vertex u.
     *
     * @param g Graph instance
     * @param u Vertex of graph g that will be the source of the search
     * @param known is a set of previously discovered vertices
     * @param forest is a map from nonroot vertex to its discovery edge in DFS forest
     *
     * As an outcome, this method adds newly discovered vertices (including u) to the known set,
     * and adds discovery graph edges to the forest.
     */
    public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        known.add(u);                                        // u has been discovered
        for (Edge<E> e : g.outgoingEdges(u)) {              // for every outgoing edge from u
            Vertex<V> v = g.opposite(u, e);
            if ((!known.contains(v))) {
                forest.put(v, e);                           // e is the tree edge that discovered v
                DFS(g, v, known, forest);                    // recursively explore from v
            }
        }
    }

    /**
     * Returns an ordered list of edges comprising the directed path from u to v.
     * If v is unreachable from u, or if u equals v, an empty path is returned.
     *
     * @param g Graph instance
     * @param u Vertex beginning the path
     * @param v Vertex ending the path
     * @param forest must be a map that resulting from a previous call to DFS started at u.
     */
    public static <V, E> PositionalList<Edge<E>> constructPath(Graph<V, E> g, Vertex<V> u, Vertex<V> v, Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Edge<E>> path = new LinkedPositionalList<>();
        if (forest.get(v) != null) {                    // v was discovered during the search
            Vertex<V> walk = v;                         // we construct the path from back to front
            while (walk != u) {
                Edge<E> edge = forest.get(walk);
                path.addFirst(edge);                    // add edge to *front* of path
                walk = g.opposite(walk, edge);          // repeat with opposite endpoint
            }
        }
        return path;
    }

    /**
     * Performs DFS for the entire graph and returns the DFS forest as a map.
     *
     * @return map such that each nonroot vertex v is mapped to its discovery edge
     * (vertices that are roots of a DFS trees in the forest are not included in the map).
     */
    public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> g) {
        Set<Vertex<V>> known = new HashSet<>();
        Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
        for (Vertex<V> u : g.vertices()) {
            if (!known.contains(u))
                DFS(g, u, known, forest);               // (re)start the DFS process at u
        }
        return forest;
    }

    /**
     * Performs breadth-first search of the undiscovered portion of Graph g starting at Vertex s.
     *
     * @param g Graph instance
     * @param s Vertex of graph g that will be the source of the search
     * @param known is a set of previously discovered vertices
     * @param forest is a map from nonroot vertex to its discovery edge in DFS forest
     *
     * As an outcome, this method adds newly discovered vertices (including s) to the known set,
     * and adds discovery graph edges to the forest.
     */
    public static <V, E> void BFS(Graph<V, E> g, Vertex<V> s, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Vertex<V>> level = new LinkedPositionalList<>();
        known.add(s);
        level.addFirst(s);                              // first level includes only s
        while (!level.isEmpty()) {
            PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
            for (Vertex<V> u : level) {
                for (Edge<E> e : g.outgoingEdges(u)) {
                    Vertex<V> v = g.opposite(u, e);
                    if (!known.contains(v)) {
                        known.add(v);
                        forest.put(v, e);               // e is the tree edge that discovered v
                        nextLevel.addLast(v);           // v will be further considered in next pass
                    }
                }
            }
            level = nextLevel;                          // relabel 'next' level to become the current
        }
    }

    /**
     * Performs BFS for the entire graph and returns the BFS forest as a map.
     *
     * @return map such that each nonroot vertex v is mapped to its discovery edge
     * (vertices that are roots of a BFS trees in the forest are not included in the map).
     */
    public static <V, E> Map<Vertex<V>, Edge<E>> BFSComplete(Graph<V, E> g) {
        Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
        Set<Vertex<V>> known = new HashSet<>();
        for (Vertex<V> u : g.vertices()) {
            if (!known.contains(u)) {
                BFS(g, u, known, forest);
            }
        }
        return forest;
    }




































}
