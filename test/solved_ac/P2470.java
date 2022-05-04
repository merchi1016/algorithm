package solved_ac;

// 두 용액
// https://www.acmicpc.net/problem/2470

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
	
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] result = new int[2];
		int sIdx = 0, eIdx = (n-1), min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬하기
		Arrays.sort(arr);
		
		while(sIdx < eIdx) {
			int sum = arr[sIdx] + arr[eIdx];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = arr[sIdx];
				result[1] = arr[eIdx];
				
				if(sum == 0)
					break;
			}
			
			if(sum < 0) {
				sIdx++;
			}else {
				eIdx--;
			}
		}
		
		System.out.println(result[0]+ " " + result[1]);
	}
	
	public static void main(String[] args) throws IOException {
		 solution();
	}

}
