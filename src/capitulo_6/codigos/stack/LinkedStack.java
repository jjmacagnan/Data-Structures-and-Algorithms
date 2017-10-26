package capitulo_6.codigos.stack;

import capitulo_3.codigos.SinglyLinkedList;

import java.util.Arrays;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedStack() {}

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    public void imprime() {
        list.toString();
    }

    public static<E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for(int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    public static void main(String[] args) {
        Integer[] a = {4, 8, 15, 16, 23, 42};
        String[] s = {"Jack", "kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Revesing");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }
}
