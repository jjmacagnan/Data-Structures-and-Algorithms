package chapter_11.exercises.creativity;

import chapter_11.code.TreeMap;
import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

        /*
         * Created by jjmacagnan on 25/06/2017.
         */
/*C-11.42 In our AVL implementation, each node stores the balanceFactor of its subtree, which is
an arbitrarily large integer. The space usage for an AVL tree can be reduced by
instead storing the balance factor of a node, which is defined as the balanceFactor of its
left subtree minus the balanceFactor of its right subtree. Thus, the balance factor of a
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

    protected int balanceFactor(Position<Entry<K, V>> p) {
        return tree.getAux(p);
    }

    protected void recomputeBalanceFactor(Position<Entry<K, V>> p) {
        int hLeft = tree.height(left(p));
        int hRight = tree.height(right(p));
        int balanceFactor = hLeft - hRight;
        tree.setAux(p, balanceFactor);
    }

    protected boolean isBalanced(Position<Entry<K, V>> p) {
        return balanceFactor(p) <= 1 && balanceFactor(p) >= -1;
    }

    /**
     * Returns a child of p with balanceFactor no smaller than that of the other child.
     */
    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        if (balanceFactor(left(p)) > balanceFactor(right(p)))
            return left(p);     // clear winner
        if (balanceFactor(left(p)) < balanceFactor(right(p)))
            return right(p);    // clear winner
        // equal balanceFactor children; break tie while matching parent's orientation
        if (isRoot(p))
            return left(p);                 // choice is irrelevant
        if (p == left(parent(p)))
            return left(p);      // return aligned child
        else return right(p);
    }

    /**
     * Utility used to rebalance after an insert or removal operation. This traverses the
     * path upward from p, performing a trinode restructuring when imbalance is found,
     * continuing until balance is restored.
     */
    protected void rebalance(Position<Entry<K, V>> p) {
        int oldBalanceFactor, newBalanceFactor = 0;
        do {
            oldBalanceFactor = balanceFactor(p);                       // not yet recalculated if internal
            if (!isBalanced(p)) {                        // imbalance detected
                // perform trinode restructuring, setting p to resulting root,
                // and recompute new local heights after the restructuring
                p = restructure(tallerChild(tallerChild(p)));
                recomputeBalanceFactor(left(p));
                recomputeBalanceFactor(right(p));
            }

            p = parent(p);
            if (p != null) {
                recomputeBalanceFactor(p);
                newBalanceFactor = balanceFactor(p);
            }
        } while (oldBalanceFactor != newBalanceFactor && p != null);
    }

    @Override
    public int countRange(K k1, K k2) {
        return super.countRange(k1, k2);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after an insertion.
     */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after a deletion.
     */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p))
            rebalance(parent(p));
    }

    public static void main(String[] args) {
        C1142_AVLTreeMap treeMap = new C1142_AVLTreeMap();

        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.put(4, "d");
        treeMap.put(5, "e");
        treeMap.toString(treeMap.root());
        treeMap.put(0, "f");

        treeMap.toString(treeMap.root());

    }
}
