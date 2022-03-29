package solved_ac;

// 벌집 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2292 {
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 거치는 벌집 카운트 수
		int count = 1;
		// 범위
		int range = 2;
		
		if(N == 1) {
			System.out.println(1);
		}else {
			while(range <= N) {
				range = range + (count * 6);
				count++;
			}
			System.out.println(count);
		}
	}
}
