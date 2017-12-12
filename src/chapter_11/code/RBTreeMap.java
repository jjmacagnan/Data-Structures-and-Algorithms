package chapter_11.code;

import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class    RBTreeMap<K, V> extends TreeMap<K, V> {

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

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        if (!isRoot(p)) {
            makeRed(p);                   // the new internal node is initially colored red
            resolveRed(p);                // but this may cause a double-red problem
        }
    }

    /** Remedies potential double-red violation above red position p. */
    private void resolveRed(Position<Entry<K,V>> p) {
        Position<Entry<K,V>> parent,uncle,middle,grand; // used in case analysis
        parent = parent(p);
        if (isRed(parent)) {                              // double-red problem exists
            uncle = sibling(parent);
            if (isBlack(uncle)) {                           // Case 1: misshapen 4-node
                middle = restructure(p);                      // do trinode restructuring
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            } else {                                        // Case 2: overfull 5-node
                makeBlack(parent);                            // perform recoloring
                makeBlack(uncle);
                grand = parent(parent);
                if (!isRoot(grand)) {
                    makeRed(grand);                             // grandparent becomes red
                    resolveRed(grand);                          // recur at red grandparent
                }
            }
        }
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if (isRed(p))                        // deleted parent was black
            makeBlack(p);                      // so this restores black depth
        else if (!isRoot(p)) {
            Position<Entry<K,V>> sib = sibling(p);
            if (isInternal(sib) && (isBlack(sib) || isInternal(left(sib))))
                remedyDoubleBlack(p);            // sib's subtree has nonzero black balanceFactor
        }
    }

    /** Remedies a presumed double-black violation at the given (nonroot) position. */
    private void remedyDoubleBlack(Position<Entry<K,V>> p) {
        Position<Entry<K,V>> z = parent(p);
        Position<Entry<K,V>> y = sibling(p);
        if (isBlack(y)) {
            if (isRed(left(y)) || isRed(right(y))) { // Case 1: trinode restructuring
                Position<Entry<K,V>> x = (isRed(left(y)) ? left(y) : right(y));
                Position<Entry<K,V>> middle = restructure(x);
                setColor(middle, isRed(z)); // root of restructured subtree gets z's old color
                makeBlack(left(middle));
                makeBlack(right(middle));
            } else {                           // Case 2: recoloring
                makeRed(y);
                if (isRed(z))
                    makeBlack(z);                  // problem is resolved
                else if (!isRoot(z))
                    remedyDoubleBlack(z);          // propagate the problem
            }
        } else {                             // Case 3: reorient 3-node
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p);              // restart the process at p
        }
    }

    /** Ensure that current tree structure is valid RB tree (for debugging only)*/
    private boolean sanityCheck() {
        if (sanityRecurse(root()) == -1) {
            System.out.println("VIOLATION of RB tree properties");
            dump();
            return false;
        } else
            return true;
    }

    /** Returns black depth of subtree, if valid, or -1 if invalid. */
    private int sanityRecurse(Position<Entry<K,V>> p) {
        if (isExternal(p)) {
            if (isRed(p)) return -1;      // invalid; should be black
            else return 0;                // valid, with black-depth 0
        } else {
            if (isRoot(p) && isRed(p)) return -1;    // root must be black
            Position<Entry<K,V>> left = left(p);
            Position<Entry<K,V>> right = right(p);
            if (isRed(p) && (isRed(left) || isRed(right))) return -1;   // cannot have double red

            int a = sanityRecurse(left);
            if (a == -1) return -1;
            int b = sanityRecurse(right);
            if (a != b) return -1;          // two subtrees must have identical black depth

            return a + (isRed(p) ? 0 : 1);   // our black depth might be one greater
        }
    }

    public void separate(K key, RBTreeMap rbLess, RBTreeMap rbGreater, Position<Entry<K,V>> p) {

        if(this.isRoot(p)){
            separate(key, rbLess, rbGreater,right(p));
            separate(key, rbLess, rbGreater,left(p));
        }else {

            if (p.getElement() != null && p != null) {
                if (p == left(parent(p))) {
                    separate(key, rbLess, rbGreater, left(p));
                }


                if (compare(p.getElement().getKey(), key) < 0) {
                    rbLess.put(p.getElement().getKey(), p.getElement().getValue());
                } else if (compare(p.getElement().getKey(), key) > 0) {
                    rbGreater.put(p.getElement().getKey(), p.getElement().getValue());
                }

                if (p == right(parent(p))) {
                    separate(key, rbLess, rbGreater, right(p));
                }
            }
        }

    }
}

