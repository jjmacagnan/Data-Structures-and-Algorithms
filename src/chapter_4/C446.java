package chapter_4;

public class C446 {

    public static void main(String args[]) {

        int[] array = {1,2,3,4,5};
        C446.insertionSort(array);

        for (int a : array) {
            System.out.print("," + a);
        }
    }

    public static void insertionSort(int[] data) {
        int n = data.length;

        for (int k = 0; k < n; k++) {
            int cur = data[k];
            int j = k;
            System.out.println("for");

            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
                System.out.println("entrou no while");
            }
            data[j] = cur;
        }
    }
}
