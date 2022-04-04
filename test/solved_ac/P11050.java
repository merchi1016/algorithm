package solved_ac;

// 이항 계수
// https://www.acmicpc.net/problem/11050

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050 {
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = factorial(N) / (factorial(K) * factorial(N-K));
		
		System.out.println(result);
	}
	
	// 팩토리얼 함수
	public static int factorial(int n) {
		if(n == 0)
			return 1;
		
		return n * factorial(n-1);
	}
}
