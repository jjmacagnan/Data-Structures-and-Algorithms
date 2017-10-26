package capitulo_11;

import capitulo_7.positional_list.Position;
import capitulo_9.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class RBTreeMap<K, V> extends TreeMap<K, V> {

    public RBTreeMap() {
        super();
    }

    public RBTreeMap(Comparator<K> comp) {
        super(comp);
    }

    private boolean isBlack(Position<Entry<K, V>> p) {
        return tree.getAux(p) == 0;
    }

    private boolean isRed(Position<Entry<K, V>> p) {
        return tree.getAux(p) == 1;
    }

    private void makeBlack(Position<Entry<K, V>> p) {
        tree.setAux(p, 0);
    }

    private void makeRed(Position<Entry<K, V>> p) {
        tree.setAux(p, 1);
    }

    private void setColor(Position<Entry<K, V>> p, boolean toRed) {
        tree.setAux(p, toRed ? 1 : 0);
    }

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        if (tree.isRoot(p)) {
            makeRed(p);
            resolveRed(p);
        }
    }

    private void resolveRed(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> parent, uncle, middle, grand; // used in case analysis
        parent = tree.parent(p);
        if (isRed(parent)) { // double-red problem exists
            uncle = tree.sibling(parent);
            if (isBlack(uncle)) { // Case 1: misshapen 4-node
                middle = tree.restructure(p); // do trinode restructuring
                makeBlack(middle);
                makeRed(tree.left(middle));
                makeRed(tree.right(middle));
            } else { // Case 2: overfull 5-node
                makeBlack(parent); // perform recoloring
                makeBlack(uncle);
                grand = tree.parent(parent);
                if (!tree.isRoot(grand)) {
                    makeRed(grand); // grandparent becomes red
                    resolveRed(grand); // recur at red grandparent
                }
            }
        }
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (isRed(p)) // deleted parent was black
            makeBlack(p); // so this restores black depth
        else if (!tree.isRoot(p)) {
            Position<Entry<K, V>> sib = tree.sibling(p);
            if (tree.isInternal(sib) && (isBlack(sib) || tree.isInternal(tree.left(sib))))
                remedyDoubleBlack(p); // sib's subtree has nonzero black height
        }
    }

    private void remedyDoubleBlack(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> z = tree.parent(p);
        Position<Entry<K, V>> y = tree.sibling(p);
        if (isBlack(y)) {
            if (isRed(tree.left(y)) || isRed(tree.right(y))) { // Case 1: trinode restructuring
                Position<Entry<K, V>> x = (isRed(tree.left(y)) ? tree.left(y) : tree.right(y));
                Position<Entry<K, V>> middle = tree.restructure(x);
                setColor(middle, isRed(z)); // root of restructured subtree gets z's old color
                makeBlack(tree.left(middle));
                makeBlack(tree.right(middle));
            } else { // Case 2: recoloring
                makeRed(y);
                if (isRed(z))
                    makeBlack(z); // problem is resolved
                else if (!tree.isRoot(z))
                    remedyDoubleBlack(z); // propagate the problem
            }
        } else { // Case 3: reorient 3-node
            tree.rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p); // restart the process at p
        }
    }
}

