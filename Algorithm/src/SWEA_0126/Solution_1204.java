package SWEA_0126;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1204
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt();
             
            System.out.print("#" + test_case+ " ");
            int many= 0;
            int index = 0;
         
            int[] student = new int[1000];
            int[] grade = new int[101];
             
            for(int i = 0; i<1000;i++) {
                int num = sc.nextInt();
                student[i] = num;
                grade[num] ++;
            }
            for(int j=0; j<101;j++){
                if(grade[j] >= many) {
                    many = grade[j];
                    index = j;
                }
            }
            System.out.print(index);
            System.out.println();
           
        }
    }
}
