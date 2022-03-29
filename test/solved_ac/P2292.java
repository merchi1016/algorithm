package solved_ac;

// ¹úÁý ¹®Á¦

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2292 {
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// °ã ¼ö
		int count = 1;
		// ¹üÀ§
		int range = 2;
		
		if(N == 1) {
			System.out.println(1);
		}else {
			while(range <= N) {
				range = range + (count * 6);
				count++;
			}
			System.out.println(count);
		}
	}
}
