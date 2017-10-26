package prova_2.capitulo_7.exercicios.criatividade;

import prova_2.capitulo_6.queue.Queue;
import prova_2.capitulo_6.stack.ArrayStack;
import prova_2.capitulo_6.stack.Stack;

/*
 * Created by Jasiel on 10/06/2017.
 */
/* C-7.34 Descreva como implementar o ADT da fila usando duas pilhas como variáveis de instância,
de modo que todas as operações da fila sejam executadas em tempo de O (1) amortizado.
Forneça uma prova formal do limite amortizado.*/
public class C734<E> implements Queue<E> {
    private Stack<E> S1 = new ArrayStack<>();
    private Stack<E> S2 = new ArrayStack<>();

    @Override
    public int size() {
        return S1.size();
    }

    @Override
    public boolean isEmpty() {
        return S1.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        S1.push(e);
    }

    @Override
    public E first() {
        return S1.top();
    }

    @Override
    public E dequeue() {

        while (!S1.isEmpty()) {
            S2.push(S1.pop());
        }

        E o = S2.pop();
        while (!S2.isEmpty())
            S1.push(S2.pop());
        return o;
    }

    public static void main(String[] args) {
       C734 queue = new C734();

       for (int i = 0; i < 10; i++) {
           queue.enqueue(i);
       }

       while (!queue.isEmpty())
           System.out.println("Dequeue: " + queue.dequeue());

    }

}
