package chapter_6.code.stack;

/*
 * Created by jjmacagnan on 16/05/17.
 */
public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) throws IllegalArgumentException {
        if (size() == data.length)
            throw new IllegalArgumentException("Stack is Full");

        data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;

        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    public static <E> Stack<E> transfer(Stack<E> stackS, Stack<E> stackT) {
        if (stackS.isEmpty())
            return null;

        while (stackS.size() > 0) {
            stackT.push(stackS.pop());
        }

        return stackT;
    }

    public static <E> Stack<E> transferSameOrderRecursive(Stack<E> stackS, Stack<E> stackT) {
        if (!stackS.isEmpty()) {
            E answer = stackS.top();
            stackS.pop();

            transferSameOrderRecursive(stackS, stackT);
            stackT.push(answer);
        }

        return stackT;
    }

    public static <E> Stack<E> transferInverseRecursive(Stack<E> stackS, Stack<E> stackT) {
        if (!stackS.isEmpty()) {
            E answer = stackS.pop();

            stackT.push(answer);

            transferInverseRecursive(stackS, stackT);
        }

        return stackT;
    }

    public void popAllRecursive(Stack<E> stack) {

        if (!stack.isEmpty()) {
            System.out.println("pop recursivo " + stack.pop());  // remove one stack element

            popAllRecursive(stack); // recursive invocation of your method
        }

    }

    public void dump(ArrayStack<E> S, ArrayStack<E> T) {
        if (!S.isEmpty()) {
            for (int i = 0; i < S.size(); i++) {
                if (T.size() < T.data.length) {
                    T.push(S.pop());
                }
            }
        }
    }

    public ArrayStack<E> clone() throws CloneNotSupportedException {
        ArrayStack<E> other = new ArrayStack<>();
        int aux = 0;
        while (aux < size()) {
            other.push(data[aux]);
            aux++;
        }
        return other;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;

        while (i < size()) {
            sb.append(data[i]);

            if (i != size() - 1)
                sb.append(", ");
            i++;
        }

        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stackS = new ArrayStack<>();
        Stack<Integer> stackT = new ArrayStack<>();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);

        System.out.println(stackS.size());


        //System.out.println("Top stackS: " + stackS.top());

        // Stack st = transfer(stackS, stackT);

        //System.out.println("Top stackT: " + st.top());


//        stack.push(5);
//        stack.push(3);
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
//        stack.push(7);
//        stack.push(9);
//        System.out.println(stack.top());
//        stack.push(4);
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        stack.push(6);
//        stack.push(8);
//        System.out.println(stack.pop());

//        stack.push(1);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(2);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(3);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        stack.push(4);
//        System.out.println(stack.top());
//        stack.push(5);
//        System.out.println(stack.top());
//        stack.push(6);
//        stack.push(7);
//        System.out.println(stack.top());
//        stack.push(8);
//        stack.push(9);
//        System.out.println(stack.top());
//        stack.push(10);
//        stack.push(11);
//        stack.push(12);
//        stack.push(13);
//        System.out.println(stack.top());
//        stack.push(14);
//        stack.push(15);
//        System.out.println(stack.top());
//        stack.push(16);
//        System.out.println(stack.top());
//        stack.push(17);
//        stack.push(18);
//        stack.push(19);
//        System.out.println(stack.top());
//        stack.push(20);
//        stack.push(21);
//        System.out.println(stack.top());
//        stack.push(22);
//        System.out.println(stack.top());
//        stack.push(23);
//        System.out.println(stack.top());
//        stack.push(24);
//        stack.push(25);
//        System.out.println("pop" + stack.pop());
//        System.out.println("pop" + stack.pop());
//        System.out.println("pop" + stack.pop());
//        System.out.println("pop" + stack.pop());
//        System.out.println("size " + stack.size());
//        System.out.println(stack.top());
    }
}
