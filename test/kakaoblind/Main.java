package kakaoblind;

public class Main {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] id_list2 = {"con", "ryan"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo",
							"muzi neo","apeach muzi"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		int k2 = 3;
		//P92334.solution(id_list, report, k);
		//P92334.solution(id_list2, report2, k2);
		
		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
		String new_id2 = "z-+.^.";
		String new_id3 = "=.=";
		String new_id4 = "123_.def";
		String new_id5 = "abcdefghijklmn.p";
		
		//P72410.solution2(new_id1);
		//P72410.solution2(new_id2);
		//P72410.solution2(new_id3);
		//P72410.solution2(new_id4);
		//P72410.solution2(new_id5);
		
		int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		String hand1 = "right";
		String hand2 = "left";
		String hand3 = "right";
		
		//P67256.solution(numbers1, hand1);
		//P67256.solution(numbers2, hand2);
		//P67256.solution(numbers3, hand3);
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		P64061.solution(board, moves);
	}
}
