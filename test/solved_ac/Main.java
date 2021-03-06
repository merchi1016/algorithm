package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws IOException{
		P1978.solution();
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(isPrime(arr[i]))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static Boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		
		for(int i = 2;i < num ; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
