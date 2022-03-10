package SWEA_0203;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1217 {
    public static void main(String args[]) throws Exception {
 
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int tc = 0; tc < T; tc++) {
 
            int num = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
 
            System.out.println("#"+num+" "+ recur(a,b));
 
        }
    }
 
    static int recur(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a * recur(a, b - 1);
    }
}
