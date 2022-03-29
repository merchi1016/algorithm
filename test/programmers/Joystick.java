package programmers;

import java.util.Arrays;

public class Joystick {
	public static int solution(String name) {
        int answer = 0;
        // 오른쪽으로 쭉 가는 경우
        int cost = name.length() - 1;
        
        for(int i=0; i<name.length(); i++) {
        	
        	// 조이스틱 상하 움직임 판단
        	if(name.charAt(i) > 'M') {
        		answer += 'Z' - name.charAt(i) + 1;
        	}else {
        		answer += name.charAt(i) - 'A';
        	}
        	
        	// 조이스틱 좌우 움직임 판단
        	int nextIdx = i + 1;
        	
        	// 연속된 A 가 끝난 인덱스가 다음 인덱스
        	while(nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	
        	// 오른쪽으로 쭉 가는 경우와 갔다가 왼쪽으로 돌아가는 횟수 비교
        	cost = Math.min(cost, i * 2 + name.length() - nextIdx);
        	// 위 비교 결과값과 처음부터 뒤로 갔다가 돌아오는 경우와 비교
        	cost = Math.min(cost, (name.length() - nextIdx) * 2 + i);
        	
        }
        
        System.out.println(answer + ", " + cost);
        
        
        return answer + cost;
    }
}
