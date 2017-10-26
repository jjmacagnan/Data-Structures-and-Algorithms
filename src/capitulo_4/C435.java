package capitulo_4;

import java.util.Arrays;

/*
 * Created by jjmacagnan on 23/04/17.
 */
/*C-4.35 Assuming it is possible to sort n numbers in O(nlogn) time, show that it is possible to solve the three-way set disjointness problem in O(nlogn) time.*/
public class C435 {

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3};
        int[] arrayB = {3, 2, 1};
        int[] arrayC = {11, 22, 33};
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Arrays.sort(arrayC);
        System.out.println(disjoint3(arrayA, arrayB, arrayC));
        System.out.println(disjoint1(arrayA, arrayB, arrayC));
        System.out.println(disjoint2(arrayA, arrayB, arrayC));
    }

    public static boolean disjoint3(int[] groupA, int[] groupB, int[] groupC) {
        for (int j = 0; j < groupA.length; j++) {
            if ((groupA[j] == groupB[j]) && (groupA[j] == groupC[j])) {
                return false;
            }
        }
        return true;
    }

    public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
        int i = 0;
        for(int a : groupA) {
            for (int b : groupB) {
                for (int c : groupC) {
                    i++;
                    if ((a == b) && (b == c)) {
                        return false;
                    }
                }
            }
        }
        System.out.println(i);
        return true;
    }

    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        int i = 0;
        for (int a : groupA) {
            for (int b : groupB) {
                for (int c : groupC) {
                    i++;
                    if (a == c) {
                        return false;
                    }
                }
            }
        }
        System.out.println(i);
        return true;
    }
}
