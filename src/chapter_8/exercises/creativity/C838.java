package chapter_8.exercises.creativity;

/*C-8.38 We can simplify parts of our LinkedBinaryTree implementation if we make use
of of a single sentinel node, such that the sentinel is the parent of the real root of
the tree, and the root is referenced as the left child of the sentinel. Furthermore,
the sentinel will take the place of null as the value of the left or right member for
a node without such a child. Give a new implementation of the update methods
remove and attach, assuming such a representation.*/

/*Podemos simplificar partes de nossa implementação LinkedBinaryTree se fizermos uso de um único nó sentinela,
de modo que a sentinela seja o pai da raiz real da árvore e a raiz é referenciada como o filho esquerdo da sentinela.
Além disso, o sentinela ocupará o lugar nulo como o valor do membro esquerdo ou direito para um nó sem essa criança.
Dê uma nova implementação dos métodos de atualização remover e anexar, assumindo tal representação*/

import chapter_8.code.LinkedBinaryTree;
import chapter_8.code.LinkedBinaryTreeNodeSentinel;

public class C838 {

    public static void main(String[] args) {
        LinkedBinaryTreeNodeSentinel tree = new LinkedBinaryTreeNodeSentinel();
        LinkedBinaryTreeNodeSentinel tree1 = new LinkedBinaryTreeNodeSentinel();
        LinkedBinaryTreeNodeSentinel tree2 = new LinkedBinaryTreeNodeSentinel();

        tree.addRoot(1);

        tree1.addRoot("A");
        tree1.addLeft(tree1.root(), "B");
        tree1.addRight(tree1.root(), "C");
        tree1.addLeft(tree1.left(tree1.root()), "D");

        tree2.addRoot("E");
        tree2.addLeft(tree2.root(), "D");
        tree2.addRight(tree2.root(), "F");

        tree.attach(tree.root(), tree1, tree2);


    }
}
