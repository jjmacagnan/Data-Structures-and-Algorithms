package chapter_8.exercises.creativity;

/*C-8.46 Describe, in pseudocode, a nonrecursive method for performing an inorder traversal of a binary tree in linear time.*/

/*Descreva um método não recursivo para realizar uma passagem inorder de uma árvore binária em tempo linear.*/

import chapter_7.code.positional_list.Position;
import chapter_8.code.LinkedBinaryTree;

public class C846<E> {

    public static void main(String[] args) {
        C846 c846 = new C846();
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");

        c846.imprimeInorder(tree);
        System.out.println();
        tree.inorderOn();
    }

    public void imprimeInorder(LinkedBinaryTree<E> tree) {
        for (Position<E> c : tree.inorder()) {
            System.out.print(c.getElement() + " ");
        }
    }
}
