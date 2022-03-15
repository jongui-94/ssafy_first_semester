package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
	public static void arrange() {
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] zari = new int[n+1];
			int[][] gate = new int[3][2];
			
			for(int i = 0; i<3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				gate[i][0] = Integer.parseInt(st.nextToken());
				gate[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
		}
		
	}

}
