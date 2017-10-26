package chapter_5.code;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class PotenciaRecursivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calcule a potencia de um numero");
        System.out.println("Digite a base");
        double base = scanner.nextDouble();
        System.out.println("Digite a potencia");
        int potencia = scanner.nextInt();

        System.out.println(potencia(base, potencia));

    }

    public static double potencia(double valor, int potencia) {
        if (potencia == 0) {
            return 1;
        } else {
            return valor*potencia(valor, potencia-1);
        }
    }
}
