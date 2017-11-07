package chapter_8.exercises.creativity;

/*C-8.40 Describe how to clone a LinkedBinaryTree instance representing a (not necessarily proper) binary tree,
with use of the addLeft and addRight methods.*/

/*C-8.40 Descreva como clonar uma instância LinkedBinaryTree representando uma árvore binária (não necessariamente apropriada),
com o uso dos métodos addLeft e addRight.*/

import chapter_8.code.LinkedBinaryTree;

public class C840 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();
        LinkedBinaryTree clone;

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");

        clone = tree.clone1();

        System.out.println(clone.size());





    }
}
