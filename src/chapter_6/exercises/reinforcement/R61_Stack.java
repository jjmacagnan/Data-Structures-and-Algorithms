package chapter_6.exercises.reinforcement;

import chapter_6.code.stack.ArrayStack;
import chapter_6.code.stack.Stack;

/*
 * Created by Jasiel on 29/05/2017.
 */

/*R-6.1 Suponha que uma pilha inicialmente vazia S tenha realizado um total de 25 operações push,
12 operações top e 10 operações pop, 3 das quais retornaram nulas para indicar uma pilha vazia.
Qual é o tamanho atual de S?*/
public class R61_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.top());
        stack.push(5);
        System.out.println(stack.top());
        stack.push(6);
        stack.push(7);
        System.out.println(stack.top());
        stack.push(8);
        stack.push(9);
        System.out.println(stack.top());
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        System.out.println(stack.top());
        stack.push(14);
        stack.push(15);
        System.out.println(stack.top());
        stack.push(16);
        System.out.println(stack.top());
        stack.push(17);
        stack.push(18);
        stack.push(19);
        System.out.println(stack.top());
        stack.push(20);
        stack.push(21);
        System.out.println(stack.top());
        stack.push(22);
        System.out.println(stack.top());
        stack.push(23);
        System.out.println(stack.top());
        stack.push(24);
        stack.push(25);
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println("pop " + stack.pop());
        System.out.println("size " + stack.size());
    }
}
