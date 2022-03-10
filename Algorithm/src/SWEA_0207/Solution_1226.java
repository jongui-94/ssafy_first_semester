package SWEA_0207;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1226 {
    public static int maze[][];
    public static boolean visited[][];
    public static int dx[] = { 0, 0, 1, -1 };
    public static int dy[] = { 1, -1, 0, 0 };
    public static int result;
 
    public static void bfs(int x, int y) {
        visited[x][y] = true;
        if (maze[x][y] == 3) {
            result = 1;
        }
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (!visited[a][b] && (maze[a][b] == 0 || maze[a][b] == 3)) {
                bfs(a, b);
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            int testcase = Integer.parseInt(br.readLine());
 
            maze = new int[16][16];
            visited = new boolean[16][16];
            int x = 0;
            int y = 0;
            result = 0;
 
            for (int i = 0; i < 16; i++) {
                String s = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = s.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
 
            bfs(x, y);
            System.out.println("#"+ tc+ " "+ result);
 
        }
    }
}
