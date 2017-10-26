package capitulo_6.exercicios.reforco;

import capitulo_6.codigos.queue.ArrayQueue;
import capitulo_6.codigos.queue.Queue;

/*
 * Created by jjmacagnan on 30/05/2017.
 */

/*R-6.8 Se a fila do problema anterior fosse uma instância da classe ArrayQueue, do Código Fragmento 6.10,
com capacidade 30 nunca excedida, qual seria o valor final da variável de instância f?*/
public class R68_Queue {

    /*O valor da variável continua sendo 0, pois no metodo enqueue o valor de f nunca é incrementado*/

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(30);

        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 30; i++)
            queue.dequeue();

    }

}
