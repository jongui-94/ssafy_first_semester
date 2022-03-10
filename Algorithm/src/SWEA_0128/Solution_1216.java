package SWEA_0128;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1216 {
    static final int N = 100;
    static char[][] arr = new char[N][N];;
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
 
        for (int tc = 0; tc < T; tc++) {
 
            int time = Integer.parseInt(br.readLine());
 
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
 
            System.out.println("#" + time + " " + findMax());
 
        }
 
    }
 
    static int findMax() {
        for (int i = N; i > 0; i--) {
            if (allcheck(i))
                return i;
        }
        return 0;
    }
 
    static boolean allcheck(int scale) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - scale; j++) {
                if (rowcheck(i, j, scale))
                    return true;
                if (colcheck(j, i, scale))
                    return true;
            }
        }
        return false;
    }
 
    static boolean rowcheck(int x, int y, int scale) {
        for (int i = 0; i < scale / 2; i++) {
            if (arr[x][y + i] != arr[x][y + scale - 1 - i])
                return false;
        }
        return true;
 
    }
 
    static boolean colcheck(int x, int y, int scale) {
        for (int i = 0; i < scale / 2; i++) {
            if (arr[x + i][y] != arr[x + scale - 1 - i][y])
                return false;
        }
        return true;
    }
 
}
