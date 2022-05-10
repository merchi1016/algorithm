package DP;

// 바닥공사
import java.util.Scanner;

public class FloorWork {
	public static int[] d = new int[1000];
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		d[1] = 1;
		d[2] = 3;
		
		for(int i = 3; i <= n ;i++) {
			d[i] = d[i-1] + d[i-2] * 2;
		}
		
		int result = d[n] % 796796;
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		FloorWork fw = new FloorWork();
		fw.solution();
	}

}
