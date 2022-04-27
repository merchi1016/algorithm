package kakaoblind;

// 신규 아이디 추천
// https://programmers.co.kr/learn/courses/30/lessons/72410

public class P72410 {
	public static String solution(String new_id) {
		String answer = "";
		String regex_step2 = "[^a-z0-9-_.]";
		String regex_step3 = "\\.+";
		String regex_step4 = "^\\.";
		String regex_step4_2 = "\\.$";
		
		// step 1. 대문자 -> 소문자 치환
		new_id = new_id.toLowerCase();
		
		// step 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외한 문자 제거하기
		new_id = new_id.replaceAll(regex_step2, "");
		
		// step 3. '.' 이 2번 이상 연속된 부분 하나의 마침표로 치환
		new_id = new_id.replaceAll(regex_step3, ".");
		
		// step 4. 마침표가 처음이나 끝에 위치하면 제거하기
		new_id = new_id.replaceAll(regex_step4, "");
		new_id = new_id.replaceAll(regex_step4_2, "");
		
		// step 5. new_id 가 빈 문자열이라면 a 대입하기
		if(new_id.isEmpty())
			new_id = "a";
		
		// step 6. new_id 길이가 16자 이상이면, 첫 15개 문자만 남기고 제거
		// 제거 후 끝문자가 . 이면 제거하기
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if(new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		
		// step 7. new_id 가 길이 2자 이하이면, new_id 마지막 문자를 길이 3이 될때까지 더하기
		if(new_id.length() <= 2) {
			while(new_id.length() != 3) {
				new_id += new_id.charAt(new_id.length() - 1);
			}
		}
				
		System.out.println(new_id);
		
		
		return answer;
	}
	
	public static String solution2(String new_id) {
		String answer = "";
		
		answer = new KAKAOID(new_id)
				.replaceToLowerCase()
				.eraseOtherText()
				.eraseDotOverTwo()
				.eraseDotFirstEnd()
				.insertIsEmpty()
				.cutIDLengthEraseDot()
				.insertIsLengthLessTwo()
				.getID();
		
		System.out.println(answer);
		
		return answer;
	}
	
	private static class KAKAOID{
		private String s;
		private String reg_step2 = "[^a-z0-9-_.]";
		private String reg_step3 = "[.]{2,}";
		private String reg_step4 = "^[.]|[.]$";
		
		KAKAOID(String s){
			this.s = s;
		}
		
		private KAKAOID replaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		
		private KAKAOID eraseOtherText() {
			s = s.replaceAll(reg_step2, "");
			return this;
		}
		
		private KAKAOID eraseDotOverTwo() {
			s = s.replaceAll(reg_step3, ".");
			return this;
		}
		
		private KAKAOID eraseDotFirstEnd() {
			s = s.replaceAll(reg_step4, "");
			return this;
		}
		
		private KAKAOID insertIsEmpty() {
			s = s.isEmpty() ? "a" : s;
			return this;
		}
		
		private KAKAOID cutIDLengthEraseDot() {
			if(s.length() >= 16) {
				s = s.substring(0, 15);
			}
			s = s.replaceAll(reg_step4, "");
			return this;
		}
		
		private KAKAOID insertIsLengthLessTwo() {
			StringBuilder sb = new StringBuilder(s);
			if(s.length() <= 2) {
				while(sb.length() != 3) {
					sb.append(s.charAt(s.length() - 1));
				}
				s = sb.toString();
			}
			return this;
		}
		
		private String getID() {
			return s;
		}
	}
}
