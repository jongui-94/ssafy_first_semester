package SWEA_0204;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution_1234 {
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
             
            int n = Integer.parseInt(stn.nextToken());
            String str = stn.nextToken();
            //String[] st = str.split("");
            Stack<Integer> stk = new Stack<>();
            for(int i= 0; i<str.length(); i++) {
                 
            }
             
            for(int i = 0; i<n; i++) {
                int num = str.charAt(i) - '0';
                if(stk.empty()) {
                    stk.push(num);
                }
                else {
                    if(stk.peek()==num) {
                        stk.pop();
                    }
                    else {
                        stk.push(num);
                    }
                }
            }
//          System.out.println(stk.size());
//          while(!stk.empty()){
//              System.out.println(stk.peek());
//              stk.pop();
//          }
            int size = stk.size();
            int[] arr = new int[size];
            for(int i = 0; i<size;i++) {
                arr[i] = stk.peek();
                stk.pop();
            }
            System.out.print("#"+ tc+ " ");
            for(int i = size-1; i>=0; i--) {
                System.out.print(arr[i]);
            }
            System.out.println();
 
        }
 
    }
 
}
