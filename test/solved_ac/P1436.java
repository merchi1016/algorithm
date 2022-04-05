package solved_ac;

import java.util.Scanner;

// 영화감독 숌
// https://www.acmicpc.net/problem/1436

// 22.04.05 문제를 제대로 이해 못해서 블로그 참조하여 이해했음
// https://st-lab.tistory.com/103

public class P1436 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fnum = 666;
		int cnt = 0;
		
		while(true) {
			if(n == cnt)
				break;
			
			String str_fnum = String.valueOf(fnum);
			
			if(str_fnum.contains("666")) {
				cnt++;
			}
			
			fnum++;
		}
		
		System.out.println(fnum-1);
		
	}
}
