package chapter_3.exercises.creativity.inverte_lista_simples_recursivamente;

/*
 * Created by jjmacagnan on 07/05/17.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleLinkedList lista1 = new SingleLinkedList();
        SingleLinkedList lista2 = new SingleLinkedList();
        lista1.imprime();
        lista1.addFirst(1);
        lista1.addLast(2);
        lista1.addFirst(3);
        lista1.addLast(4);
        lista1.addFirst(5);
        lista1.imprime();
        inverte(lista1,lista2);
        System.out.println("----------------");
        lista2.imprime();
    }
    public static void inverte(SingleLinkedList l1,SingleLinkedList l2){
        //condição de parada
        if(l1.first()==null)
            return;
        else{
            l2.addFirst(l1.removeFirst());
            inverte(l1,l2);
        }
    }

}
