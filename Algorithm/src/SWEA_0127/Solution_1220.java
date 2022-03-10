package SWEA_0127;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1220 {
 
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int T;
         
         
        for (int tc = 1; tc <= 10; tc++) {
            T = sc.nextInt();
 
            int[][] arr = new int[100][100];
            int count = 0;
 
            // 요소 삽입
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < T; j++) {
                    int value = sc.nextInt();
                    arr[i][j] = value;
                }
            }       
             
            for(int i = 0; i<100; i++) {
                int[] ans = new int[2];
                 
                for(int j = 0; j< 100; j++) {
                    if(arr[j][i] == 1) {
                        ans[0] = 1;
                    }
                    else if(arr[j][i] ==2) {
                        ans[1] = 2;
                        if(ans[0] == 1 && ans[1] == 2) {
                            count++;
                            ans[0] = 0;
                            ans[1] = 0;
                        }
                    }
                }       
            }
 
            System.out.println("#"+tc+" "+ count);
 
        }
         
 
    }
 
}
