package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution1 {
	public static int result, cnt;
	public static int[][] loc;
	public static boolean[] loc_visit;
	
	public static void move(int x, int y) {
		for(int i=0; i<cnt; i++) {
			loc_visit[i] = true;
			
			if(loc_visit[i] != true) {
				int dx = loc[i][0];
				int dy = loc[i][1];
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			cnt = 0;
			
			for(int i =0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) {
						cnt++;
					}
				}
			}
			loc = new int[cnt*2][2];
			loc_visit = new boolean[cnt*2];
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(map[i][j] >0) {
						loc[map[i][j]-1][0] = i;
						loc[map[i][j]-1][1] = j;
					}
					else if(map[i][j] < 0) {
						int value = Math.abs(map[i][j]);
						loc[value+cnt-1][0] = i;
						loc[value+cnt-1][1] = j;
					}
				}
			}
			
			
			
			
			
			
			
		}
		
	}

}

