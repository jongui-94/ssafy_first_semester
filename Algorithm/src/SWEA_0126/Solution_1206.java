package SWEA_0126;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1206 {
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int T;
            T = sc.nextInt();
             
             
            int sum = 0;
            int[] bd = new int[T+1];
 
            for (int test_case = 1; test_case <= T; test_case++) {
                int value = sc.nextInt();
                bd[test_case] = value;
            }
            for (int i = 3; i<=T-2;i++)
            {
                int[] best = new int[4];
                int max = 0;
                best[0] = bd[i-2];
                best[1] = bd[i-1];
                best[2] = bd[i+1];
                best[3] = bd[i+2];
                for(int j: best) {
                    if(j >= max) {
                        max =j;
                    }
                }
                if(bd[i]>max) {
                    sum += (bd[i]-max);
                }
                 
            }
            System.out.println("#"+tc+" "+ sum);
        }
         
    }
}
