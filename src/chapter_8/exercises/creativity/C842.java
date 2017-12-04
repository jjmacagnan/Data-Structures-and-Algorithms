package chapter_8.exercises.creativity;

import chapter_8.code.LinkedBinaryTree;

/*C-8.42 Give an efficient algorithm that computes and prints, for every position p of a tree T , the element of p followed by the balanceFactor of p’s subtree.*/

/*C-8.42 Dê um algoritmo eficiente que calcula e imprime, para cada posição p de uma árvore T, o elemento de p seguido pela altura da sub-árvore do p.*/

public class C842 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");


        tree.printElementAndHeightPosition(tree.root());

    }
}
