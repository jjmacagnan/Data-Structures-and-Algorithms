package chapter_6.exercises.creativity;

import chapter_6.code.stack.ArrayStack;

/*
 * Created by jjmacagnan on 03/06/2017.
 */

/*Alice has three array-based stacks, A, B, and C, such that A has capacity 100,
B has capacity 5, and C has capacity 3. Initially, A is full, and B and C are
empty. Unfortunately, the person who programmed the class for these stacks
made the push and pop methods private. The only method Alice can use is a static
method, dump(S,T), which transfers (by iteratively applying the private pop and
push methods) elements from stack S to stack T until either S becomes empty
or T becomes full. So, for example, starting from our initial configuration and
performing dump(A,C) results in A now holding 97 elements and C holding 3.
Describe a sequence of dump operations that starts from the initial configuration
and results in B holding 4 elements at the end.*/
public class C622 {

    public static void main(String[] args) {
        ArrayStack<Integer> A = new ArrayStack<>(100);
        ArrayStack<Integer> B = new ArrayStack<>(5);
        ArrayStack<Integer> C = new ArrayStack<>(3);

        for (int i = 0; i < 100; i++) {
            A.push(i);
        }

        System.out.println("dump A,C");
        A.dump(A,C);
        System.out.println("Size A: " + A.size());
        System.out.println("Size C: " + C.size());

        System.out.println("dump C,B");
        A.dump(C,B);
        System.out.println("Size C: " + C.size());
        System.out.println("Size B: " + B.size());

        System.out.println("dump A,C");
        A.dump(A,C);
        System.out.println("Size A: " + A.size());
        System.out.println("Size C: " + C.size());

        System.out.println("dump C,B");
        A.dump(C,B);
        System.out.println("Size C: " + C.size());
        System.out.println("Size B: " + B.size());









    }
}
