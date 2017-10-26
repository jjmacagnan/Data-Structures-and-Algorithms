package chapter_2;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class TestProgression {

    public static void main(String[] args) {
        Progression progression;

        //Test ArithmeticProgression
        System.out.println("Arithmetic Progression with default increment: ");
        progression = new ArithmeticProgression();
        progression.printProgression(10);
        System.out.println("Arithmetic Progression with increment 5: ");
        progression = new ArithmeticProgression(5);
        progression.printProgression(10);
        System.out.println("Arithmetic Progression with start 2: ");
        progression = new ArithmeticProgression(5, 2);
        progression.printProgression(10);

        //Test GeometricProgression
        System.out.print("Geometric progression with default base: ");
        progression = new GeometricProgression();
        progression.printProgression(10);
        System.out.print("Geometric progression with base 3: ");
        progression = new GeometricProgression(3);
        progression.printProgression(10);

        //FibonacciProgression
        System.out.print("Fibonacci progression with start values: ");
        progression = new FibonacciProgression();
        progression.printProgression(10);
        System.out.print("Fibonacci progression with start values 4 and 6: ");
        progression = new FibonacciProgression(4, 6);
        progression.printProgression(8);
    }
}
