package chapter_9.exercises;


/*C-9.37 Suppose two binary trees, T1 and T2, hold entries satisfying the heap-order property (but not necessarily the complete binary tree property). Describe a method
for combining T1 and T2 into a binary tree T, whose nodes hold the union of
the entries in T1 and T2 and also satisfy the heap-order property. Your algorithm
should run in time O(h1 + h2) where h1 and h2 are the respective heights of T1
and T2*/

import chapter_9.code.Heap.HeapPriorityQueue;

public class C937 {

    public static void main(String[] args) {

        HeapPriorityQueue t1 = new HeapPriorityQueue();
        HeapPriorityQueue t2 = new HeapPriorityQueue();
        HeapPriorityQueue t3 = new HeapPriorityQueue();

        System.out.println(t1.insert(4, "C").getValue());
        System.out.println(t1.insert(9, "A").getValue());
        System.out.println(t1.insert(6, "Z").getValue());
        System.out.println(t1.insert(15, "K").getValue());
        System.out.println(t1.insert(9, "F").getValue());


        System.out.println(t2.insert(5, "J").getValue());
        System.out.println(t2.insert(14, "E").getValue());
        System.out.println(t2.insert(12, "H").getValue());
        System.out.println(t2.insert(7, "Q").getValue());
        System.out.println(t2.insert(20, "B").getValue());
        System.out.println(t2.insert(11, "S").getValue());
        System.out.println(t2.insert(13, "W").getValue());


        t3.combine(t1, t2);

        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
        System.out.println("Removendo " + t3.removeMin().getValue());
    }


}
