package solved_ac;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 나이순 정렬
// https://www.acmicpc.net/problem/10814
// 22.04.12 못풀었음 (시간초과)

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
		
		selectionSort(n, list);
		
		for(int i=0;i<n;i++) {
			System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
		}
	}
	
	public static void selectionSort(int n, ArrayList<String[]> list) {
		for(int i=0;i<n-1;i++) {
			int j = i + 1;
			while(j > 0) {
				if(Integer.parseInt(list.get(j)[0]) < Integer.parseInt(list.get(j-1)[0])) {
					swap(list, j);
				}
				j--;
			}
		}
	}
	
	public static void swap(ArrayList<String[]> list, int j) {
		String[] temp = new String[2];
		temp = list.get(j-1);
		list.set(j-1, list.get(j));
		list.set(j, temp);
	}

	// Arrays.sort(Array, Comparator) 재정의하여 구현
	// https://st-lab.tistory.com/243
	public static void solution2() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] list = new String[n][2];
		
		for(int i=0;i<n;i++) {
			list[i][0] = sc.next();
			list[i][1] = sc.next();
		}
		
		Arrays.sort(list, new Comparator<String[]>() {
			// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		for(int i=0;i<n;i++) {
			System.out.println(list[i][0] + " " + list[i][1]);
		}
	}
}
