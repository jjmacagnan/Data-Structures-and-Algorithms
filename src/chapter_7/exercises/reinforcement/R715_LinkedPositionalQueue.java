package chapter_7.exercises.reinforcement;

import chapter_6.code.queue.Queue;

import chapter_7.code.positional_list.LinkedPositionalList;
import chapter_7.code.positional_list.Position;


/*
 * Created by jjmacagnan on 07/06/2017.
 */
/*R-7.15 Para modelar melhor uma fila FIFO em que as entradas podem ser excluídas antes de chegar à frente,
crie uma classe LinkedPositionalQueue que suporte a ADT da fila completa,
ainda com enqueue retornando uma instância de posição e suporte para um novo método,
remova (p) que remove o elemento associado à posição p da fila.
Você pode usar o padrão de design do adaptador (Seção 6.1.3), usando um LinkedPositionalList como seu armazenamento.*/
public class R715_LinkedPositionalQueue<E> implements Queue<E> {
    LinkedPositionalList<E> list = new LinkedPositionalList<>();

    public R715_LinkedPositionalQueue() {}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return (E) list.first();
    }

    @Override
    public E dequeue() {
        return list.remove(list.first());
    }

    public E remove(Position<E> p) {
        E temp = p.getElement();

        list.remove(p);
        return temp;
    }


    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String args[]) {
        R715_LinkedPositionalQueue queue = new R715_LinkedPositionalQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.toString());

        queue.dequeue();

        queue.enqueue(5);
        queue.enqueue(4);

        System.out.println("Remove: " + queue.remove(queue.list.before(queue.list.last())));

        System.out.println(queue.toString());
    }
}
