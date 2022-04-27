package kakaoblind;

// 키패드 누르기
// https://programmers.co.kr/learn/courses/30/lessons/67256

public class P67256 {
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		
		answer = getResult(numbers, hand, new Hand(10, 12));
		
		System.out.println(answer);
		
		return answer;
	}
	
	public static class Hand{
		private int left;
		private int right;
		
		Hand(int left, int right){
			this.left = left;
			this.right = right;
		}
		
		public int getLeft() {
			return left;
		}
		
		public int getRight() {
			return right;
		}
		
		public void setLeft(int left) {
			this.left = left;
		}
		
		public void setRight(int right) {
			this.right = right;
		}
	}
	
	public static String getResult(int[] numbers, String hand, Hand hState) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				hState.setLeft(numbers[i]);
				sb.append("L");
			}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				hState.setRight(numbers[i]);
				sb.append("R");
			}else {
				int lDist = getDistance(numbers[i], hState.getLeft());
				int rDist = getDistance(numbers[i], hState.getRight());
				
				if(lDist == rDist) {
					if(hand.equals("left")) {
						hState.setLeft(numbers[i]);
						sb.append("L");
					}else {
						hState.setRight(numbers[i]);
						sb.append("R");
					}
				}else if(lDist < rDist){
					hState.setLeft(numbers[i]);
					sb.append("L");
				}else {
					hState.setRight(numbers[i]);
					sb.append("R");
				}
			}
		}
		
		
		return sb.toString();
	}
	
	public static int getDistance(int number, int hIdx) {
		int distance = 0;
		
		number = (number == 0) ? 11 : number;
		hIdx = (hIdx == 0) ? 11 :  hIdx;
		
		int nx = number / 3;
		int ny = 1;
		int hx = (hIdx - 1) / 3;
		int hy = (hIdx - 1) % 3;
		
		distance = Math.abs(nx - hx) + Math.abs(ny - hy);
			
		return distance;
	}
}
