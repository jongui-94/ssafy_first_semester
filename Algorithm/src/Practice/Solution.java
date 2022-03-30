package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class salt {
	int x;
	int y;
	int dir;
	
	salt(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Solution {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			int count = num;
			salt[] salts = new salt[num];
			boolean[][] map = new boolean[n][n];
			
			for(int i = 0; i<num; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				int dir = Integer.parseInt(st1.nextToken());
				
				map[x][y] = true;
				salts[i] = new salt(x,y,dir);
			}
			
			for(salt slt : salts) {				
				int dirx = dx[slt.dir - 1];
				int diry = dy[slt.dir - 1];		

				int curx = slt.x;
				int cury = slt.y;			

				map[curx][cury] = false;

				JUMP: for (int j=3; j > 0; j--) {
					curx += dirx * j;
					cury += diry * j;

					boolean check = curx < n && curx >= 0 && cury < n && cury >= 0 && !map[curx][cury];

					if(!check) {
						count--;
						break JUMP;
					}

					if(j == 1) {
						if(map[curx][cury]) count--;
						else map[curx][cury] = true;	
					}
				}
			}
			
			System.out.println("#"+tc+" " + count);
			
			
			
			
			
			
		}
		
	}

}
