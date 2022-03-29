package Implementation;

import java.util.Scanner;

public class UpDownLeftRight {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine(); // ���� ����
		String direction = sc.nextLine();
		String[] split_dir = direction.split(" ");
		
		// pos[0] : x��ǥ , pos[1] : y��ǥ
		int[] pos = new int[2];
		pos[0] = 1;
		pos[1] = 1;
		
		for(int i=0; i<split_dir.length; i++) {
			switch(split_dir[i]) {
				case "U":
					if(pos[1] - 1 > 0)
						pos[1] -= 1;
					break;
				case "L":
					if(pos[0] -1 > 0 )
						pos[0] -= 1;
					break;
				case "R":
					if(pos[0] + 1 <= n)
						pos[0] += 1;
					break;
				case "D":
					if(pos[1] + 1 <= n)
						pos[1] += 1;
					break;
			}
		}
		
		// ���� y ��ǥ, ���� x ��ǥ
		System.out.println(pos[1] + " " + pos[0]);
	}
}
