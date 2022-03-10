package SWEA_0204;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution_1224 {
    static int num;
    static String input, result;
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            num = Integer.parseInt(br.readLine());
            input = br.readLine();
 
            range();
            int fi = calc();
            System.out.println("#"+tc+" "+ fi);
 
            }
 
        }
 
 
    static void range() {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> priority = new HashMap<>();
        HashMap<Character, Integer> inpriority = new HashMap<>();
 
        priority.put('+', 1);
        priority.put('*', 2);
        priority.put('(', 3);
 
        inpriority.put('+', 1);
        inpriority.put('*', 2);
        inpriority.put('(', 0);
         
        int len = input.length();
 
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
 
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
                continue;
            }
 
            if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
 
                // ')' 제거
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
 
            while (!stack.isEmpty() && inpriority.get(stack.peek()) >= priority.get(ch)) {
                sb.append(stack.pop());
            }
 
            stack.push(ch);
        }
 
        result = sb.toString();
    }
 
    public static int calc() {
        Stack<Integer> stack = new Stack<Integer>();
 
        for (int i = 0; i < result.length(); ++i) {
            char ch = result.charAt(i);
 
            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
                continue;
            }
 
            int op2 = stack.pop();
            int op1 = stack.pop();
 
            if (ch == '+') {
                stack.push(op1 + op2);
            } else if (ch == '*') {
                stack.push(op1 * op2);
            }
        }
 
        return stack.pop();
    }
}
