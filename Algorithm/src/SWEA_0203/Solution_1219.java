package SWEA_0203;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1219 {
    static int result = 0;
     
    public static void main(String args[]) throws Exception {
 
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            boolean[] visited = new boolean[100];
            int[][] graph = new int[100][100];
             
            int test = sc.nextInt();
            int num = sc.nextInt();
             
            for(int i= 0 ; i<num; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
            }
             
             
            dfs(visited, graph, 0);
            System.out.println("#"+tc+" " + result);
            result = 0;
             
        }
         
    }
    static void dfs(boolean visited[], int graph[][], int index) {
        visited[index] = true;
 
        if(index == 99)
            result =1;
         
        for(int i=0;i<100;i++) {
            if(graph[index][i]==1 && visited[i] == false) {
                dfs(visited, graph, i);
            }
        }
    }
     
 
     
}
