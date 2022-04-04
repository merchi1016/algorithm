package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	public static void main(String[] args)throws IOException{
		solution();
	}
	
	public static void solution() {
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
