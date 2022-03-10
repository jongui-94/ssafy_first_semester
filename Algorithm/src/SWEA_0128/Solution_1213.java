package SWEA_0128;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_1213 {
 
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int Tc =10;
         
        for(int i=1; i<=Tc; i++) {
             
            int T = sc.nextInt();
            String find = sc.next();
            String s = sc.next();
             
            int index = 0;
            int sum = 0;
            while(true) {
                index = s.indexOf(find);
                if(index == -1) {
                    break;
                }
                s = s.substring(index+1);
                sum +=1;
            }
             
            System.out.println("#"+ i + " " + sum);
        }
         
 
    }
 
}