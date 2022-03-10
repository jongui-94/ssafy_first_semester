package SWEA_0203;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1218 {    
    public static void main(String args[]) throws Exception {
 
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            char arr[] = new char[1000];
             
            char stack1[] = new char[300];
            char stack2[] = new char[300];
            char stack3[] = new char[300];
            char stack4[] = new char[300];
             
            int top1 = -1;
            int top2 = -1;
            int top3 = -1;
            int top4 = -1;
            boolean flag = true;
             
            int num = sc.nextInt();
            String str = sc.next();
             
            for(int i = 0; i<num; i++) {
                arr[i] = str.charAt(i);
            }
             
            for(int i = 0; i<num;i++) {
                switch(arr[i]) {
                case '(':
                    if(top1<-1) {
                        flag = false;
                        break;
                    }
                    stack1[++top1] = arr[i];
                    break;
                 
                case ')':
                    if(top1==-1) flag = false;
                    top1--;
                    break;
                     
                case '[':
                    if(top2<-1) {
                        flag = false;
                        break;
                    }
                    stack2[++top2] = arr[i];
                    break;
                 
                case ']':
                    if(top2==-1) flag = false;
                    top2--;
                    break;
                     
                case '{':
                    if(top3<-1) {
                        flag = false;
                        break;
                    }
                    stack3[++top3] = arr[i];
                    break;
                 
                case '}':
                    if(top3==-1) flag = false;
                    top3--;
                    break;  
                 
                case '<':
                    if(top4<-1) {
                        flag = false;
                        break;
                    }
                    stack4[++top4] = arr[i];
                    break;
                 
                case '>':
                    if(top4==-1) flag = false;
                    top4--;
                    break;  
                }
            }
            if(top1 != -1 && top2 != -1 && top3 != -1 && top4 != -1) {
                flag = false;
            }
             
            if(flag == true)
                System.out.println("#"+tc + " "+ 1);
            else
                System.out.println("#"+tc + " "+ 0);
                 
             
        }
    }
 
     
}