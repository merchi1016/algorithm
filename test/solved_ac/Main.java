package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws IOException{
		solution();
	}
	
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 수의 범위 ( 0 ~ 10000), 문제 조건상 0은 제외
		int[] cnt = new int[10001];
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			// 해당 인덱스 값 1 증가
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		for(int i = 1; i < 10001; i++) {
			// i 값이 개수가 0이 될 때까지 출력 (빈도수)
			while(cnt[i] > 0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}
}
