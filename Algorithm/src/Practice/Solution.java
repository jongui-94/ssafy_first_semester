package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[W][H];
			
			for(int i = 0; i<W; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j = 0; j<H; j++) {
					map[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			
			
		}
	}

}
