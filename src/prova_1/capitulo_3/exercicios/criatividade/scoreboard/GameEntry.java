package prova_1.capitulo_3.exercicios.criatividade.scoreboard;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class GameEntry {
    private String name;
    private int score;

    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toSring() {
        return "(" + name + ", " + score + ")";
    }
}
