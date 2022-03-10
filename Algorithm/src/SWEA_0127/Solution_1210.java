package SWEA_0127;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1210 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
 
            int T;
            T = sc.nextInt();
            int goalx = 0;
            int goaly = 0;
            int count = 0;
 
            int[][] lad = new int[100][100];
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    int value = sc.nextInt();
                    lad[i][j] = value;
                    if (lad[i][j] == 2) {
                        goalx = i;
                        goaly = j;
                    }
                }
            }
 
            for (int i = 0; i < 100; i++) {
                boolean con = false;
                if (goaly > 0) {
                    if (lad[goalx][goaly - 1] == 1) {
                        for (int k = goaly - 1; k >= 0; k--) {
                            if (lad[goalx - 1][k] == 1) {
                                con = true;
                                goalx -= 1;
                                goaly = k;
                                break;
                            }
                        }
                    }
                }
                if (goaly < 99) {
                    if (lad[goalx][goaly + 1] == 1) {
                        for (int t = goaly + 1; t <= 99; t++) {
                            if (lad[goalx - 1][t] == 1) {
                                con = true;
                                goalx -= 1;
                                goaly = t;
                                break;
                            }
                        }
                    }
                }
 
                if (con == false) {
                    goalx -= 1;
                }
 
                if (goalx == 0) {
                    break;
                }
            }
            System.out.println("#"+ tc+" "+ goaly);
             
             
        }
    }
}
