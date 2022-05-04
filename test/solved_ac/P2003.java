package solved_ac;

// 수들의 합 2
// https://www.acmicpc.net/problem/2003

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
	
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int s = 0, e = 0, sum = 0, cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(sum >= m) {
				sum -= arr[s++];
			}else if(e == n){
				break;
			}else {
				sum += arr[e++];
			}
			
			if(sum == m) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException{
		solution();
	}

}
