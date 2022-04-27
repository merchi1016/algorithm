package solved_ac;

// 소수 찾기
// https://www.acmicpc.net/problem/1978
// 44.04.18 solved

import java.util.Scanner;

public class P1978 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(isPrime(arr[i]))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static Boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		
		for(int i = 2;i < num ; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
