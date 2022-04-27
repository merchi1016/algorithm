package kakaoIntern_2021;

public class Main {

	public static void main(String[] args) {
		/* CheckKeepDistance 데이터
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
		                     {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
		                     {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
		                     {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
		                     {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		CheckKeepDistance.solution(places);
		*/
		
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		TableEdit.solution3(8, 2, cmd);
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		TableEdit.solution3(8, 2, cmd2);
	}

}
