package prova_1.capitulo_2;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class ArithmeticProgression extends Progression {

    protected long increment;

    public ArithmeticProgression() {
        this(1, 0);
    }

    public ArithmeticProgression(long stepsize) {
        this(stepsize, 0);
    }

    public ArithmeticProgression(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }

    protected void advance() {
        current += increment;
    }
 }
