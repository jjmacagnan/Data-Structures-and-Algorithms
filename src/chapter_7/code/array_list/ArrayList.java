package chapter_7.code.array_list;

/*
 * Created by JJMacagnan on 16/05/17.
 */
public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            resize(e, i,2 * data.length);
            //resize4N();
        } else {
            for (int k = size - 1; k >= i; k--) {
                data[k + 1] = data[k];
            }

            data[i] = e;
        }


        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++)
            data[k] = data[k + 1];
        data[size - 1] = null;
        size--;

        /*Exercicio C-7.29*
        Revise the array list implementation given in Section 7.2.1 so that when the actual number of elements, n, in the array goes below N/4, where N is the array
        capacity, the array shrinks to half its size.*/
        if (size < data.length/4) {
            resize(null, i,data.length/2);
            //resizeN();
            System.out.println("Resize array pela metade da capacidade");
        }

        return temp;
    }

    protected void resize(E e, int i, int capacity) {
        E[] temp = (E[]) new Object[capacity];

        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }

        if (e != null) {
            for (int k = size - 1; k >= i; k--) {
                temp[k + 1] = temp[k];
            }
            temp[i] = e;
        }

        data = temp;
    }

    protected void resizeN() {
        E[] temp = (E[]) new Object[size];

        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }


        data = temp;
    }

    public void resize4N() {
        int x = (int) Math.round(((double)size + (size / 4))+0.5d);

        E[] temp = (E[]) new Object[x];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }


    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i > n)
            throw new IndexOutOfBoundsException("Ilegal index: " + i);
    }

    public void trimToSize() {
        //System.out.println("ANTES: " + data.length);
        if (data.length > size) {
            E[] temp = (E[]) new Object[size];

            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }

            data = temp;
            //System.out.println("DEPOIS: " + data.length);
        }
    }

    public ArrayList<E> clone() throws CloneNotSupportedException {
        ArrayList<E> other = new ArrayList<>();

        int aux = 0;
        while (aux < size()) {
            E e = data[aux];
            other.add(aux, e);
            aux++;
        }
        return other;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            data[i] = null;
        size = 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (data[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(2);

        list.add(0, 9);
        list.add(1, 4);
        list.add(2, 5);

        //list.trimToSize();

        list.clear();

        System.out.println(list.size);
        System.out.println(list.isEmpty());


    }
}
