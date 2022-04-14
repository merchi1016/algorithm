package solved_ac;

// 수 찾기
// https://www.acmicpc.net/problem/1920
// 22.04.14 못품. 이진탐색을 구현했긴 했으나 이상해서 블로그보고 다시 수정함
// https://st-lab.tistory.com/261 참조
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class P1920 {
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진 탐색을 위해서는 정렬이 되어있어야 한다.
		Arrays.sort(a);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < m; i++) {
			if(BinarySearch(a, Integer.parseInt(st.nextToken())) != -1) {
				sb.append('1').append('\n');
			}else {
				sb.append('0').append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static int BinarySearch(int[] source, int search) {		
		// 이진 탐색 위치를 나타내는 커서
		int first = 0;
		int last = source.length - 1;
		
		while(last >= first) {
			int mid = (first + last) / 2;
			
			if(source[mid] == search) {
				return mid;
			}else if(source[mid] > search) {
				last = mid -1;
			}else {
				first = mid + 1;
			}
		}
		
		// 값을 찾지 못함
		return -1;
	}
}
