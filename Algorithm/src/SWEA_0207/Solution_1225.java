package SWEA_0207;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1225 {
 
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            Queue<Integer> queue = new LinkedList<>();
            int tcase = sc.nextInt();
             
            for(int i = 0; i<8; i++) {
                int value = sc.nextInt();
                queue.offer(value);
            }
             
            int minus = 1;
            while(true) {
                int value = queue.peek();
                queue.poll();
                if(value - minus > 0) {
                    queue.offer(value - minus);
                }
                else {
                    queue.offer(0);
                    break;
                }
                minus++;
                if(minus == 6)
                    minus =1;
                         
            }
            System.out.print("#"+ tc);
            while(!queue.isEmpty()) {
                int result = queue.peek();
                System.out.print(" "+result);
                queue.poll();
            }
            System.out.println();
        }
    }
}
