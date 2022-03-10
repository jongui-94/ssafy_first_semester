package SWEA_0209;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_1240 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            char[][] arr = new char[row][col];
 
            for (int i = 0; i < row; i++) {
                String s = br.readLine();
                for (int j = 0; j < col; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
 
            int stx = 0;
            int sty = 0;
            here: 
            for (int i = row-1; i >=0; i--) {
                for (int j = col-1; j >=0; j--) {
                    if (arr[i][j] == '1') {
                        stx = i;
                        sty = j-55;
                        break here;
                    }
                }
            }
 
            int[] code = new int[8];
            for (int i = 0; i < 8; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    sb.append(arr[stx][sty]);
                    sty++;
                }
                if(sb.toString().equals("0001101")) code[i] = 0;
                else if(sb.toString().equals("0011001")) code[i] = 1;
                else if(sb.toString().equals("0010011")) code[i] = 2;
                else if(sb.toString().equals("0111101")) code[i] = 3;
                else if(sb.toString().equals("0100011")) code[i] = 4;
                else if(sb.toString().equals("0110001")) code[i] = 5;
                else if(sb.toString().equals("0101111")) code[i] = 6;
                else if(sb.toString().equals("0111011")) code[i] = 7;
                else if(sb.toString().equals("0110111")) code[i] = 8;
                else if(sb.toString().equals("0001011")) code[i] = 9;
            }
 
            int sum =0;
            sum = (code[0] + code[2] + code[4] +code[6])*3 + 
                    code[1] + code[3] + code[5] + code[7];
             
            int result = 0;
            for(int i: code)
                result += i;
             
            if(sum%10 == 0) {
                System.out.println("#"+ tc+" "+result);
            }
            else {
                System.out.println("#"+ tc+" "+ 0);
            }
 
        }
    }
}
