package chapter_7.exercises.creativity;

/*C-7.26 Complete o exercício anterior, exceto usando uma matriz dinâmica para fornecer capacidade ilimitada.*/
public class C726<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    private int f = 0;

    public C726() {
        this(CAPACITY);
    }

    public C726(int capacity) {
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

    public void add(E e) {
        if (size == data.length){
            resize(2 * data.length);
        }
        if (size == 0) {
            data[0] = e;
        } else {
            int avail = (f + size) % data.length;
            data[avail] = e;
        }
        size++;

    }


    public E remove() {
        checkIndex(f, size);
        E temp = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return temp;
    }

    private void resize(int capacity) {
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

    public static void main(String[] args) {
        C726 array = new C726(1);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove();
        array.add(0);
    }
}
