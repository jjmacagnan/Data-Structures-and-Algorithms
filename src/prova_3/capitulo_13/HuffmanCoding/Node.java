package prova_3.capitulo_13.HuffmanCoding;

import java.util.Map;

/*
 * Created by Jasiel on 09/07/2017.
 */
public class Node implements Comparable<Node> {
    private char symbol;
    private int count;

    private Node left;
    private Node right;

    public Node(char symbol) {
        this.symbol = symbol;
    }

    public Node(Node left, Node right) {
        this.symbol = '+';
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getFrequency() {
        if (isLeaf())
            return count;
        return left.getFrequency() + right.getFrequency();
    }

    public char getSymbol() {
        return symbol;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void add() {
        count++;
    }

    @Override
    public int compareTo(Node o) {
        return getFrequency() - o.getFrequency();
    }

    @Override
    public String toString() {
        String ch = symbol == '\n' ? "\\n" : "" + symbol;

        return String.format("'%s': %d", ch, getFrequency());
    }

    public void fillCodeMap(Map<Character, String> codemap, String work) {
        if (isLeaf()) {
            codemap.put(getSymbol(), work);
            return;
        }

        left.fillCodeMap(codemap, work + "0");
        right.fillCodeMap(codemap, work + "1");
    }
}