package chapter_2;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class Progression {

    protected long current;

    public Progression() {
        this(0);
    }

    public Progression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    protected void advance() {
        current++;
    }

    public void printProgression(int n) {
        System.out.println(nextValue());

        for (int j = 1; j < n; j++) {
            System.out.println(" " + nextValue());
        }
        System.out.println();
    }
}
