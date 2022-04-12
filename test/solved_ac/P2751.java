package solved_ac;

import java.util.Arrays;

// 수 정렬하기 2
// https://www.acmicpc.net/problem/2751

import java.util.Scanner;

public class P2751 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
