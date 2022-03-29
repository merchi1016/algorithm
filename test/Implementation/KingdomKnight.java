package Implementation;

import java.util.Scanner;

public class KingdomKnight {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		// ��ġ �Է¹ޱ�
		String pos = sc.next();
		int row = pos.charAt(1) - '0';
		int column = pos.charAt(0) - 'a' + 1;
		
		// �̵��� �� �ִ� 8���� ���� ����
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		// 8���� ���� ��ġ �̵� �������� Ȯ��
		int result = 0;
		for(int i = 0; i < 8; i++) {
			// �̵��ϰ��� �ϴ� ��ġ Ȯ��
			int nextRow = row + dx[i];
			int nextCol = column + dy[i];
			
			// �ش� ��ġ�� �̵� �����ϸ� ī��Ʈ ����
			if(nextRow >= 1 && nextRow <=8 &&
					nextCol >= 1 && nextCol <= 8) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
