package chapter_3.exercises.creativity.scoreboard;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class MainScore {

    public static void main(String[] args) {
        ScoreBoard placar = new ScoreBoard(5);

        GameEntry[] entries = new GameEntry[10];

        entries[1] = new GameEntry("Jasiel", 2400);
        entries[2] = new GameEntry("Marcos", 1400);
        entries[3] = new GameEntry("Jose", 4000);
        entries[4] = new GameEntry("Alicia", 2000);
        entries[5] = new GameEntry("Maria", 3000);
        entries[6] = new GameEntry("Novo", 40000);
        entries[7] = new GameEntry("Menor", 70);


        placar.add(entries[1]);
        placar.add(entries[2]);
        placar.add(entries[3]);
        placar.add(entries[4]);
        placar.add(entries[5]);
        placar.add(entries[6]);
        placar.add(entries[7]);

        placar.imprimirPlacar();

    }







}
