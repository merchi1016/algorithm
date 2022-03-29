package greedy;

import java.util.Scanner;

public class DoitNoOne {
	public static int solution() {
		int answer = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		
		while(n != 1) {
			if(n % k == 0) {
				n /= k;
				cnt++;
			}else {
				n -= 1;
				cnt++;
			}
		}
		
		answer = cnt;
		
		return answer;
	}
}
 