package solved_ac;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 나이순 정렬
// https://www.acmicpc.net/problem/10814

public class P10814 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String[]> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			int age = sc.nextInt();
			String name = sc.next();
			
			list.add(new String[] {String.valueOf(age), name});
		}
		
		
	}
	
	public static void selectionSort(int n, ArrayList<String[]> list) {
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n-1;j++) {
				
				
			}
		}
	}
}
