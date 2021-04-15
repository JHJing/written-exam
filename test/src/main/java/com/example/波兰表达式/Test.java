package com.example.波兰表达式;


import java.util.Scanner;
import java.util.Stack;

/**
 * @program: test
 * @description:
 * @author: JJH
 * @create: 2021-04-15 13:03
 **/
public class Test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        System.out.println(evalRPN(next.split(" ")));

    }

    public static int evalRPN(String[] tokens) {
        Stack st = new Stack();
        boolean flag= true;
        int val =0 ;
        for(int i =0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int a = Integer.valueOf(st.pop().toString());
                int b = Integer.valueOf(st.pop().toString());
                st.push(b+a);
            }else if("-".equals(tokens[i])){
                int a = Integer.valueOf(st.pop().toString());
                int b = Integer.valueOf(st.pop().toString());
                st.push(b-a);
            }else if("*".equals(tokens[i])){
                int a = Integer.valueOf(st.pop().toString());
                int b = Integer.valueOf(st.pop().toString());
                st.push(b*a);
            }else if("/".equals(tokens[i])){
                int a = Integer.valueOf(st.pop().toString());
                int b = Integer.valueOf(st.pop().toString());
                st.push(b/a);
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.valueOf(st.peek().toString());
    }

}
