package Implementation;

import java.util.Scanner;

public class Time {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String time = "";
		int result = 0;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					time = String.valueOf(i) 
							+ String.valueOf(j)
							+ String.valueOf(k);
					if(time.contains("3")) {
						result++;
					}
					time = "";
				}
			}
		}
		
		System.out.println(result);
	}
}
