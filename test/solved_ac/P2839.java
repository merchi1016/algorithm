package solved_ac;

import java.util.Scanner;
// 설탕 배달
// https://www.acmicpc.net/problem/2839
public class P2839 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 나누고 난 후 중간 과정 저장
		int tmp = N;
		int result = 0;
		
		// 먼저 5로 얼마나 나눌수 있는지 확인
		int f_cycle = N / 5;
		
		// 5를 최대한 나눈 수가 3의 배수일 때까지 확인
		for(int i=f_cycle;i>0;i--) {
			int mod = N - (5 * i);
			
			if(mod % 3 == 0) {
				tmp = mod;
				result += i;
				break;
			}
		}
		
		// 3으로도 완전히 나눠질 수 없으면 -1
		if(tmp % 3 != 0) {
			System.out.println(-1);
		}else { // 3으로 나눠지는 경우 더하기
			result += tmp / 3;
			System.out.println(result);
		}
	}
}
