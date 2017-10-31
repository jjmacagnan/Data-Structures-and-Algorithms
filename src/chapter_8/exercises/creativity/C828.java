package chapter_8.exercises.creativity;

/*The path length of a tree T is the sum of the depths of all positions in T . Describe a linear-time method for computing the path length of a tree T .*/

import chapter_8.code.LinkedBinaryTree;

/*C-8.28 O comprimento do caminho de uma árvore T é a soma das profundidades de todas as posições em T.
Descreva um método de tempo linear para calcular o comprimento do caminho de uma árvore T.*/
public class C828 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.right(tree.root()), "E");
        tree.addRight(tree.left(tree.root()), "F");


        System.out.println("path length: " + tree.pathLength(tree.root()));
        System.out.println("path length internal: " + tree.pathLengthInternal(tree.root()));
        System.out.println("path length external: " + tree.pathLengthExternal(tree.root()));
        //System.out.println("depth: " + tree.depth(tree.left(tree.root())));
    }
}
