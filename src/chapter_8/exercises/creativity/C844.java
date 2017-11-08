package chapter_8.exercises.creativity;

import chapter_8.code.LinkedBinaryTree;


/*C-8.44 The balance factor of an internal position p of a proper binary tree is the difference between the heights
of the right and left subtrees of p. Show how to specialize the Euler tour traversal of Section 8.4.6 to print the balance factors of
all the internal nodes of a proper binary tree.*/

/*C-8.44 O fator de equilíbrio de uma posição interna p de uma árvore binária adequada
é a diferença entre as alturas das subveres direita e esquerda de p. Mostre como especializar
o percurso de Euler da Seção 8.4.6 para imprimir os fatores de equilíbrio de todos os nós internos
de uma árvore binária adequada.*/

public class C844 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");

        tree.balanceFactor(tree.root());

        tree.balanceFactorGabriel(tree.root());

    }
}
