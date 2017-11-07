package chapter_8.exercises.creativity;

import chapter_8.code.LinkedBinaryTree;

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
