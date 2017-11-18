package chapter_6.exercises.reinforcement;

import chapter_6.code.queue.ArrayQueue;
import chapter_6.code.queue.Queue;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*R-6.8 Se a fila do problema anterior fosse uma instância da classe ArrayQueue, do Código Fragmento 6.10,
com capacidade 30 nunca excedida, qual seria o valor final da variável de instância f?*/
public class R68_Queue {

    /*O valor da variável f é 10, pois das 15 operações dequeue, apenas 10 vão funcionar corretamente */

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(30);

        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++)
            queue.dequeue();

    }

}
