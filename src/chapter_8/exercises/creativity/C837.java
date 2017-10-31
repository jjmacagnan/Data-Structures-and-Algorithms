package chapter_8.exercises.creativity;

/*C-8.37 Add support in LinkedBinaryTree for a method, swap(p, q), that has the effect of
restructuring the tree so that the node referenced by p takes the place of the node
referenced by q, and vice versa. Make sure to properly handle the case when the
nodes are adjacent.*/

/*C-8.37 Adicione suporte em LinkedBinaryTree para um método, swap (p, q),
que tenha o efeito de reestruturar a árvore para que o nó referenciado por p ocupe o lugar do nó referenciado por q e vice-versa.
Certifique-se de lidar adequadamente com o caso quando os nós são adjacentes.*/

import chapter_8.code.LinkedBinaryTree;

public class C837 {

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree<>();

        tree.addRoot("A");
        tree.addLeft(tree.root(), "B");
        tree.addRight(tree.root(), "C");
        tree.addLeft(tree.right(tree.root()), "E");
        tree.addLeft(tree.left(tree.root()), "D");
        tree.addRight(tree.left(tree.root()), "F");

        tree.swap(tree.root(), tree.right(tree.root()));

    }


}
