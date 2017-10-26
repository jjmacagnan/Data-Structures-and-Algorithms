package chapter_5.code;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class FibonacciBom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero");

        int num = scanner.nextInt();

        long[] fib = fibonacci(num);

        for(long fi : fib) {
            System.out.print("-"+fi);
        }
    }

    public static long[] fibonacci(int n) {
        if (n <= 1) {
            long[] resposta = {n,0};
            return resposta;
        } else {
            long[] temp = fibonacci(n -1);
            long[] resposta = {temp[0] + temp[1], temp[0]};
            return resposta;
        }
    }
}
