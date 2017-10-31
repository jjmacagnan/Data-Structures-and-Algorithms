package chapter_8.exercises.creativity;

/*Define the internal path length, I(T ), of a tree T to be the sum of the depths of all the internal positions in T .
Likewise, define the external path length, E(T ), of a tree T to be the sum of the depths of all the external positions in T .
Show that if T is a proper binary tree with n positions, then E(T ) = I(T)+ n − 1.*/

/*Defina o comprimento do caminho interno, I (T), de uma árvore T para ser a soma das profundidades de todas as posições internas em T.
Da mesma forma, defina o comprimento do caminho externo, E (T), de uma árvore T para ser a soma das profundidades de todas as posições externas em T.
Mostre que se T for uma árvore binária apropriada com n posições, então E (T) = I (T) + n - 1.*/

import chapter_8.code.LinkedBinaryTree;

public class C829 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.left(tree.root()), "D");
//        tree.addRight(tree.right(tree.root()), "E");
        tree.addRight(tree.left(tree.root()), "F");
//        tree.addRight(tree.right(tree.left(tree.root())), "G");
//        tree.addLeft(tree.left(tree.left(tree.root())), "H");


        System.out.println("path length: " + tree.pathLength(tree.root()));
        System.out.println("path length internal: " + tree.pathLengthInternal(tree.root()));
        System.out.println("path length external: " + tree.pathLengthExternal(tree.root()));
        //System.out.println("depth: " + tree.depth(tree.left(tree.root())));


        System.out.println("E (T) = I (T) + n - 1: " + (tree.pathLengthInternal(tree.root()) + tree.size() - 1));
    }

}
