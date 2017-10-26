package prova_2.capitulo_9.exercicios;

import prova_2.capitulo_6.stack.Stack;
import prova_2.capitulo_9.Heap.HeapPriorityQueue;
import prova_2.capitulo_9.PriorityQueue.PriorityQueue;
import prova_2.capitulo_9.adaptable_priority_queue.AdaptablePriorityQueue;
import prova_2.capitulo_9.adaptable_priority_queue.HeapAdaptablePriorityQueue;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
/*Show how to implement the stack ADT using only a priority queue and one
additional integer instance variable.*/
public class C925<E> implements Stack<E> {
    private HeapAdaptablePriorityQueue queue = new HeapAdaptablePriorityQueue();
    private int x;

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void push(E e) {
        queue.insert(x++, e);
    }

    @Override
    public E top() {
        return (E) queue.min().getValue();
    }

    @Override
    public E pop() {
        return (E) queue.removeMin().getValue();
    }

    public static void main(String[] args) {

        Stack stack = new C925<>();


        stack.push("A");
        stack.push("C");
        stack.push("J");
        stack.push("K");
        stack.push("V");


        System.out.println(stack.top());
        System.out.println(stack.pop());


    }
}
