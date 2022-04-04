package solved_ac;

// 단어 정렬
// https://www.acmicpc.net/problem/1181

// 22.04.04 못풀었음 -> 정렬 방법을 고민하다가 병합 정렬을 시도했으나 제대로 되지 않음
// https://st-lab.tistory.com/112

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
import java.util.Scanner;

public class P1181 {
	public static void solution() throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] data = new String[num];
		
		sc.nextLine();
		
		for(int i=0;i<num;i++) {
			data[i] = sc.nextLine();
		}
		
		MergeSort(data, 0, num-1);
		
		for(int i=0;i<num;i++) {
			System.out.println(data[i]);
		}
	}
	
	public static void MergeSort(String[] data, int left, int right) {
		int mid;
		
		if(left < right) {
			mid = (left + right) / 2;
			
			MergeSort(data, left, mid);
			MergeSort(data, mid+1, right);
			
			MergeTwoArea(data, left, mid, right);
		}
	}
	
	public static void MergeTwoArea(String[] data, int left, int mid, int right) {
		int fIdx = left;
		int rIdx = mid + 1;
		int i;
		
		String[] sortArr = new String[right+1];
		int sIdx = left;
		
		while(fIdx <= mid && rIdx <= right) {
			if(data[fIdx].length() < data[rIdx].length()) {
				sortArr[sIdx] = data[fIdx++];
			}else if(data[fIdx].length() == data[rIdx].length()) {
				if(data[fIdx].compareTo(data[rIdx]) < 0) {
					sortArr[sIdx] = data[fIdx++];
				}else {
					sortArr[sIdx] = data[rIdx++];
				}
			}else {
				sortArr[sIdx] = data[rIdx++];
			}
			sIdx++;
		}
		
		if(fIdx > mid) {
			for(i=rIdx;i<=right; i++,sIdx++) {
				sortArr[sIdx] = data[i];
			}
		}else {
			for(i=fIdx;i<=mid; i++,sIdx++) {
				sortArr[sIdx] = data[i];
			}
		}
		
		data = Arrays.copyOf(sortArr, sortArr.length);
	}
	
	public static void solution2() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] data = new String[num];
		
		sc.nextLine();
		
		for(int i=0;i<num;i++) {
			data[i] = sc.nextLine();
		}
		
		Arrays.sort(data, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())
					return s1.compareTo(s2);
				else
					return s1.length() - s2.length();
			}
		});
		
		System.out.println(data[0]);
		
		for(int i=1;i<num;i++) {
			if(!data[i].equals(data[i-1])) {
				System.out.println(data[i]);
			}
		}
	}
}
