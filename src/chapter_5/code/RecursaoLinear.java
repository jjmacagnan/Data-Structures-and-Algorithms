package chapter_5.code;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class RecursaoLinear {

    public static void main(String[] args) {
        int data[] = {1,2,3,4,5,6};

        int n = 6;

        System.out.println("Soma linear: " + linearSum(data, n));
    }

    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum(data, n-1) + data[n-1];
        }
    }
}
