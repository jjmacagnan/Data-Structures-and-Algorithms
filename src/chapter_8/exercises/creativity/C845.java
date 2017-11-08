package chapter_8.exercises.creativity;

/* Design algorithms for the following operations for a binary tree T :
• preorderNext(p): Return the position visited after p in a preorder traversal of T (or null if p is the last node visited).
• inorderNext(p): Return the position visited after p in an inorder traversal of T (or null if p is the last node visited).
• postorderNext(p): Return the position visited after p in a postorder traversal of T (or null if p is the last node visited).

What are the worst-case running times of your algorithms?*/

/*Projetar algoritmos para as seguintes operações para uma árvore binária T:
• preorderNext (p): Retorne a posição visitada após p em uma travessia de pré-ordenação de T (ou nulo se p é o último nó visitado).
• inorderNext (p): Retorne a posição visitada após p em uma travessia de entrada de T (ou nulo se p é o último nó visitado).
• postorderNext (p): Retorne a posição visitada após p em uma passagem posterior de T (ou nulo se p é o último nó visitado).

Quais são os piores momentos de execução de seus algoritmos?*/

import chapter_8.code.LinkedBinaryTree;

public class C845 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");

        System.out.println("preorder next");
        System.out.println("preorder next A: " + tree.preorderNext(tree.root()).getElement());
        System.out.println("preorder next B: " + tree.preorderNext(tree.left(tree.root())).getElement());
        System.out.println("preorder next C: " + tree.preorderNext(tree.right(tree.root())).getElement());
        System.out.println("preorder next D: " + tree.preorderNext(tree.left(tree.left(tree.root()))).getElement());
        System.out.println("preorder next E: " + tree.preorderNext(tree.left(tree.right(tree.root()))).getElement());
        System.out.println("preorder next F: " + tree.preorderNext(tree.right(tree.left(tree.root()))).getElement());
        try {
            System.out.println("preorder next G: " + tree.preorderNext(tree.left(tree.left(tree.right(tree.root())))).getElement());
        } catch (NullPointerException e) {
            System.out.println("null, pois é o ultimo elemento da preorder");
        }

        System.out.println("inorder next");
        System.out.println("inorder next A: " + tree.inorderNext(tree.root()).getElement());
        System.out.println("inorder next B: " + tree.inorderNext(tree.left(tree.root())).getElement());
        System.out.println("inorder next D: " + tree.inorderNext(tree.left(tree.left(tree.root()))).getElement());
        System.out.println("inorder next E: " + tree.inorderNext(tree.left(tree.right(tree.root()))).getElement());
        System.out.println("inorder next F: " + tree.inorderNext(tree.right(tree.left(tree.root()))).getElement());
        System.out.println("inorder next G: " + tree.inorderNext(tree.left(tree.left(tree.right(tree.root())))).getElement());
        try {
            System.out.println("inorder next C: " + tree.inorderNext(tree.right(tree.root())).getElement());
        } catch (NullPointerException e) {
            System.out.println("null, pois é o ultimo elemento da inorder");
        }

        System.out.println("postorder next");
        System.out.println("postorder next B: " + tree.postorderNext(tree.left(tree.root())).getElement());
        System.out.println("postorder next C: " + tree.postorderNext(tree.right(tree.root())).getElement());
        System.out.println("postorder next D: " + tree.postorderNext(tree.left(tree.left(tree.root()))).getElement());
        System.out.println("postorder next E: " + tree.postorderNext(tree.left(tree.right(tree.root()))).getElement());
        System.out.println("postorder next F: " + tree.postorderNext(tree.right(tree.left(tree.root()))).getElement());
        System.out.println("postorder next G: " + tree.postorderNext(tree.left(tree.left(tree.right(tree.root())))).getElement());
        try {
            System.out.println("postorder next A: " + tree.postorderNext(tree.root()).getElement());
        } catch (NullPointerException e) {
            System.out.println("null, pois é o ultimo elemento da postorder");
        }



        //System.out.println("preorder next p: " + tree.preorderNext(tree.left(tree.left(tree.right(tree.root())))).getElement());
        //System.out.println("inorder next p: " + tree.inorderNext(tree.left(tree.left(tree.root()))).getElement());




    }
}
