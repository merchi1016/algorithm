package solved_ac;

import java.util.Scanner;

// 최대 공약수, 최소 공배수
// https://www.acmicpc.net/problem/2609

// 22.04.05 못풀었음
// https://st-lab.tistory.com/154

public class P2609 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int max_measure = 1;
		int min_multiple = 1;
		
		int tmp_a = a;
		int tmp_b = b;
		
		while(true) {
			if(tmp_a % 3 == 0 && tmp_b % 3 == 0) {
				tmp_a /= 3;
				tmp_b /= 3;
				max_measure *= 3;
			}else if(tmp_a % 2 == 0 && tmp_b % 2 == 0) {
				tmp_a /= 2;
				tmp_b /= 2;
				max_measure *= 2;
			}else {
				min_multiple = max_measure * tmp_a * tmp_b;
				break;
			}
		}
		
		System.out.println(max_measure);
		System.out.println(min_multiple);
	}
	
	public static void solution2() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = gcd(a, b);
		int lcm = a * b / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	public static int gcd(int a, int b) {
		int r = 0;
		while(b != 0) {
			r = a % b;
			
			a = b;
			b = r;
		}
		
		return a;
	}
}
