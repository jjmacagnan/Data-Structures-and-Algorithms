package chapter_7.exercises.reinforcement;

import chapter_6.code.stack.Stack;
import chapter_7.code.array_list.ArrayList;
import chapter_7.code.array_list.List;

/*
 * Created by jjmacagnan on 04/06/2017.
 */
/* R-7.2 Dê uma implementação da pilha ADT usando um array list para armazenamento*/
public class R72<E> implements Stack<E>{
    List<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(0, e);
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        return list.remove(0);
    }


    public static void main(String[] args) {
        Stack stack = new R72<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());

        while (stack.size() > 0) {
            System.out.println("Pop: " + stack.pop());
        }

        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());

    }
}
