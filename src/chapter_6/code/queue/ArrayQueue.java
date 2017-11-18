package chapter_6.code.queue;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public class ArrayQueue<E> implements Queue<E> {
    public static  final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return sz == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalArgumentException{
        if (sz == data.length)
            throw new IllegalArgumentException("Queue is Full");

        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    @Override
    public E first() {
        if (isEmpty())
            return null;

        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;

        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    public String toString(ArrayQueue<E> Q) {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;

        while (i < Q.size()) {
            sb.append(Q.data[i]);

            if (i != Q.size() - 1)
                sb.append(", ");
            i++;
        }

        sb.append(")");
        return sb.toString();
    }

    public ArrayQueue<E> clone() throws CloneNotSupportedException {
        ArrayQueue<E> other = new ArrayQueue<>();
        int aux = 0;
        while (aux < size()) {
            other.enqueue(data[aux]);
            aux++;
        }
        return other;
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Maria");
        queue.enqueue("Jose");
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.first());
        queue.dequeue();
        System.out.println(queue.first());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.first());
    }
}
