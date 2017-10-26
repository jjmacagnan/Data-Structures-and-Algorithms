package chapter_6.exercises.reinforcement;

import chapter_6.code.deque.Deque;
import chapter_6.code.deque.LinkedDeque;
import chapter_6.code.stack.Stack;


/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*R-6.10 Implemente o ADT da Stack usando uma instância de
um deque para armazenamento.*/
public class R610_Stack_Deque<E> implements Stack<E> {
    Deque<E> deque = new LinkedDeque<>();

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void push(E e) {
        deque.addFirst(e);
    }

    @Override
    public E top() {
        return deque.first();
    }

    @Override
    public E pop() {
        return deque.removeFirst();
    }

    public static void main(String[] args) {
        Stack<Integer> deque = new R610_Stack_Deque<>();

        deque.push(1);
        deque.push(2);
        deque.push(3);

        System.out.println("Top: " + deque.top());
        System.out.println("Pop: " + deque.pop());
        System.out.println("Pop: " + deque.pop());
        System.out.println("Pop: " + deque.pop());
        System.out.println("Size: " + deque.size());


    }
}
