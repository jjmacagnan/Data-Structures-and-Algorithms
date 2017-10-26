package prova_1.capitulo_5.exercicios.C516_HanoiPilha;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class Main {

    public static void main(String[] args) {
        int tam = 5;
        C516HanoiPilha inicio = new C516HanoiPilha(tam, "Inicio");
        inicio.push(5);
        inicio.push(4);
        inicio.push(3);
        inicio.push(2);
        inicio.push(1);

        C516HanoiPilha meio = new C516HanoiPilha(tam, "Meio");
        C516HanoiPilha fim = new C516HanoiPilha(tam, "Fim");
        hanoi(inicio, meio, fim);

    }

    public static void hanoi(C516HanoiPilha inicio, C516HanoiPilha meio, C516HanoiPilha fim) {
        if (inicio.estaVazia() && meio.estaVazia()) {
            return;
        } else {
            if (inicio.getTopo() < fim.getTopo()) {
                meio.push(inicio.pop());
            } else if (inicio.getTopo() < fim.getTopo()) {
                fim.push(inicio.pop());
            } else if (meio.getTopo() < fim.getTopo()) {
                fim.push(meio.pop());
            } else if (meio.getTopo() < inicio.getTopo()) {
                inicio.push(meio.pop());
            } else if (fim.getTopo() < meio.getTopo()) {
                meio.push(fim.pop());
            } else if (fim.getTopo() < inicio.getTopo()) {
                inicio.push(fim.pop());
            }

            imprime(inicio, meio, fim, inicio.getTamanhoMax());
            hanoi(inicio, meio, fim);
        }
    }

    public static void imprime(C516HanoiPilha inicio, C516HanoiPilha meio, C516HanoiPilha fim, int tam) {
        String format = "%-20s %5d\n";
        int i;

        for(i = 0; i < tam; i++) {
            System.out.println("  " + fim.pilha[i]);
            System.out.println("  " + meio.pilha[i]);
            System.out.println("  " + inicio.pilha[i]);
            System.out.println("");
        }

        System.out.println("Inicio   Meio  Fim");
        System.out.println("------------------");
    }
}
