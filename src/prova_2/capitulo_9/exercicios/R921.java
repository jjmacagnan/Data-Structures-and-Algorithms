package prova_2.capitulo_9.exercicios;

import prova_2.capitulo_9.PriorityQueue.AbstractPriorityQueue;
import prova_2.capitulo_9.PriorityQueue.Entry;
import prova_2.capitulo_9.adaptable_priority_queue.AdaptablePriorityQueue;
import prova_2.capitulo_9.adaptable_priority_queue.HeapAdaptablePriorityQueue;

import java.util.AbstractMap;
import java.util.Map;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
/*Illustrate all the steps of the adaptable priority queue call remove(e) for entry e
storing (16,X) in the heap of Figure 9.1.*/
public class R921<K, V> {

    public static void main(String[] args) {
        HeapAdaptablePriorityQueue priorityQueue = new HeapAdaptablePriorityQueue();

        System.out.println(priorityQueue.insert(4, "C").getValue());
        System.out.println(priorityQueue.insert(5, "A").getValue());
        System.out.println(priorityQueue.insert(6, "Z").getValue());
        System.out.println(priorityQueue.insert(15, "K").getValue());
        System.out.println(priorityQueue.insert(9, "F").getValue());
        System.out.println(priorityQueue.insert(16, "X").getValue());
        System.out.println(priorityQueue.insert(25, "J").getValue());
        System.out.println(priorityQueue.insert(14, "E").getValue());
        System.out.println(priorityQueue.insert(12, "H").getValue());
        System.out.println(priorityQueue.insert(7, "Q").getValue());
        System.out.println(priorityQueue.insert(20, "B").getValue());
        System.out.println(priorityQueue.insert(11, "S").getValue());
        System.out.println(priorityQueue.insert(13, "W").getValue());
        

    }


}
