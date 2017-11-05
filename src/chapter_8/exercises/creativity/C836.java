package chapter_8.exercises.creativity;

/*C-8.36 Add support in LinkedBinaryTree for a method, pruneSubtree(p), that removes
the entire subtree rooted at position p, making sure to maintain an accurate count
of the size of the tree. What is the running time of your implementation?*/

/* Adicione um métoda na LinkedBinaryTree chamado pruneSubTree(p) que remove a subtree inteira a partir da position p.
Certifique-se de manter a contagem do size da tree. Em qual tempo o algoritmo roda?
 */

import chapter_8.code.LinkedBinaryTree;

public class C836 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");

        tree.pruneSubtree(tree.left(tree.root()));

    }
}
