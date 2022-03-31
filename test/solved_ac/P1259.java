package solved_ac;

import java.util.Scanner;

// 팰린드롬수
// https://www.acmicpc.net/problem/1259

public class P1259 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		while(!s.equals("0")) {
			s = sc.next();
			
			if(s.equals("0"))
				continue;
			
			int sLen = s.length();
			int mid = 0;
			int front = 0;
			int rear = 0;
			
			// 문자열 길이가 홀수라면
			if(sLen % 2 != 0) {
				mid = sLen / 2;
				front = mid-1;
				rear = mid+1;
				
				checkEquals(sLen, s, front, rear);
			}else { // 문자열 길이가 짝수라면
				mid = (sLen / 2)-1;
				front = mid;
				rear = mid+1;
				
				checkEquals(sLen, s, front, rear);
			}
		}
	}
	
	public static void checkEquals(int sLen, String s, int front, int rear) {
		while(front >= 0 && rear <= sLen-1) {
			if(s.charAt(front) == s.charAt(rear)) {
				front--;
				rear++;
			}else {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}
}
