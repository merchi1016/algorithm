package kakaoIntern_2021;

// 거리두기 확인하기
// https://programmers.co.kr/learn/courses/30/lessons/81302#fn1

// 22.04.21 아래 블로그 참조하여 풀었음
// https://velog.io/@topqr123q/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-2021-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EC%9D%B8%ED%84%B4%EC%8B%AD-%EA%B1%B0%EB%A6%AC%EB%91%90%EA%B8%B0-%ED%99%95%EC%9D%B8%ED%95%98%EA%B8%B0-by-Java

public class CheckKeepDistance {
	// 대기실
	public static char[][] room = {};
	// 거리 2 이내 확인을 위한 좌표
	public static int[][] move = {{-2,0}, {0,2}, {2,0}, {0,-2},
								  {-1,0}, {0,1}, {1,0}, {0,-1},
								  {-1, 1}, {1,1}, {1,-1},{-1,-1}};
	
	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		
		for(int i = 0; i < 5; i++) {
			room = makeRoom(places[i]);
			answer[i] = getDistanceStatus();
			System.out.println(answer[i]);
		}
		
		
		return answer;
	}
	
	// 대기실 만들기
	public static char[][] makeRoom(String[] place) {
		char[][] room = new char[5][5];
		
		for(int i = 0; i < place.length; i++) {
			for(int j = 0; j < place[i].length();j++) {
				room[i][j] = place[i].charAt(j);
			}
		}
		return room;
	}
	
	
	// 거리두기 상황 반환하기
	public static int getDistanceStatus() {
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				if(room[x][y] == 'P') {
					if(!isKeepDistance(x, y)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	
	// 전달받은 P 좌표를 기준으로 거리 2이내 거리두기 확인하기
	public static boolean isKeepDistance(int x, int y) {
		for(int i = 0; i < move.length; i++) {
			int _px = x + move[i][0];
			int _py = y + move[i][1];
			
			// 거리 2 이내에 다른 사람이 있다면 각 상황에 맞는 거리두기 확인
			if(isInRange(_px) && isInRange(_py) && room[_px][_py] == 'P') {
				switch(i) {
					case 0:
						if(room[x - 1][y] != 'X') return false;
						break;
					case 1:
						if(room[x][y + 1] != 'X') return false;
						break;
					case 2:
						if(room[x + 1][y] != 'X') return false;
						break;
					case 3:
						if(room[x][y - 1] != 'X') return false;
						break;
					case 4:
					case 5:
					case 6:
					case 7:
						return false;
					case 8:
						if(room[x - 1][y] != 'X' || room[x][y + 1] != 'X') return false;
						break;
					case 9:
						if(room[x][y + 1] != 'X' || room[x + 1][y] != 'X') return false;
						break;
					case 10:
						if(room[x][y - 1] != 'X' || room[x + 1][y] != 'X') return false;
						break;
					case 11:
						if(room[x - 1][y] != 'X' || room[x][y - 1] != 'X') return false;
						break;
				}
			}
		}
		
		return true;
	}
	
	// 배열 범위 내에 있는지 판단
	public static boolean isInRange(int pos) {
		if(pos >= 0 && pos < 5)
			return true;
		else
			return false;
	}
	
}
