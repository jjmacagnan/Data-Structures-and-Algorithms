package capitulo_1;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 22/04/17.
 */

/*C-1.16 Write a short program that takes as input three integers, a, b, and c, from the Java
console and determines if they can be used in a correct arithmetic formula (in the
given order), like “a+ b = c,” “a = b − c,” or “a ∗ b = c.*/
public class C116 {

    private int a, b, c;
    private static String operacao;

    public static void main(String[] args) {
        C116 ex2  = new C116();
        ex2.leValores();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma das opções");
        System.out.println("Adicão: Tecle +");
        System.out.println("Subtração: Tecle -");
        System.out.println("Multiplicação: Tecle *");
        operacao = scanner.next();

        switch(operacao) {
            case  "+":
                ex2.verificaAdicao();
            break;
            case "-":
                ex2.verificaSubtracao();
            break;
            case "*":
                ex2.verificaMultiplicação();
            break;
        }
    }

    public void verificaAdicao() {
        if ((a+b) == c) {
            System.out.println("Adição está correta");
        } else {
            System.out.println("Adição incorreta");
        }
    }

    public void verificaSubtracao() {
        if ((a-b) == c) {
            System.out.println("Subtração está correta");
        } else {
            System.out.println("Subtração incorreta");
        }
    }

    public void verificaMultiplicação() {
        if ((a*b) == c) {
            System.out.println("Multiplicação esta correta");
        } else {
            System.out.println("Multiplicação incorreta");
        }
    }

    public void leValores() {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Digite o primeiro valor");
        a = scanner.nextInt();
        System.out.println("Digite o segundo valor");
        b = scanner.nextInt();
        System.out.println("Digite o terceiro valor");
        c = scanner.nextInt();

    }
}
