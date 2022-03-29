package programmers;

import java.util.Arrays;

public class Joystick {
	public static int solution(String name) {
        int answer = 0;
        // ���������� �� ���� ���
        int cost = name.length() - 1;
        
        for(int i=0; i<name.length(); i++) {
        	
        	// ���̽�ƽ ���� ������ �Ǵ�
        	if(name.charAt(i) > 'M') {
        		answer += 'Z' - name.charAt(i) + 1;
        	}else {
        		answer += name.charAt(i) - 'A';
        	}
        	
        	// ���̽�ƽ �¿� ������ �Ǵ�
        	int nextIdx = i + 1;
        	
        	// ���ӵ� A �� ���� �ε����� ���� �ε���
        	while(nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	
        	// ���������� �� ���� ���� ���ٰ� �������� ���ư��� Ƚ�� ��
        	cost = Math.min(cost, i * 2 + name.length() - nextIdx);
        	// �� �� ������� ó������ �ڷ� ���ٰ� ���ƿ��� ���� ��
        	cost = Math.min(cost, (name.length() - nextIdx) * 2 + i);
        	
        }
        
        System.out.println(answer + ", " + cost);
        
        
        return answer + cost;
    }
}
