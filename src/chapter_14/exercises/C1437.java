package chapter_14.exercises;

/*C-14.37 Give a Java implementation of the removeEdge(e) method for our adjacency map
implementation of Section 14.2.5, making sure your implementation works for
both directed and undirected graphs. Your method should run in O(1) time.*/

import chapter_14.code.*;

public class C1437 {

    public static void main(String[] args) {
        Graph g = new AdjacencyMapGraph(false);


        Vertex vA = g.insertVertex("A");
        Vertex vB = g.insertVertex("B");
        Edge e1 = g.insertEdge(vA, vB, "e");

        g.removeEdge(e1);

    }

}
