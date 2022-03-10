package test_algorithm01;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Algo2_구미_6반_박종욱 {
	public static int[][] lad;
	public static boolean[][] visited;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int dir = 0;
	public static int count, n;

	public static void rotation(int i, int j) {

		visited[i][j] = true;
		count = count + lad[i][j];
		int nx = i + dx[dir];
		int ny = j + dy[dir];
		
//		if (dir == 0) {
//			int nx = i + dx[dir];
//			int ny = i + dy[dir];
//			if(ny>n-1 || visited[nx][ny] == true) {
//				dir =1;
//			}
//
//		} else if (dir == 1) {
//			int nx = i + dx[dir];
//			int ny = i + dy[dir];
//			if(nx>n-1 || visited[nx][ny] == true) {
//				dir =2;
//			}
//
//		} else if (dir == 2) {
//			int nx = i + dx[dir];
//			int ny = i + dy[dir];
//			if(ny<0 || visited[nx][ny] == true) {
//				dir =3;
//			}
//
//		} else if (dir == 3) {
//			int nx = i + dx[dir];
//			int ny = i + dy[dir];
//			if(nx<0 || visited[nx][ny] == true) {
//				dir =0;
//			}
//
//		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int edge = Integer.parseInt(st.nextToken());
			int edge2 = Integer.parseInt(st.nextToken());

			lad = new int[n][n];
			visited = new boolean[n][n];
			int[] teduri = new int[(n / 2) + 2];

			for (int i = 0; i < n; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					lad[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			count = 0;
			rotation(0, 0);

		}

	}
}