package chapter_8.exercises.creativity;

/*C-8.43 Give an O(n)-time algorithm for computing the depths of all positions of a tree
T , where n is the number of nodes of T.*/

/*C-8.43 Dê um algoritmo de tempo O(n) para calcular as profundidades de todas as posições de uma árvore T, onde n é o número de nós de T*/

import chapter_8.code.LinkedBinaryTree;

public class C843 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");


        tree.depthN(tree.root(), 0);

    }
}
