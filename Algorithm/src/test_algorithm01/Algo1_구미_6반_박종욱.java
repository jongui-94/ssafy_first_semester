package test_algorithm01;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Algo1_구미_6반_박종욱 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//testcase 입력
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			//양의 정수 입력
			int n = Integer.parseInt(br.readLine());
			//양의 정수만큼 arr배열 생성
			int[] arr = new int[n];
			//문자열을 읽어온뒤 공백기준 자른다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				//배열에 하나씩 입력
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;

			for (int i = 1; i < n - 1; i++) {
				int next = i;
				while (true) {
					next += 1;
					//현재값과 다음값이 다를때까지(같으면 다음인데스로 넘김)
					if (arr[i] != arr[next])
						break;
					//배열의 끝에 닿아도 break
					if (next == n - 1)
						break;
				}
				//봉우리라면 count+1
				if (arr[i - 1] < arr[i] && arr[i] > arr[next]) {
					count += 1;
					
				}
			}
			System.out.println("#"+ tc+" "+ count);
		}
	}
}