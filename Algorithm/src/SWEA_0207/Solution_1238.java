package SWEA_0207;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1238 {
    public static int G[][];
    public static boolean visited[];
    public static Queue<Integer> queue = new LinkedList<>();
    public static int many[];   
     
    public static void BFS(int n) {
        visited[n] = true;
        queue.offer(n);
        many[n] = 1;
         
        while(!queue.isEmpty()) {
            n = queue.peek();
            queue.poll();
            for(int i = 0; i<101;i++) {
                if(G[n][i] > 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    many[i] = many[n] + 1;
                }
            }
        }
         
    }
 
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
             
            G = new int[101][101];
            visited = new boolean[101];
            many = new int[101];
             
            int data = sc.nextInt();
            int start = sc.nextInt();
             
            for(int i = 0; i<data/2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                G[from][to] = 1;
            }
             
            BFS(start);
             
            int result = -1;
            int max = -1;
            for(int i = 0; i<101; i++) {
                if(many[i] > max) {
                    max = many[i];
                }
            }
            for(int i =0; i<101; i++) {
                if(many[i]==max) {
                    if(i>result)
                        result = i;
                }
            }
             
            System.out.println("#"+ tc+" "+ result);
        }
    }
}
