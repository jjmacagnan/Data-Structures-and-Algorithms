package chapter_13;


import java.util.HashMap;
import java.util.Map;

/*
 * Created by Jasiel on 09/07/2017.
 */
public class TextProcessing {

    /*Code Fragment 13.1: An implementation of the brute-force pattern-matching algorithm. (We use character arrays rather than strings to simplify indexing notation.)*/
    public static int findbrute(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;

        for (int i = 0; i <= n - m; i++) {
            int k = 0;
            while (k < m && text[i + k] == pattern[k])
                k++;
            if (k == m)
                return i;
        }
        return -1;
    }

    /*Code Fragment 13.2: An implementation of the Boyer-Moore algorithm.*/
    public static int findBoyerMoore(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0)
            return 0;

        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++)
            last.put(text[i], -1);
        for (int k = 0; k < m; k++)
            last.put(pattern[k], k);

        int i = m - 1;
        int k = m - 1;
        while (i < n) {
            if (text[i] == pattern[k]) {
                if (k == 0)
                    return i;
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(text[i]));
                k = m - 1;
            }
        }
        return -1;
    }

    /*Code Fragment 13.3: An implementation of the KMP pattern-matching algorithm.
The computeFailKMP utility method is given in Code Fragment 13.4.*/
    public static int findKMP(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0)
            return 0;

        int[] fail = computeFailKMP(pattern);
        int j = 0;
        int k = 0;
        while (j < n) {
            if (text[j] == pattern[k]) {
                if (k == m - 1)
                    return j = m + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return -1;
    }

    /*Code Fragment 13.4: An implementation of the computeFailKMP utility in support
of the KMP pattern-matching algorithm. Note how the algorithm uses the previous
values of the failure function to efficiently compute new values.*/
    private static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else j++;
        }
        return fail;
    }


    public static void main(String[] args) {

        String text = "aaabaadaabaaa";
        String pattern = "aabaaa";

        ///System.out.println(findbrute(text.toCharArray(), pattern.toCharArray()));


        //System.out.println(findBoyerMoore("the quick brown fox jumped over a lazy cat".toCharArray(), "abcdefghijklm".toCharArray()));

        System.out.println(findKMP("cgtacgttcgtac".toCharArray(), "cgtacgttcgtac".toCharArray()));


    }


}
