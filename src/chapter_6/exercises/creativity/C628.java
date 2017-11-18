package chapter_6.exercises.creativity;

import chapter_6.code.queue.ArrayQueue;

/*
 * Created by jjmacagnan on 04/06/2017.
 */

/*Implement the clone() method for the ArrayQueue class. (See Section 3.6 for a
discussion of cloning data structures.)*/

/*Implementar o método clone() para a classe ArrayQueue. (Consulte a Seção 3.6 para uma discussão de estruturas de dados de clonagem.)*/
public class C628 {

    public static void main(String[] args) {
        ArrayQueue<String> Q = new ArrayQueue<>();

//        for (int i = 0; i < 10; i++)
//           Q.enqueue(i);
        Q.enqueue("a");
        Q.enqueue("b");
        Q.enqueue("c");
        Q.enqueue("d");
        Q.enqueue("e");

        try {
            ArrayQueue queue = Q.clone();
            queue.size();

            while (queue.size() > 0) {
                System.out.println("dequeue fila clone: " + queue.dequeue());
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Fila original: " + Q.toString(Q));
    }
}
