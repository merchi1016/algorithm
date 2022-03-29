package solved_ac;

import java.util.Arrays;
import java.util.Scanner;

// ∫Ì∑¢¿Ë πÆ¡¶
public class P2798 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int result = 0;
		int max = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=N-1;i>=2;i--) {
			for(int j=i-1;j>=1;j--) {
				for(int k=j-1;k>=0;k--) {
					int temp = arr[i] + arr[j] + arr[k];
					
					if(temp == M) {
						System.out.println(temp);
						return ;
					}
						
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		System.out.println(result);
	}
}
