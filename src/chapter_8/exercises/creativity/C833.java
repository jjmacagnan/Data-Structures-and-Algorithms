package chapter_8.exercises.creativity;

/*C-8.33 Two ordered trees T ′ and T ′′ are said to be isomorphic if one of the following
holds:
• Both T ′ and T ′′ are empty.
• Both T ′ and T ′′ consist of a single node
• The roots of T ′ and T ′′ have the same number k ≥ 1 of subtrees, and the
i th such subtree of T ′ is isomorphic to the i th such subtree of T ′′ for i =
1,...,k.
Design an algorithm that tests whether two given ordered trees are isomorphic.
What is the running time of your algorithm?*/

import chapter_8.code.LinkedBinaryTree;

/*Duas árvores ordenadas T' e T''são ditas isomorficas se uma das seguintes afirmações:
• Tanto T' quanto T'' estão vazios.
• Tanto T' como T'' consistem em um único nó
• As raízes de T' e T'' têm o mesmo número k ≥ 1 de subtrees, e a i tal sub-árvore de T' é isomórfica para a i tal sub-árvore de T '' para i = 1, ..., k.
Crie um algoritmo que teste se duas árvores ordenadas são isomórficas. Qual é o tempo de execução do seu algoritmo?*/
public class C833 {

    public static void main(String[] args) {
        LinkedBinaryTree tree1 = new LinkedBinaryTree<>();
        LinkedBinaryTree tree2 = new LinkedBinaryTree<>();

        tree1.addRoot("A");
        tree2.addRoot("A");
        tree1.addLeft(tree1.root(), "B");
//        tree2.addRight(tree2.root(), "B");
//        tree.addRight(tree.root(), "C");
//        tree.addLeft(tree.left(tree.root()), "D");
//        tree.addRight(tree.right(tree.root()), "E");
//        tree.addRight(tree.left(tree.root()), "F");
//        tree.addRight(tree.right(tree.left(tree.root())), "G");
//        tree.addLeft(tree.left(tree.left(tree.root())), "H");


        System.out.println(tree1.isIsomorphic(tree1.root(), tree2.root()));


    }


}
