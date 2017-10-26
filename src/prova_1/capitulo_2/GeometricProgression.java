package prova_1.capitulo_2;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class GeometricProgression extends Progression {

    protected long base;

    public GeometricProgression() {
        this(2, 1);
    }

    public GeometricProgression(long b) {
        this(b, 1);
    }

    public GeometricProgression(long b, long start) {
        super(start);
        base = b;
    }

    protected void advance() {
        current *= base;
    }
}
