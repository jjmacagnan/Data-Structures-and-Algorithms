package capitulo_7.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Created by JJMacagnan on 16/05/17.
 */
public class ArrayListIterator<E> implements Iterable<E> {

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        @Override
        public boolean hasNext() {
            return j < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if(j == size)
                throw new NoSuchElementException("no next element");

            removable = true;
            return data[j++];
        }

        @Override
        public void remove() throws IllegalStateException{
            if(!removable)
                throw new IllegalStateException("nothing to remove");
            j--;
            removable = false;
        }
    }

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayListIterator() {
        this(CAPACITY);
    }

    public ArrayListIterator(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length)
            resize(2 * data.length);
        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }


    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)
            data[k] = data[k + 1];
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Ilegal index: " + i);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    public static void main(String[] args) {
        ArrayListIterator<Integer> list = new ArrayListIterator<>(2);
        Iterator iterator = list.iterator();

        list.add(0, 9);
        list.add(1, 4);
        list.add(2, 5);
        list.set(0, 10);
        list.add(1, 6);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("size:" + list.size);
        System.out.println(list.isEmpty());


    }


}
