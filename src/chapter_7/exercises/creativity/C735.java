package chapter_7.exercises.creativity;

/*
 * Created by jjmacagnan on 09/06/2017.
 */

import chapter_6.code.queue.Queue;

/*C-7.35 Reimplemente a classe ArrayQueue, da Seção 6.2.2,
usando arrays dinâmicos para suportar capacidade ilimitada.
Seja especialmente cuidadoso sobre o tratamento de um array circular ao redimensionar.*/
public class C735<E> implements Queue<E> {
    public static  final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public C735() {
        this(CAPACITY);
    }

    public C735(int capacity) {
        data = (E[]) new Object[capacity];
    }


    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void enqueue(E e) {
        if (sz == data.length)
            resize(2 * data.length);

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

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];

        for (int i = 0; i < sz; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    public static void main(String[] args) {
        C735 queue = new C735(1);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("dequeue: " + queue.dequeue());
        queue.enqueue(6);
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
    }
}
