package capitulo_3.exercicios;

/*C-3.35 Implement the clone() method for the DoublyLinkedList class.*/
public class C335_OneSentinel {

    public static void main(String[] args) {
        C331_DoublyLinkedListOneSentinel list = new C331_DoublyLinkedListOneSentinel();
        C331_DoublyLinkedListOneSentinel clone;

        list.addLast(1);
        list.addLast(2);
        list.addFirst(4);

        System.out.println("Lista original: " + list.toString());

        try {
            clone  = list.clone();
            System.out.println("Lista clone: " + clone.toString());
            clone.removeFirst();
            System.out.println("Lista clone: " + clone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
