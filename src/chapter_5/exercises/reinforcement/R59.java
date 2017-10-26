package chapter_5.exercises.reinforcement;

/*Develop a nonrecursive implementation of the version of the power method from
Code Fragment 5.9 that uses repeated squaring.*/

/*R-5.9 Develop a nonrecursive implementation of the version of the power method from
Code Fragment 5.9 that uses repeated squaring.*/
public class R59 {

    public static void main(String[] args) {
        double n = power(5, 2);

        System.out.println(n);
    }

    public static double power(double x, int n) {

        double power = x;

        if (n == 0)
            return 1;
        else {
           for (int i = n; i > 1; i--) {
               power = power*x;
           }
        }

        return power;
    }
}
