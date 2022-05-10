package DP;

// 효율적인 화폐 구성

import java.util.Arrays;
import java.util.Scanner;

public class ComposeMoney {
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] money = new int[n];
		for(int i = 0; i < n ;i++) {
			money[i] = sc.nextInt();
		}
		
		int[] d = new int[m+1];
		Arrays.fill(d, 10001);
		
		d[0] = 0;
		
		for(int i = 0; i < n; i++) {
			int k = money[i];
			for(int j = k; j <= m ; j += k) {
				 d[j] = Math.min(d[j], d[j-k] + 1);
			}
		}
		
		if(d[m] == 10001)
			System.out.println(-1);
		else
			System.out.println(d[m]);
		
	}
	

	public static void main(String[] args) {
		ComposeMoney cm = new ComposeMoney();
		cm.solution();
	}

}
