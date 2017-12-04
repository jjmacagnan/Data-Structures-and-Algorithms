package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;
import chapter_11.code.TreeMap;
import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
/*C-11.42 In our AVL implementation, each node stores the height of its subtree, which is
an arbitrarily large integer. The space usage for an AVL tree can be reduced by
instead storing the balance factor of a node, which is defined as the height of its
left subtree minus the height of its right subtree. Thus, the balance factor of a
node is always equal to −1, 0, or 1, except during an insertion or removal, when
it may become temporarily equal to −2 or +2. Reimplement the AVLTreeMap
class storing balance factors rather than subtree heights.*/

public class C1142_AVLTreeMap<K, V> extends TreeMap<K, V> {

    public C1142_AVLTreeMap() {
        super();
    }

    public C1142_AVLTreeMap(Comparator<K> comp) {
        super(comp);
    }

    protected int height(Position<Entry<K, V>> p) {
        return tree.getAux(p);
    }

    protected void recomputeHeight(Position<Entry<K, V>> p) {
        tree.setAux(p, 1 + Math.max(height(tree.left(p)), height(tree.right(p))));
    }

    protected boolean isBalanced(Position<Entry<K, V>> p) {
        return Math.abs(height(tree.left(p)) - height(tree.right(p))) <= 1;
    }

    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        if (height(tree.left(p)) > height(tree.right(p)))
            return tree.left(p); // clear winner
        if (height(tree.left(p)) < height(tree.right(p)))
            return tree.right(p); // clear winner
        // equal height children; break tie while matching parent's orientation
        if (tree.isRoot(p))
            return tree.left(p); // choice is irrelevant
        if (p == tree.left(tree.parent(p)))
            return tree.left(p); // return aligned child
        else return tree.right(p);
    }

    protected void rebalance(Position<Entry<K, V>> p) {
        int oldHeight, newHeight;
        do {
            oldHeight = height(p); // not yet recalculated if internal
            if (!isBalanced(p)) { // imbalance detected
                // perform trinode restructuring, setting p to resulting root,
                // and recompute new local heights after the restructuring
                p = tree.restructure(tallerChild(tallerChild(p)));
                recomputeHeight(tree.left(p));
                recomputeHeight(tree.right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = tree.parent(p);
        } while (oldHeight != newHeight && p != null);
    }

    @Override
    public int countRange(K k1, K k2) {
        return super.countRange(k1, k2);
    }

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!tree.isRoot(p))
            rebalance(tree.parent(p));
    }

    public static void main(String[] args) {
        AVLTreeMap treeMap = new AVLTreeMap();

        treeMap.put(4, "a");
        treeMap.put(2, "b");
        treeMap.put(5, "c");
        treeMap.put(6, "d");
        treeMap.put(1, "e");

        int j = treeMap.countRange(1, 5);

        System.out.println(treeMap.toString());
        System.out.println(j);

    }
}
