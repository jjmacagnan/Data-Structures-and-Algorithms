package prova_2.capitulo_7.exercicios.reforco;

import prova_2.capitulo_6.stack.Stack;
import prova_2.capitulo_7.array_list.ArrayList;
import prova_2.capitulo_7.array_list.List;


/*
 * Created by jjmacagnan on 04/06/2017.
 */
/*Reimplement the ArrayStack class, from Section 6.1.2, using dynamic arrays to
support unlimited capacity.*/
public class R710<E> implements Stack<E> {
    private List<E> data;

    public R710() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void push(E e) throws IllegalStateException {
        data.add(0,e);
    }

    public E top() {
        if (isEmpty()) return null;
        return data.get(size()-1);
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data.get(size()-1);
        data.remove(size()-1);
        return answer;
    }

    public static void main(String[] args) {
        R710 stack = new R710<>();

        for (int i = 10; i > 0; i--) {
            stack.push(i);
        }

        System.out.println("Top: " + stack.top());
        while (stack.size() > 0) {
            System.out.println("Pop: " + stack.pop());
        }


        System.out.println("Pop: " + stack.pop());

    }
}
