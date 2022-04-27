package kakaoIntern_2021;

// 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301

public class StringNumber {
	public static int solution(String s) {
		int answer = 0;
		String[] strNum = {"zero", "one", "two", "three", "four", "five",
							"six", "seven", "eight", "nine"};
		String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i=0;i<9;i++) {
			s = s.replaceAll(strNum[i], number[i]);
		}
        answer = Integer.parseInt(s);

		return answer;
	}
}
