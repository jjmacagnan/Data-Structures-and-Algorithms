package prova_1.capitulo_2;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class FibonacciProgression extends Progression {

    protected long prev;

    public FibonacciProgression() {
        this(0, 1);
    }

    public FibonacciProgression(long first, long second) {
        super(first);

        prev = second - first;
    }

    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
