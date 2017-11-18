package chapter_7.exercises.creativity;

import chapter_7.code.array_list.List;

/*C-7.25 Dê uma implementação de lista baseada em array, com capacidade fixa,
tratando o array de forma circular para que ele atinja O(1) tempo para inserções e remoções no índice 0,
bem como inserções e remoções no final do array list.
Sua implementação também deve fornecer um método get() de tempo constante.*/
public class C725<E> {

    public static final int CAPACITY = 4;
    private E[] data;
    private int size = 0;
    private int f = 0;

    public C725() {
        this(CAPACITY);
    }

    public C725(int capacity) {
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

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Ilegal index: " + i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;

        while (i < size()) {
            sb.append(get(i));

            if (i != size() - 1)
                sb.append(", ");
            i++;
        }

        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        C725 array = new C725();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove();
        array.add(0);

        System.out.println(array.toString());
    }
}
