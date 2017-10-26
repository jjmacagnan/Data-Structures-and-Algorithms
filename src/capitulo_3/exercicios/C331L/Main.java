package capitulo_3.exercicios.C331L;

/*
 * Created by jjmacagnan on 07/05/17.
 */
public class Main {

    public static void main(String[] args) {

        DoubleLinkedListUmaSentinelaCloneable dl1 = new DoubleLinkedListUmaSentinelaCloneable();
        DoubleLinkedListUmaSentinelaCloneable dl2 = new DoubleLinkedListUmaSentinelaCloneable();
        dl1.addFirst(1);
        dl1.addLast(2);
        dl1.addFirst(3);
        dl1.addLast(4);
        dl1.addFirst(5);
        System.out.println("Last: " + dl1.last());
        System.out.println("Primeira lista antes de remover");
        dl1.imprime();
        try {
            dl2 = dl1.clone();
        } catch (Exception e) {
            System.out.println("Erro no clone" + e);
        }
        System.out.println("Segunda lista");
        dl2.imprime();
        dl1.removeFirst();
        dl1.removeLast();
        System.out.println("Primeira lista depois de remover");
        dl1.imprime();
        System.out.println("Segunda lista");
        dl2.imprime();
    }
}
