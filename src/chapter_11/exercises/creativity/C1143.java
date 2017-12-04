package chapter_11.exercises.creativity;
import chapter_10.code.maps.sorted_maps.AbstractSortedMap;
import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;
import chapter_8.code.LinkedBinaryTree;
import chapter_9.code.PriorityQueue.DefaultComparator;
import chapter_9.code.PriorityQueue.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*

C-11.43 If we maintain a reference to the position of the leftmost node of a binary search
tree, then operation firstEntry can be performed in O(1) time. Describe how
the implementation of the other map methods need to be modified to maintain a
reference to the leftmost position.
 */
public class C1143<K,V> extends AbstractSortedMap<K, V> {

        protected static class BalanceableBinaryTree<K, V>
                extends LinkedBinaryTree<Entry<K, V>> {
            //-------------- nested BSTNode class --------------
            // this extends the inherited LinkedBinaryTree.Node class
            protected static class BSTNode<E> extends Node<E> {
                int aux = 0;

                BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
                    super(e, parent, leftChild, rightChild);
                }

                public int getAux() {
                    return aux;
                }

                public void setAux(int value) {
                    aux = value;
                }
            } //--------- end of nested BSTNode class ---------

            // positional-based methods related to aux field
            public int getAux(Position<Entry<K, V>> p) {
                return ((BSTNode<Entry<K, V>>) p).getAux();
            }

            public void setAux(Position<Entry<K, V>> p, int value) {
                ((BSTNode<Entry<K, V>>) p).setAux(value);
            }

            // Override node factory function to produce a BSTNode (rather than a Node)
            @Override
            protected Node<Entry<K, V>> createNode(Entry<K, V> e, Node<Entry<K, V>> parent,
                                                   Node<Entry<K, V>> left, Node<Entry<K, V>> right) {
                return new BSTNode<>(e, parent, left, right);
            }

