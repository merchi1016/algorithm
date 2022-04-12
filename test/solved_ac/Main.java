package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws IOException{
		solution();
	}
	
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			arrList.add(num);
		}
		
		Collections.sort(arrList);
		
		for(int value : arrList) {
			sb.append(value).append('\n');
		}
		
		System.out.println(sb);
	}
}
