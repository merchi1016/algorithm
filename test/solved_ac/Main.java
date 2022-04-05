package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	static int max_measure = 1;
	static int min_multiple = 1;
	
	public static void main(String[] args){
		P2609.solution2();
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		getResult(a, b);
		
		System.out.println(max_measure);
		System.out.println(min_multiple);
	}
	
	public static void getResult(int a, int b) {
		int tmp_a = a;
		int tmp_b = b;
		
		while(true) {
			for(int i=1;i<10000;i++) {
				if(tmp_a % i == 0 && tmp_b % i == 0) {
					tmp_a /= i;
					tmp_b /= i;
					max_measure *= i;
					break;
				}
			}
		}
	}
}