            /**
             * Relinks a parent node with its oriented child node.
             */
            private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child,
                                boolean makeLeftChild) {
                child.setParent(parent);
                if (makeLeftChild)
                    parent.setLeft(child);
                else
                    parent.setRight(child);
            }

            /**
             * Rotates Position p above its parent.  Switches between these
             * configurations, depending on whether p is a or p is b.
             * <pre>
             *          b                  a
             *         / \                / \
             *        a  t2             t0   b
             *       / \                    / \
             *      t0  t1                 t1  t2
             * </pre>
             * Caller should ensure that p is not the root.
             */
            public void rotate(Position<Entry<K, V>> p) {
                Node<Entry<K, V>> x = validate(p);
                Node<Entry<K, V>> y = x.getParent();        // we assume this exists
                Node<Entry<K, V>> z = y.getParent();        // grandparent (possibly null)
                if (z == null) {
                    root = x;                                // x becomes root of the tree
                    x.setParent(null);
                } else
                    relink(z, x, y == z.getLeft());          // x becomes direct child of z
                // now rotate x and y, including transfer of middle subtree
                if (x == y.getLeft()) {
                    relink(y, x.getRight(), true);           // x's right child becomes y's left
                    relink(x, y, false);                     // y becomes x's right child
                } else {
                    relink(y, x.getLeft(), false);           // x's left child becomes y's right
                    relink(x, y, true);                      // y becomes left child of x
                }
            }

            /**
             * Returns the Position that becomes the root of the restructured subtree.
             * <p>
             * Assumes the nodes are in one of the following configurations:
             * <pre>
             *     z=a                 z=c           z=a               z=c
             *    /  \                /  \          /  \              /  \
             *   t0  y=b             y=b  t3       t0   y=c          y=a  t3
             *      /  \            /  \               /  \         /  \
             *     t1  x=c         x=a  t2            x=b  t3      t0   x=b
             *        /  \        /  \               /  \              /  \
             *       t2  t3      t0  t1             t1  t2            t1  t2
             * </pre>
             * The subtree will be restructured so that the node with key b becomes its root.
             * <pre>
             *           b
             *         /   \
             *       a       c
             *      / \     / \
             *     t0  t1  t2  t3
             * </pre>
             * Caller should ensure that x has a grandparent.
             */
            public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
                Position<Entry<K, V>> y = parent(x);
                Position<Entry<K, V>> z = parent(y);
                if ((x == right(y)) == (y == right(z))) {   // matching alignments
                    rotate(y);                                // single rotation (of y)
                    return y;                                 // y is new subtree root
                } else {                                    // opposite alignments
                    rotate(x);                                // double rotation (of x)
                    rotate(x);
                    return x;                                 // x is new subtree root
                }
            }
        } //----------- end of nested BalanceableBinaryTree class -----------

        protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

        public C1143() {
            super();
            tree.addRoot(null);
        }

        public C1143(Comparator<K> comp) {
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

        protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
            return tree.parent(p);
        }

        protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
            return tree.left(p);
        }

        protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
            return tree.right(p);
        }

        protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
            return tree.sibling(p);
        }

        protected boolean isRoot(Position<Entry<K, V>> p) {
            return tree.isRoot(p);
        }

        protected boolean isExternal(Position<Entry<K, V>> p) {
            return tree.isExternal(p);
        }

        protected boolean isInternal(Position<Entry<K, V>> p) {
            return tree.isInternal(p);
        }

        protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
            tree.set(p, e);
        }

        protected Entry<K, V> remove(Position<Entry<K, V>> p) {
            return tree.remove(p);
        }

        protected void rotate(Position<Entry<K, V>> p) {
            tree.rotate(p);
        }

        protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
            return tree.restructure(x);
        }

        private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
            if (isExternal(p))
                return p;                          // key not found; return the final leaf
            int comp = compare(key, p.getElement());
            if (comp == 0)
                return p;                          // key found; return its position
            else if (comp < 0)
                return treeSearch(left(p), key);   // search left subtree
            else
                return treeSearch(right(p), key);  // search right subtree
        }

        public Position<Entry<K, V>> treeSearchIterative(Position<Entry<K, V>> p, K key) {
            while (!isExternal(p)) {
                int comp = compare(key, p.getElement());
                if (comp == 0)
                    return p;
                else if (comp < 0) {
                    p = left(p);
                } else if (comp > 0) {
                    p = right(p);
                }
            }
            return p;
        }

        protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
            Position<Entry<K, V>> walk = p;
            while (tree.isInternal(walk))
                walk = tree.right(walk);
            return tree.parent(walk);
        }

        protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
            Position<Entry<K, V>> walk = p;
            while (isInternal(walk))
                walk = left(walk);
            return parent(walk);              // we want the parent of the leaf
        }

        @Override
        public V get(K key) throws IllegalArgumentException {
            checkKey(key);                          // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            rebalanceAccess(p);                     // hook for balanced tree subclasses
            if (isExternal(p)) return null;         // unsuccessful search
            return p.getElement().getValue();       // match found
        }

        @Override
        public V put(K key, V value) throws IllegalArgumentException {
            checkKey(key);                          // may throw IllegalArgumentException
            Entry<K, V> newEntry = new MapEntry<>(key, value);
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isExternal(p)) {                    // key is new
                expandExternal(p, newEntry);
                rebalanceInsert(p);                   // hook for balanced tree subclasses
                return null;
            } else {                                // replacing existing key
                V old = p.getElement().getValue();
                set(p, newEntry);
                rebalanceAccess(p);                   // hook for balanced tree subclasses
                return old;
            }
        }

        public void putIfAbsent(K key, V value) {
            Position<Entry<K, V>> p = treeSearch(root(), key);

            if (p.getElement() == null) {
                Entry<K, V> newEntry = new MapEntry<>(key, value);
                expandExternal(p, newEntry);
                rebalanceAccess(p);
            }
        }

        public V remove(K key) throws IllegalArgumentException {
            checkKey(key);                          // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isExternal(p)) {                    // key not found
                rebalanceAccess(p);                   // hook for balanced tree subclasses
                return null;
            } else {
                V old = p.getElement().getValue();
                if (isInternal(left(p)) && isInternal(right(p))) { // both children are internal
                    Position<Entry<K, V>> replacement = treeMax(left(p));
                    set(p, replacement.getElement());
                    p = replacement;
                } // now p has at most one child that is an internal node
                Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
                Position<Entry<K, V>> sib = sibling(leaf);
                remove(leaf);
                remove(p);                            // sib is promoted in p's place
                rebalanceDelete(sib);                 // hook for balanced tree subclasses
                return old;
            }
        }

        @Override
        public Entry<K, V> firstEntry() {
            if (tree.isEmpty()) return null;
            return treeMin(root()).getElement();
        }

        @Override
        public Entry<K, V> lastEntry() {
            if (tree.isEmpty()) return null;
            return treeMax(root()).getElement();
        }

        @Override
        public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
            checkKey(key);                              // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isInternal(p)) return p.getElement();   // exact match
            while (!isRoot(p)) {
                if (p == left(parent(p)))
                    return parent(p).getElement();          // parent has next greater key
                else
                    p = parent(p);
            }
            return null;                                // no such ceiling exists
        }

        @Override
        public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
            checkKey(key);                              // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isInternal(p)) return p.getElement();   // exact match
            while (!isRoot(p)) {
                if (p == right(parent(p)))
                    return parent(p).getElement();          // parent has next lesser key
                else
                    p = parent(p);
            }
            return null;                                // no such floor exists
        }

        @Override
        public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
            checkKey(key);                              // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isInternal(p) && isInternal(left(p)))
                return treeMax(left(p)).getElement();     // this is the predecessor to p
            // otherwise, we had failed search, or match with no left child
            while (!isRoot(p)) {
                if (p == right(parent(p)))
                    return parent(p).getElement();          // parent has next lesser key
                else
                    p = parent(p);
            }
            return null;                                // no such lesser key exists
        }

        @Override
        public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
            checkKey(key);                               // may throw IllegalArgumentException
            Position<Entry<K, V>> p = treeSearch(root(), key);
            if (isInternal(p) && isInternal(right(p)))
                return treeMin(right(p)).getElement();     // this is the successor to p
            // otherwise, we had failed search, or match with no right child
            while (!isRoot(p)) {
                if (p == left(parent(p)))
                    return parent(p).getElement();           // parent has next lesser key
                else
                    p = parent(p);
            }
            return null;                                 // no such greater key exists
        }

        @Override
        public Iterable<Entry<K, V>> entrySet() {
            ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
            for (Position<Entry<K, V>> p : tree.inorder())
                if (isInternal(p)) buffer.add(p.getElement());
            return buffer;
        }

        @Override
        public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
            checkKey(fromKey);                                // may throw IllegalArgumentException
            checkKey(toKey);                                  // may throw IllegalArgumentException
            ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
            if (compare(fromKey, toKey) < 0)                  // ensure that fromKey < toKey
                subMapRecurse(fromKey, toKey, root(), buffer);
            return buffer;
        }

        // utility to fill subMap buffer recursively (while maintaining order)
        private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> p,
                                   ArrayList<Entry<K, V>> buffer) {
            if (isInternal(p))
                if (compare(p.getElement(), fromKey) < 0)
                    // p's key is less than fromKey, so any relevant entries are to the right
                    subMapRecurse(fromKey, toKey, right(p), buffer);
                else {
                    subMapRecurse(fromKey, toKey, left(p), buffer); // first consider left subtree
                    if (compare(p.getElement(), toKey) < 0) {       // p is within range
                        buffer.add(p.getElement());                      // so add it to buffer, and consider
                        subMapRecurse(fromKey, toKey, right(p), buffer); // right subtree as well
                    }
                }
        }


        public void removeSubMap(K k1, K k2) {

            Comparator<K> comp = new DefaultComparator<>();

            for (Entry<K, V> entry : subMap(k1, k2)) {
                if (comp.compare(entry.getKey(), k1) > 0 && comp.compare(entry.getKey(), k2) < 0) {
                    remove(entry.getKey());
                }
            }
        }

        public int countRange(K k1, K k2) {
            Comparator<K> comp = new DefaultComparator<>();
            int i = 0;

            for (K entry : keySet()) {
                if (comp.compare(entry, k1) > 0 && comp.compare(entry, k2) < 0) {
                    i++;
                }
            }

            return i;
        }

        protected void rebalanceInsert(Position<Entry<K, V>> p) {
        }

        protected void rebalanceDelete(Position<Entry<K, V>> p) {
        }

        protected void rebalanceAccess(Position<Entry<K, V>> p) {
        }

        // remainder of class is for debug purposes only

        /**
         * Prints textual representation of tree structure (for debug purpose only).
         */
        protected void dump() {
            dumpRecurse(root(), 0);
        }

        /**
         * This exists for debugging only
         */
        private void dumpRecurse(Position<Entry<K, V>> p, int depth) {
            String indent = (depth == 0 ? "" : String.format("%" + (2 * depth) + "s", ""));
            if (isExternal(p))
                System.out.println(indent + "leaf");
            else {
                System.out.println(indent + p.getElement());
                dumpRecurse(left(p), depth + 1);
                dumpRecurse(right(p), depth + 1);
            }
        }

        public void toString(Position<Entry<K, V>> p) {
            new BTreePrinter().printNode(p);
        }


        class BTreePrinter {

            public void printNode(Position<Entry<K, V>> root) {
                int maxLevel = maxLevel(root);

                printNodeInternal(Collections.singletonList(root), 1, maxLevel);
            }

            private void printNodeInternal(List<Position<Entry<K, V>>> nodes, int level, int maxLevel) {
                if (nodes.isEmpty() || isAllElementsNull(nodes))
                    return;

                int floor = maxLevel - level;
                int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
                int firstSpaces = (int) Math.pow(2, (floor)) - 1;
                int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

                printWhitespaces(firstSpaces);

                List<Position<Entry<K, V>>> newNodes = new ArrayList<>();
                for (Position<Entry<K, V>> node : nodes) {
                    if (node != null && node.getElement() != null && node.getElement().getKey() != null) {
                        System.out.print(node.getElement().getKey());
                        newNodes.add(left(node));
                        newNodes.add(right(node));
                    } else {
                        newNodes.add(null);
                        newNodes.add(null);
                        System.out.print(" ");
                    }

                    printWhitespaces(betweenSpaces);
                }
                System.out.println("");

                for (int i = 1; i <= endgeLines; i++) {
                    for (int j = 0; j < nodes.size(); j++) {
                        printWhitespaces(firstSpaces - i);
                        if (nodes.get(j) == null) {
                            printWhitespaces(endgeLines + endgeLines + i + 1);
                            continue;
                        }

                        if (left(nodes.get(j)) != null)
                            System.out.print("/");
                        else
                            printWhitespaces(1);

                        printWhitespaces(i + i - 1);

                        if (right(nodes.get(j)) != null)
                            System.out.print("\\");
                        else
                            printWhitespaces(1);

                        printWhitespaces(endgeLines + endgeLines - i);
                    }

                    System.out.println("");
                }

                printNodeInternal(newNodes, level + 1, maxLevel);
            }

            private void printWhitespaces(int count) {
                for (int i = 0; i < count; i++)
                    System.out.print(" ");
            }

            private int maxLevel(Position<Entry<K, V>> node) {
                if (node == null)
                    return 0;

                return Math.max(maxLevel(left(node)), maxLevel(right(node))) + 1;
            }

            private <T> boolean isAllElementsNull(List<T> list) {
                for (Object object : list) {
                    if (object != null)
                        return false;
                }

                return true;
            }

        }





    public static void main(String[] args) {

    }

}
