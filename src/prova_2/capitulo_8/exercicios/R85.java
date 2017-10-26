package prova_2.capitulo_8.exercicios;

import prova_2.capitulo_8.LinkedBinaryTree;

/*R-8.5 Descreva um algoritmo, confiando apenas nas operações BinaryTree, que conta o número de folhas em uma árvore binária que é o filho esquerdo de seus respectivos pais.*/
public class R85<E> {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addLeft(tree.right(tree.root()), "F");
        tree.addLeft(tree.left(tree.right(tree.root())), "G");
        tree.addRight(tree.left(tree.right(tree.root())), "H");
        tree.addLeft(tree.right(tree.left(tree.right(tree.root()))), "I");

        System.out.println("Numero de folhas a esquerda: " + tree.countLeftLeaves(tree.root()));





    }
}
