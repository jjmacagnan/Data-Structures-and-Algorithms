package chapter_11.code;

import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class SplayTreeMap<K, V> extends TreeMap<K, V> {

    public SplayTreeMap() {
        super();
    }

    public SplayTreeMap(Comparator<K> comp) {
        super(comp);
    }

    /** Utility used to rebalance after a map operation. */
    private void splay(Position<Entry<K,V>> p) {
        while (!isRoot(p)) {
            Position<Entry<K,V>> parent = parent(p);
            Position<Entry<K,V>> grand = parent(parent);
            if (grand == null)                                          // zig case
                rotate(p);
            else if ((parent == left(grand)) == (p == left(parent))) {  // zig-zig case
                rotate(parent);      // move PARENT upward
                rotate(p);           // then move p upward
            } else {                                                    // zig-zag case
                rotate(p);           // move p upward
                rotate(p);           // move p upward again
            }
        }
    }

    @Override
    protected void rebalanceAccess(Position<Entry<K,V>> p) {
        if (isExternal(p)) p = parent(p);
        if (p != null) splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        splay(p);
    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if (!isRoot(p)) splay(parent(p));
    }
}
