package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumber {
	public static int solution() {
		int answer = 0;
		int max = 0;
		int max2 = 0;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// N, M, K ���� �������� �����Ͽ� �Է� �ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int data[] = new int[n];
		
		// �ι�° �� ��� ������ �Է¹ޱ�
		for(int i=0;i<n;i++) {
			data[i] = sc.nextInt();
		}
		
		Arrays.sort(data);
		
		max = data[n-1];
		max2 = data[n-2];
		
		for(int i=0;i<m;i++) {
			if(cnt == k) {
				answer += max2;
				cnt = 0;
			}else{
				answer += max;
				cnt++;
			}
		}
		
		return answer;
	}
}
