package chapter_6.code.stack;

import chapter_3.code.SinglyLinkedList;

import java.util.Arrays;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = "]})";
        Stack<Character> buffer = new LinkedStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1)
                return false;
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty())
                    return false;
                if (!tag.substring(1).equals(buffer.pop()))
                    return false;
            }
            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        Integer[] a = {4, 8, 15, 16, 23, 42};
        String[] s = {"Jack", "kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Revesing");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));

        String expression = "((([[[)))";

        String htmlExpression = "<body>\n" +
                "<center>\n" +
                "<h1> The Little Boat </h1>\n" +
                "</center>\n" +
                "<p> The storm tossed the little\n" +
                "boat like a cheap sneaker in an\n" +
                "old washing machine. The three\n" +
                "drunken fishermen were used to\n" +
                "such treatment, of course, but\n" +
                "not the tree salesman, who even as\n" +
                "a stowaway now felt that he\n" +
                "had overpaid for the voyage. </p>\n" +
                "<ol>\n" +
                "<li> Will the salesman die? </li>\n" +
                "<li> What color is the boat? </li>\n" +
                "<li> And what about Naomi? </li>\n" +
                "</ol>\n" +
                "</body>";

        System.out.println(LinkedStack.isMatched(expression));
        System.out.println(LinkedStack.isHTMLMatched(htmlExpression));
    }
}
