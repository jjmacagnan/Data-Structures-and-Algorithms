package prova_2.capitulo_6.queue;

/*
 * Created by jjmacagnan on 28/05/2017.
 */
public class Josephus {
    public static <E> E Josephus(CircularQueue<E> queue, int k) {
        if (queue.isEmpty())
            return null;
        while (queue.size() > 1) {
            for (int i = 0; i < k; i++) {
                queue.rotate();
            }
            E e  = queue.dequeue();
            System.out.println(" " + e + " is out");
        }
        return queue.dequeue();
    }
}