package SWEA_0127;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1209 {
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T;
            T = sc.nextInt();
            int max = 0;
 
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    int value = sc.nextInt();
                    arr[i][j] = value;
                }
            }
 
            int[] row = new int[101];
            int[] col = new int[101];
            int index = 0;
            int sum = 0;
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                row[index] = sum;
                index++;
                sum = 0;
            }
 
            index = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                col[index] = sum;
                index++;
                sum = 0;
            }
 
            index = 0;
            for (int i = 0; i < 100; i++) {
                sum += arr[i][i];
            }
            row[100] = sum;
            index++;
            sum = 0;
             
            index = 0;
            for (int i = 99; i >= 0; i--) {
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                col[100] = sum;
                index++;
                sum = 0;
            }
             
            for(int n:row) {
                if(n>max) {
                    max =n;
                }
            }
            for(int n:col) {
                if(n>max) {
                    max =n;
                }
            }
            System.out.println("#"+tc+" "+ max);
 
        }
 
    }
}
