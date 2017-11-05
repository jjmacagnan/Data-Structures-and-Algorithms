package chapter_8.exercises.creativity;

/*C-8.39 Describe how to clone a LinkedBinaryTree instance representing a proper binary
tree, with use of the attach method.*/

/*Descreva como clonar uma instância LinkedBinaryTree representando uma árvore binária própria, com o uso do método de attach.*/

import chapter_8.code.LinkedBinaryTree;

public class C839 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();
        LinkedBinaryTree treeClone  = new LinkedBinaryTree();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");


        treeClone.addRoot(tree.root().getElement());



    }
}
