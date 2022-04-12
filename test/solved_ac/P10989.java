package solved_ac;

// 수 정렬하기 3
// https://www.acmicpc.net/problem/10989
// 22.04.12 못풀었음(시간초과, 데이터초과)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class P10989 {
	
	// https://st-lab.tistory.com/107 참조
	// 방법 1. Arrays.sort() 사용하기
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	// 방법 2. 카운팅 정렬
	public static void solution2() throws IOException{
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
