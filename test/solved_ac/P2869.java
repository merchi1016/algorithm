package solved_ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 달팽이는 올라가고 싶다
// https://www.acmicpc.net/problem/2869

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class P2869 {
	// 내 풀이
	// 타임오버
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		// 달팽이가 하루동안 이동한 거리
		int cur = 0;
		// 일 수 카운트
		int cnt = 0;
		
		while(true){
			cnt++;
			cur += A;
			
			if(cur >= V)
				break;
			
			cur -= B;
		}
		
		System.out.println(cnt);
	}
	
	// 다른 사람 풀이
	// https://st-lab.tistory.com/75
	public static void solution2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = (V - B) / (A - B);
		
		if((V - B) % (A - B) != 0)
			day++;
		
		System.out.println(day);
	}
}
