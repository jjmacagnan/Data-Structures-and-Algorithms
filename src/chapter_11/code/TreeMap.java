package chapter_11.code;

import chapter_10.code.maps.sorted_maps.AbstractSortedMap;
import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;
import chapter_9.code.PriorityQueue.DefaultComparator;
import chapter_9.code.PriorityQueue.Entry;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * Created by jjmacagnan on 25/06/2017.
 */
public class TreeMap<K, V> extends AbstractSortedMap<K, V> {

    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);
    }

    @Override
    public int size() {
        return (tree.size() - 1 / 2);
    }

    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    public Position<Entry<K, V>> root() {
        return tree.root();
    }
    protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p) { return tree.parent(p); }
    protected Position<Entry<K,V>> left(Position<Entry<K,V>> p) { return tree.left(p); }
    protected Position<Entry<K,V>> right(Position<Entry<K,V>> p) { return tree.right(p); }
    protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> p) { return tree.sibling(p); }
    protected boolean isRoot(Position<Entry<K,V>> p) { return tree.isRoot(p); }
    protected boolean isExternal(Position<Entry<K,V>> p) { return tree.isExternal(p); }
    protected boolean isInternal(Position<Entry<K,V>> p) { return tree.isInternal(p); }
    protected void set(Position<Entry<K,V>> p, Entry<K,V> e) { tree.set(p, e); }
    protected Entry<K,V> remove(Position<Entry<K,V>> p) { return tree.remove(p); }
    protected void rotate(Position<Entry<K,V>> p) { tree.rotate(p); }
    protected Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) { return tree.restructure(x); }

    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        if (tree.isExternal(p))
            return p;
        int comp = compare(key, p.getElement());
        if (comp == 0)
            return p;
        else if (comp < 0)
            return treeSearch(tree.left(p), key);
        else
            return treeSearch(tree.right(p), key);
    }

    public Position<Entry<K, V>> treeSearchIterative(Position<Entry<K, V>> p, K key) {
       while (!tree.isExternal(p)) {
            int comp = compare(key, p.getElement());
            if (comp == 0)
                return p;
            else if (comp < 0) {
                p  = tree.left(p);
            }
            else if  (comp > 0) {
                p = tree.right(p);
            }
        }
        return p;
    }

    @Override
    public V get(K key) {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        tree.rebalanceAccess(p);
        if (tree.isExternal(p))
            return null;
        return p.getElement().getValue();
    }

    @Override
    public V put(K key, V value) {
        checkKey(key);
        Entry<K, V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (tree.isExternal(p)) {
            expandExternal(p, newEntry);
            tree.rebalanceInsert(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            tree.set(p, newEntry);
            tree.rebalanceAccess(p);
            return old;
        }
    }

    public void putIfAbsent(K key, V value) {
        Position<Entry<K, V>> p = treeSearch(root(), key);

        if(p.getElement() == null) {
            Entry<K, V> newEntry = new MapEntry<>(key, value);
            expandExternal(p, newEntry);
            tree.rebalanceAccess(p);
        }
    }

    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (tree.isExternal(p)) {
            tree.rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            if (tree.isInternal(tree.left(p)) && tree.isInternal(tree.right(p))) {
                Position<Entry<K, V>> replacement = treeMax(tree.left(p));
                tree.set(p, replacement.getElement());
                p = replacement;
            }
            Position<Entry<K, V>> leaf = (tree.isExternal(tree.left(p)) ? tree.left(p) : tree.right(p));
            Position<Entry<K, V>> sib = tree.sibling(leaf);
            remove(leaf);
            remove(p);
            tree.rebalanceDelete(sib);
            return old;
        }
    }

    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> walk = p;
        while (tree.isInternal(walk))
            walk = tree.right(walk);
        return tree.parent(walk);
    }

    protected Position<Entry<K,V>> treeMin(Position<Entry<K,V>> p) {
        Position<Entry<K,V>> walk = p;
        while (isInternal(walk))
            walk = left(walk);
        return parent(walk);              // we want the parent of the leaf
    }

    @Override
    public Entry<K, V> lastEntry() {
        if (tree.isEmpty())
            return null;
        return treeMax(root()).getElement();
    }

    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (tree.isInternal(p))
            return p.getElement();
        while (!tree.isRoot(p)) {
            if (p == tree.right(tree.parent(p)))
                return (Entry<K, V>) tree.parent(p).getElement();
            else p = tree.parent(p);
        }
        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key); // may throw IllegalArgumentException
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (tree.isInternal(p) && tree.isInternal(tree.left(p)))
            return treeMax(tree.left(p)).getElement();
        while (!tree.isRoot(p)) {
            if (p == tree.right(tree.parent(p)))
                return (Entry<K, V>) tree.parent(p).getElement();
            else
                p = tree.parent(p);
        }
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        for (Position<Entry<K, V>> p : tree.inorder())
            if (tree.isInternal(p))
                buffer.add(p.getElement());

        return buffer;
    }

    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        if (compare(fromKey, toKey) < 0)
            subMapRecurse(fromKey, toKey, root(), buffer);
        return buffer;
    }

    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> p,
                               ArrayList<Entry<K, V>> buffer) {
        if (tree.isInternal(p)) {
            if (compare(p.getElement(), fromKey) < 0)
                subMapRecurse(fromKey, toKey, tree.right(p), buffer);
            else {
                subMapRecurse(fromKey, toKey, tree.left(p), buffer);
                if (compare(p.getElement(), toKey) < 0) {
                    buffer.add(p.getElement());
                    subMapRecurse(fromKey, toKey, tree.right(p), buffer); // right subtree as well
                }
            }
        }
    }

    @Override
    public Entry<K, V> firstEntry() {
        if (tree.isEmpty()) return null;
        return treeMin(root()).getElement();
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        checkKey(key);                              // may throw IllegalArgumentException
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isInternal(p)) return p.getElement();   // exact match
        while (!isRoot(p)) {
            if (p == left(parent(p)))
                return parent(p).getElement();          // parent has next greater key
            else
                p = parent(p);
        }
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        checkKey(key);                               // may throw IllegalArgumentException
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isInternal(p) && isInternal(right(p)))
            return treeMin(right(p)).getElement();     // this is the successor to p
        // otherwise, we had failed search, or match with no right child
        while (!isRoot(p)) {
            if (p == left(parent(p)))
                return parent(p).getElement();           // parent has next lesser key
            else
                p = parent(p);
        }
        return null;
    }

    public void removeSubMap(K k1, K k2) {

        Comparator<K> comp = new DefaultComparator<>();

        for (Entry<K,V> entry : subMap(k1, k2)) {
            if (comp.compare(entry.getKey(), k1) > 0  && comp.compare(entry.getKey(), k2) < 0 ) {
                remove(entry.getKey());
            }
        }
    }

    public int countRange(K k1, K k2) {
        Comparator<K> comp = new DefaultComparator<>();
        int i = 0;

        for (K entry : keySet()) {
            if (comp.compare(entry, k1) > 0  && comp.compare(entry, k2) < 0 ) {
               i++;
            }
        }

        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");

        for (Entry<K, V> entry : entrySet()) {
            sb.append(entry.getKey());
            sb.append("-");
            sb.append(entry.getValue());
            sb.append(", ");
        }

        sb.append(")");
        return sb.toString();
    }

}
