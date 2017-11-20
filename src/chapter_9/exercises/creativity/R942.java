package chapter_9.exercises.creativity;

import chapter_9.code.PriorityQueue.DefaultComparator;

public class R942<E> {

    private E[] data;

    public R942() {
        data = (E[]) new Object[10];
    }

    public boolean binarySearch(E[] data, E target, int low, int high, DefaultComparator comparator) {
            if (low > high)
                return false;
        else {
            int mid = (low + high) / 2;
            if (comparator.compare(target,data[mid]) == 0)
                return true;
            else if (comparator.compare(target,data[mid]) < 0)
                return binarySearch(data, target, low, mid - 1, comparator);
            else
                return binarySearch(data, target, mid + 1, high, comparator);
        }
    }

    public static void main(String[] args) {

        R942 r942 = new R942();
        DefaultComparator defaultComparator = new DefaultComparator();

        r942.data[0] = "A";
        r942.data[1] = "B";
        r942.data[2] = "C";
        r942.data[3] = "D";



        System.out.println(r942.binarySearch(r942.data, "D", 0, 3, defaultComparator));



    }

}
