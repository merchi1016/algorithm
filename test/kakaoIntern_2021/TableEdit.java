package kakaoIntern_2021;

import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 표 편집
// https://programmers.co.kr/learn/courses/30/lessons/81303

public class TableEdit {
	static Stack<Integer> stack = new Stack<>();
	static HashMap<Integer, Character> map = new HashMap<>();
	static LinkedList<String> linkedList = new LinkedList<String>();
	static LinkedList<Node> lnkList = new LinkedList<Node>();
	static Stack<Node> stk = new Stack<Node>();
	static Node root = null;
	static Node curNode = null;
	static Node tail = null;

	// 예제는 통과했으나 정확성 및 효율성 테스트 실패
	public static String solution(int n, int k, String[] cmd) {
		StringBuilder sb = new StringBuilder();
		
		// 처음 선택된 셀
		int sIdx = k;
		
		for(int i = 0; i < n; i++) {
			map.put(i, 'O');
		}
		
		for(int i = 0; i < cmd.length; i++) {
			sIdx = doCmdReturnK(n, sIdx, cmd[i]);
		}
		
		for(Integer i : map.keySet()) {
			char c = map.get(i);
			sb.append(c);
		}
		
	
		System.out.println("\"" + sb + "\"");
		
		
		return sb.toString();
	}
	
	// cmd 명령어 실행하고 선택된 행 반환
	public static int doCmdReturnK(int n, int k, String cmd) {
		if(cmd.equals("C")) {
			stack.push(k);
			map.replace(k, 'X');
			
			if(k == n - 1) {
				return getNextIdx(k - 1, 'U');
			}else{
				return getNextIdx(k + 1, 'D');
			}
		}else if(cmd.equals("Z")){
			int p = stack.pop();
			map.replace(p, 'O');
			
			return k;
		}else {
			String[] split_cmd = {};
			split_cmd = cmd.split(" ");
			int c_num = Integer.parseInt(split_cmd[1]);
			
			if(split_cmd[0].equals("U")) {
				return getNextIdx(k - c_num, 'U');
			}else {
				return getNextIdx(k + c_num, 'D');
			}
		}
	}
	
	// 삭제할 때 다음 인덱스 반환
	public static int getNextIdx(int nIdx, char dir) {
		if(map.get(nIdx) == 'O')
			return nIdx;
		
		if(dir == 'U')
			return getNextIdx(nIdx - 1, 'U');
		else
			return getNextIdx(nIdx + 1, 'D');
	}
	
	// 카카오 해설 참조하여 링크드 리스트로 구현했으나 정확성, 효율성 실패
	public static String solution2(int n, int k, String[] cmd) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		// 첫 선택된 행
		int cur = k;
		
		for(int i = 0; i < n; i++) {
			linkedList.add("O");
		}
		
		for(int i = 0; i < cmd.length; i++) {
			if(cmd[i].contains("C")) {
				stack.add(cur);
				linkedList.set(cur, "X");
				
				if(cur == n - 1)
					cur = getNextIdx(cur, 1, "U");
				else
					cur = getNextIdx(cur, 1, "D");
				
			}else if(cmd[i].contains("Z")) {
				int rIdx = stack.pop();
				linkedList.set(rIdx, "O");
			}else {
				String[] split_cmd = cmd[i].split(" ");
				String dir = split_cmd[0];
				int num = Integer.parseInt(split_cmd[1]);
				
				cur = getNextIdx(cur, num, dir);
			}
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(linkedList.get(i));
		}
		
		
		answer = sb.toString();
		
		System.out.println(answer);
		
		return answer;
	}
	
	public static int getNextIdx(int cur, int num, String dir) {
		int cnt = 0;
		int term = 1;
		while(true) {
			if(dir.equals("U")) {
				if(linkedList.get(cur - term).equals("O")) {
					cnt++;
				}
			}else{
				if(linkedList.get(cur + term).equals("O")) {
					cnt++;
				}
			}
			
			if(num == cnt)
				break;
			
			term++;
		}
		
		if(dir.equals("U"))
			return cur - term;
		else
			return cur + term;
	}
	
	
	public static String solution3(int n, int k, String[] cmd) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		init(n, k);
		ExecuteCmd(k, cmd);
		
		for(int i = 0; i < n; i++) {
			if(root.data == i) {
				sb.append("O");
				root = root.next;
			}else {
				sb.append("X");
			}
		}
		
		answer = sb.toString();
		
		System.out.println(answer);
		
		return answer;
	}
	
	// 입력 데이터 초기화
	public static void init(int n, int k) {

		// root 초기화
		root = new Node(0);
		// curNode 초기화
		curNode = root;
		
		// linkedList 초기화
		Node nNode = curNode;
		for(int i = 1; i < n; i++) {
			Node node = new Node(i);
			nNode.next = node;
			node.pre = nNode;
			nNode = node;
		}
		
		// tail 초기화
		tail = nNode;
		
		// curNode 설정
		while(k-- > 0) {
			curNode = curNode.next;
		}
	}
	
	// 명령어 수행하기
	public static void ExecuteCmd(int k, String[] cmd) {
		// 현재 위치
		int cIdx = k;
		
		for(int i = 0; i < cmd.length; i++) {
			char cmd_e = cmd[i].charAt(0);
			int n = 0;
			
			if(cmd_e == 'U' || cmd_e == 'D') {
				n = Integer.parseInt(cmd[i].substring(2));
			}
			
			switch(cmd_e) {
				case 'U':
					for(int j = 0; j < n; j++) {
						curNode = curNode.pre;
					}
					break;
				case 'D':
					for(int j = 0; j < n; j++) {
						curNode = curNode.next;
					}
					break;
				case 'C':
					stk.push(curNode);
					
					if(curNode == root) {
						curNode.next.pre = curNode.pre;
						root = curNode.next;
						curNode = root;
					}else if(curNode == tail) {
						curNode.pre.next = curNode.next;
						tail = curNode.pre;
						curNode = tail;
					}else {
						curNode.pre.next = curNode.next;
						curNode.next.pre = curNode.pre;
						curNode = curNode.next;
					}
					break;
				case 'Z':
					Node rNode = stk.pop();

					if(rNode.pre != null) {
                        rNode.pre.next = rNode;
					}
                    if(rNode.next != null) {
                        rNode.next.pre = rNode;	
					}
					
					if(rNode.data < root.data)
						root = rNode;
					else if(rNode.data > tail.data)
						tail = rNode;
					break;
			}
		}
	}
	
	public static String makeAnswer(int n) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			if(root.data == i) {
				sb.append("O");
				root = root.next;
			}else {
				sb.append("X");
			}
		}
		
		return sb.toString();
	}
	
	public static class Node{
		Node pre;
		Node next;
		int data;
		
		Node(int data){
			this.pre = null;
			this.next = null;
			this.data = data;
		}
	}
}
