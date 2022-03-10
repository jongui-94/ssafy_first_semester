package SWEA_0126;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1208 {
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc<=10; tc++) {
            int T;
            T = sc.nextInt();
             
            int re_max =0;
            int re_min =1000;
            int[] block = new int[100];
             
            for(int i= 0; i<100; i++)
            {
                int value = sc.nextInt();
                block[i] = value;
            }
             
 
            for (int test_case = 0; test_case < T; test_case++) {
                int in_max = -1;
                int in_min = -1;
                int max = 0;
                int min = 1000;
                for(int k=0;k<100;k++) {
                    if(block[k] > max) {
                        max = block[k];
                        in_max = k;
                    }
                    if(block[k] < min) {
                        min = block[k];
                        in_min = k;
                    }
                }
                block[in_max]--;
                block[in_min]++;
            }
            for(int k=0;k<100;k++) {
                if(block[k] > re_max) {
                    re_max = block[k];
                }
                if(block[k] < re_min) {
                    re_min = block[k];
                }
            }
            System.out.println("#"+tc+" "+ (re_max-re_min));
             
        }
         
    }
}
