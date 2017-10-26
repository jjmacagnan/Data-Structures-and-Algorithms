package chapter_5.exercises.creativity.C516_HanoiPilha;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class C516HanoiPilha {
    public int[] pilha;
    private int topo;
    private String nome;

    public C516HanoiPilha(int tamanhoMax, String nome) {
        pilha = new int[tamanhoMax];
        topo = 0;

        for (int i = 0; i < tamanhoMax; i++) {
            pilha[i] = 99;
        }

        this.nome = nome;
    }

    public void imprime() {
        System.out.println(nome);
        System.out.println(" - Topo: " + topo);
        for (int i = 0; i < topo; i++) {
            System.out.println("[" + pilha[i] + "]");
        }
    }

    public int getTamanho() {
        return topo+1;
    }

    public int getTamanhoMax() {
        return pilha.length;
    }

    public int getTopo() {
        return pilha[topo];
    }

    private void aumentaTopo() {
        if (topo < pilha.length-1) {
            topo++;
        }
    }

    private void diminuiTopo() {
        if (topo > 0) {
            topo--;
        }
    }

    public boolean estaCheia() {
        if (getTamanho() == pilha.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaVazia() {
        if (pilha[0] == 99) {
            return true;
        } else {
            return false;
        }
    }

    public boolean push(int elemento){
        if (pilha[pilha.length-1] != 99) {
            return false;
        } else {
            pilha[topo] = elemento;
            aumentaTopo();
            return true;
        }
    }

    public int pop() {
        if (pilha[topo] == 0) {
            return -1;
        } else {
            int elemento = pilha[topo];
            pilha[topo] = 99;
            diminuiTopo();;
            return elemento;
        }
    }
}
