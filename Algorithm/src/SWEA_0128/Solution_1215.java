package SWEA_0128;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1215 {
 
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int N = 8;
         
        for (int tc = 1; tc <= 10; tc++) {
             
            char[][] arr = new char[8][8];
            int scale = sc.nextInt();
 
            for(int i=0;i<N;i++) {
                String tmp = sc.next();
                arr[i]= tmp.toCharArray();
            }
             
            boolean check;
            int max = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<=N-scale;j++) {
                    check = true;
                    for(int k=0;k<scale/2;k++) {
                        if(arr[i][j+k] != arr[i][j+scale-k-1]) {
                            check = false;
                            continue;
                        }
                    }
                    if(check) {
                        max++;
                    }
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<=N-scale;j++) {
                    check = true;
                    for(int k=0;k<scale/2;k++) {
                        if(arr[j+k][i] != arr[j+scale-k-1][i]) {
                            check = false;
                            continue;
                        }
                    }
                    if(check) {
                        max++;
                    }
                }
            }
            System.out.println("#"+ tc+" " + max);
 
        }
    }
 
}
