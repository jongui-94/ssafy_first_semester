package SWEA_0204;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1267 {
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static boolean[] visited;
    static int V; 
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#" + tc);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            st.nextToken(); 
            graph = new int[V + 1][V + 1];
            visited = new boolean[V + 1];
  
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
  
                graph[to][0]++; 
                graph[to][graph[to][0]] = from; 
            }
  
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
  
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
  
    public static void dfs(int from) {
        for (int to = 1; to <= graph[from][0]; to++) {
            if (!visited[graph[from][to]]) { 
                dfs(graph[from][to]); 
            }
        }
  
        visited[from] = true;
        sb.append(" " + from);
    }
}
