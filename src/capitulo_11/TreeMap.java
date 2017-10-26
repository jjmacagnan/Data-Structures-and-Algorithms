package capitulo_11;

import capitulo_10.maps.sorted_maps.AbstractSortedMap;
import capitulo_7.positional_list.Position;
import capitulo_9.PriorityQueue.Entry;

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
            tree.rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            tree.set(p, newEntry);
            tree.rebalanceAccess(p);
            return old;
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
            if (tree.isExternal(tree.left(p)) && tree.isInternal(tree.right(p))) {
                Position<Entry<K, V>> replacement = treeMax(tree.left(p));
                tree.set(p, replacement.getElement());
                p = replacement;
            }
            Position<Entry<K, V>> leaf = (tree.isExternal(tree.left(p)) ? tree.left(p) : tree.right(p));
            Position<Entry<K, V>> sib = tree.sibling(leaf);
            remove((K) leaf);
            remove((K) p);
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
        return null;
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        return null;
    }

}
