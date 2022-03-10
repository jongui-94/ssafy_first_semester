package SWEA_0208;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1233 {
    public static char tree[];
    public static int child[][];
    public static int check;
 
    public static void pre(int x) {
        if(child[x][0] == -1) {
            //System.out.print(tree[x]);
            if(tree[x] == '+' || tree[x] == '-' || tree[x] == '*' || tree[x] == '/') {
                check = 0;
            }
        }
        else {
            if(child[x][0] != -1) {
                pre(child[x][0]);
            }
            //System.out.print(tree[x]);
            if(child[x][1] != -1) {
                pre(child[x][1]);
            }
        }
         
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
             
            int v = Integer.parseInt(br.readLine());
             
            tree = new char[v+1];
            child = new int[v+1][2];
            check = 1;
 
            for (int i = 1; i <= v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                 
                tree[i] = st.nextToken().charAt(0);
                 
                if(st.countTokens() == 0) {
                    child[i][0] = -1;
                    child[i][1] = -1;
                }
                else if(st.countTokens() == 1) {
                    child[i][0] = Integer.parseInt(st.nextToken());
                    child[i][1] = -1;
                }
                else {
                    child[i][0] = Integer.parseInt(st.nextToken());
                    child[i][1] = Integer.parseInt(st.nextToken());
                }
                 
            }
             
             
            pre(1);
            System.out.println("#"+ tc+" "+ check);
 
        }
    }
}
