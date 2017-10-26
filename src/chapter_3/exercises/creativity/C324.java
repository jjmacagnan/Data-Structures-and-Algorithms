package chapter_3.exercises.creativity;

import java.util.Random;

/*  C-3.24 Write a Java method that takes two three-dimensional integer arrays and adds
them componentwise.*/
public class C324 {

    public static void main(String[] args) {
        int arrayA[][][] = new int[5][5][5];
        int arrayB[][][] = new int[5][5][5];
        Random random = new Random();


        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA.length; j++) {
                for (int k = 0; k < arrayA.length; k++) {
                    arrayA[i][j][k] = random.nextInt(100);
                }
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < arrayB.length; k++) {
                    arrayB[i][j][k] = random.nextInt(100);
                }
            }
        }

        System.out.println("Array A");
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA.length; j++) {
                for (int k = 0; k < arrayA.length; k++) {
                    System.out.print("arr[" + i + "][" + j + "][" + k + "] = " + arrayA[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Array B");
        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < arrayB.length; k++) {
                    System.out.print("arr[" + i + "][" + j + "][" + k + "] = " + arrayB[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
