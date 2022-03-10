package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
	public static int n, m ,c;
	public static void select_honeycase() {
		for(int i = 0; i< n-m+1; i++) {
			for(int j = 0; j<n; j++) {
				int sum = 0;
				for(int k =0; k<m; k++) {
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			int[][] honeycase = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					honeycase[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			
		}

	}

}
