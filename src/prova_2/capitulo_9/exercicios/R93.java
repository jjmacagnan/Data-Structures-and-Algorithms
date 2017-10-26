package prova_2.capitulo_9.exercicios;

import prova_2.capitulo_9.PriorityQueue.AbstractPriorityQueue;
import prova_2.capitulo_9.PriorityQueue.UnsortedPriorityQueue;

/*
 * Created by jjmacagnan on 16/06/2017.
 */
/*What does each removeMin call return within the following sequence of priority
queue ADT operations: insert(5, A), insert(4, B), insert(7, F), insert(1, D),
removeMin(), insert(3, J), insert(6, L), removeMin(),
removeMin(), insert(8, G), removeMin(), insert(2, H), removeMin(),
removeMin()?*/
public class R93 {

    public static void main(String[] args) {
        AbstractPriorityQueue queue = new UnsortedPriorityQueue<>();

        System.out.println("Insert " + queue.insert(5, "A").getValue());
        System.out.println("Insert " + queue.insert(4, "B").getValue());
        System.out.println("Insert " + queue.insert(7, "F").getValue());
        System.out.println("Insert " + queue.insert(1, "D").getValue());
        System.out.println("Remove " + queue.removeMin().getValue());
        System.out.println("Insert " + queue.insert(3, "J").getValue());
        System.out.println("Insert " + queue.insert(6, "L").getValue());
        System.out.println("Remove " + queue.removeMin().getValue());
        System.out.println("Remove " + queue.removeMin().getValue());
        System.out.println("Insert " + queue.insert(8, "G").getValue());
        System.out.println("Remove " + queue.removeMin().getValue());
        System.out.println("Insert " + queue.insert(2, "H").getValue());
        System.out.println("Remove " + queue.removeMin().getValue());
        System.out.println("Remove " +queue.removeMin().getValue());
        System.out.println("Size " + queue.size());

    }
}
