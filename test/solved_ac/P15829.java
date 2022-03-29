package solved_ac;

import java.util.Scanner;
// hashing 문제

public class P15829 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String S = sc.next();
		long result = 0;
		long pow = 1;
		long M = 1234567891;
		
		for(int i=0;i<L;i++) {
			result += (S.charAt(i) -'a' + 1) * pow;
			pow = (pow * 31) % M;
		}
		
		System.out.println(result % M);
	}
}
