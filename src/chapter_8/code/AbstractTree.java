package chapter_8.code;

import chapter_6.code.queue.LinkedQueue;
import chapter_6.code.queue.Queue;
import chapter_7.code.positional_list.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Created by jjmacagnan on 27/05/2017.
 */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public Position<E> root() {
        return null;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException {
        return null;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalStateException {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalStateException {
        int count = 0;
        for (Position child : children(p))
            count++;
        return count;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        return p == root();
    }

    @Override
    public int size() {
        int count = 0;
        for (Position p : positions())
            count++;
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    //---------- support for computing depth of nodes and balanceFactor of (sub)trees ----------

    public int depth(Position<E> p) throws IllegalStateException {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    private int heightBad() {
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p))
                h = Math.max(h, depth(p));
        }

        return h;
    }

    private int height(Position<E> p) throws IllegalStateException {
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + depth(c));

        return h;
    }

    //---------- support for various iterations of a tree ----------

    //---------------- nested ElementIterator class ----------------
    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the tree.
     * @return iterator of the tree's elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Returns an iterable collection of the positions of the tree.
     * @return iterable collection of the tree's positions
     */
    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder.
     * @return iterable collection of the tree's positions in preorder
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given
     * snapshot using a postorder traversal
     * @param p       Position serving as the root of a subtree
     * @param snapshot  a list to which results are appended
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for(Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder.
     * @return iterable collection of the tree's positions in postorder
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree in breadth-first order.
     * @return iterable collection of the tree's positions in breadth-first order
     */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for(Position<E> c : children(p))
                    fringe.enqueue(c); // add children to back of queue
            }
        }
        return snapshot;
    }


}
