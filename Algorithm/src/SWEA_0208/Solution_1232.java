package SWEA_0208;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1232 {
    public static char op[];
    public static int lchild[];
    public static int rchild[];
    public static int result[];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
             
            int v = Integer.parseInt(br.readLine());
             
            op = new char[v+1];
            lchild = new int[v+1];
            rchild = new int[v+1];
            result = new int[v+1];
             
            int idx = 0;
            int last = 0;
 
            for (int i = 1; i <= v; i++) {
                String[] st = br.readLine().split(" ");
                idx = Integer.parseInt(st[0]);
                 
                if(st.length == 4) {
                    op[idx] = st[1].charAt(0);
                    lchild[idx] = Integer.parseInt(st[2]);
                    rchild[idx] = Integer.parseInt(st[3]);
                    last = idx;
                }
                else result[idx] = Integer.parseInt(st[1]);
            }
             
            for(int i = last; i>0; i--) {
                if(op[i] == '+') result[i] = result[lchild[i]] + result[rchild[i]];
                else if(op[i] == '-') result[i] = result[lchild[i]] - result[rchild[i]];
                else if(op[i] == '*') result[i] = result[lchild[i]] * result[rchild[i]];
                else if(op[i] == '/') result[i] = result[lchild[i]] / result[rchild[i]];
            }
             
             
            System.out.println("#"+ tc+" "+ result[1]);
 
        }
    }
}
