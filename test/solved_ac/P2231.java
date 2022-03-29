package solved_ac;

// 분해합 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_n = br.readLine();
		int nLen = str_n.length();
		int n = Integer.parseInt(str_n);
		int result = 0;
		
		for(int i=n-(nLen * 9);i<n;i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == n) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}	
}
