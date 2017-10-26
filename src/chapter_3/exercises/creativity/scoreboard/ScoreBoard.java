package chapter_3.exercises.creativity.scoreboard;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class ScoreBoard {
    private int tamAtual = 0;
    private GameEntry[] placar;

    //aloca um vetor do tamanho desejado
    public ScoreBoard(int tamAtual) {
        placar = new GameEntry[tamAtual];
    }

    public void add(GameEntry score) {
        int novaPontuacao = score.getScore();
        //add quando o vetor tem espaço ou qunado a nova entrada for maior do que a ultima
        if (tamAtual < placar.length || novaPontuacao > placar[tamAtual-1].getScore()) {
            //o vetor nao esta cheio
            if (tamAtual < placar.length) {
                tamAtual++;
            }

            //hora de colocar o novo item no vetor, deslocando todos os que foremmenor para a direita
            int aux = tamAtual-1;
            //percorre o vetor da direita para esquerda
            //enquanto estiver dentro do tamanho e a pontuacao atual for maior
            //que a atual, desloca a atual para a direita
            while (aux > 0 && novaPontuacao > placar[aux-1].getScore()) {
                placar[aux] = placar[aux-1];
                aux--;
            }
            //local para inserir nova pontuação
            placar[aux] = score;
        }
    }

    //Remove e retorna o score do indice i
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > tamAtual) {
            throw new IndexOutOfBoundsException();
        }

        //Se o indice for valido ele sera retornado pelo metodo
        //Para isso precisa criar um auxiliar
        GameEntry retorno  = placar[i];

        while (i < tamAtual-1) {
            placar[i] = placar[i+1];
            i++;
        }

        //limpa a ultima posicao que estara duplicada
        placar[tamAtual-1] = null;
        //Decrementa o tamanho atual
        tamAtual--;

        return retorno;

    }

    public void imprimirPlacar() {
        for (int i = 0; i < tamAtual; i++) {
            System.out.println("Nome: " + placar[i].getName());
            System.out.println(" | Score: " + placar[i].getScore());
        }
    }
}
