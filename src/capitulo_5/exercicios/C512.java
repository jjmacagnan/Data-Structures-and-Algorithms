package capitulo_5.exercicios;

/*
 * Created by jjmacagnan on 23/04/17.
 */

/*C-5.12 Describe an efficient recursive algorithm for solving the element uniqueness problem,
which runs in time that is at most O(n2) in the worst case without using sorting. */
public class C512 {

    public static void main(String[] args) {
        int[] v = {1,2,3,4,5,7};

        System.out.println(unique(v, v.length,0,0));
    }

    public static boolean unique(int[] v, int n, int aux, int aux2) {

        if(aux2 == n) {
            return true;
        } else if (aux == n-1) {
            aux = 0;
            aux2++;
        } else if (aux != aux2 && v[aux2] == v[aux]) {
            return false;
        }

        return unique(v, n, aux+1, aux2);
    }
}
