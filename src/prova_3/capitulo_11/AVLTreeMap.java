package prova_3.capitulo_11;

import prova_2.capitulo_7.positional_list.Position;
import prova_2.capitulo_9.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class AVLTreeMap<K, V> extends TreeMap<K, V> {

    public AVLTreeMap() {
        super();
    }

    public AVLTreeMap(Comparator<K> comp) {
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

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!tree.isRoot(p))
            rebalance(tree.parent(p));
    }
}
