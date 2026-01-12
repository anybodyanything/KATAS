package katas.Velv;

import java.util.Stack;

public class WordMachine {
    //empty stack
    //ops separated by " "
    //validation: 0 to 2^20 - 1: PUSH TO STACK
    //- 0 to 2^20 - 1: PUSH TO STACK
    //POP: remove first int
    //DUP: duplicate top int
    //+: pop and add two first, push result
    //-: pop and subtract two first, push result

    static final int MIN = 0;
    static final int MAX = 1048575;

    public int solution(String S) {
        Stack<Integer> stack = new Stack<>();
        String[] ops = S.split(" ");

        for (String op : ops) {
            if (op.matches("\\d+")){
                int toPush = Integer.parseInt(op);
                if (toPush >= MIN && toPush <= MAX){
                    stack.push(toPush);
                }
            } else if (op.equals("POP")){
                if(isEmpty(stack)){
                    return -1;
                }
                stack.pop();
            } else if (op.equals("DUP")){
                if(isEmpty(stack)){
                    return -1;
                }
                stack.push(stack.peek());
            } else if (op.equals("+")){
                if(stack.size() < 2){
                    return -1;
                }
                int first = stack.pop();
                int second = stack.pop();
                int toPush = first + second;
                if(toPush > MAX){
                    return -1;
                }
                stack.push(toPush);
            } else if (op.equals("-")){
                if(stack.size() < 2){
                    return -1;
                }
                int first = stack.pop();
                int second = stack.pop();
                int toPush = first - second;
                if(toPush < MIN){
                    return -1;
                }
                stack.push(toPush);
            }
        }
        return stack.peek();
    }

    private boolean isEmpty(Stack<Integer> toValidate){
        return toValidate.isEmpty();
    }
}
