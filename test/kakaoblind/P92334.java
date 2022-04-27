package kakaoblind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 신고 결과 받기
// https://programmers.co.kr/learn/courses/30/lessons/92334

public class P92334 {
	
	// 그냥 무식하게 코딩
	public static int[] solution(String[] id_list, String[] report, int k) {
		int idLen = id_list.length;
		int repLen = report.length;
		
		int[] answer = new int[idLen];
		
		// 신고당한 횟수 저장하는 배열
		int[] report_cnt = new int[idLen];
		// id_list 의 id index 에 바로 접근할 수 있도록하는 hashmap
		HashMap<String, Integer> id_map = new HashMap<>();
		// 신고당한 사람의 횟수를 기록하는 hashMap
		HashMap<String, Integer> repo_map = new HashMap<>();
		ArrayList<ArrayList<String>> repo_arr = new ArrayList<ArrayList<String>>();
		
		// Hashmap : 신고한 id_list index 접근을 쉽게 하기 위함
		// arrayList : 각 id_list index 에 맞게 신고한 사람을 저장할 arrayList 생성 
		for(int i = 0; i < idLen; i++) {
			id_map.put(id_list[i], i);
			repo_map.put(id_list[i], 0);
			repo_arr.add(new ArrayList<String>());
		}
		
		// 신고 현황 기록하기
		for(int i = 0; i < repLen; i++) {
			// 중복 신고 확인
			boolean check_dup = false;
			StringTokenizer st = new StringTokenizer(report[i]);
			String repo = st.nextToken();
			String reported = st.nextToken();
			int rIdx = id_map.get(repo);
			int rptIdx = id_map.get(reported);
			
			// 중복된 신고인지 확인
			for(int j = 0; j < repo_arr.get(rIdx).size(); j++) {
				if(repo_arr.get(rIdx).get(j).equals(reported))
					check_dup = true;
			}
			
			if(check_dup != true) {
				// 신고한 사람 내역 등록
				repo_arr.get(rIdx).add(reported);
				// 신고당한 사람 횟수 증가
				int repo_cnt = repo_map.get(reported);
				repo_map.replace(reported, repo_cnt + 1);
			}
		}
		
		// 유저별 신고당한 횟수 확인
		for(String id:repo_map.keySet()) {
			if(repo_map.get(id) >= k) {
				for(int i = 0; i < repo_arr.size();i++) {
					for(int j = 0; j < repo_arr.get(i).size(); j++) {
						if(id.equals(repo_arr.get(i).get(j))) {
							answer[i]++;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < idLen; i++) {
			System.out.println(answer[i]);
		}
		
		
		return answer;
	}
	
	// 다른사람 풀이 참고
	public static int[] solution2(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> idIdxMap = new HashMap<>();
		HashMap<String, HashSet<String>> repoMap = new HashMap<>();
		
		// 데이터 초기화
		for(int i = 0; i < id_list.length; i++) {
			idIdxMap.put(id_list[i], i);
			repoMap.put(id_list[i], new HashSet<String>());
		}
		
		// 신고 현황 등록 ( key : 신고당한 사람, value : 신고한 사람)
		for(String repo : report) {
			String[] split = repo.split(" ");
			
			if(!repoMap.get(split[1]).contains(split[0])) {
				repoMap.get(split[1]).add(split[0]);
			}
		}
		
		// 신고 횟수 확인
		for(String id : repoMap.keySet()) {
			if(repoMap.get(id).size() >= k) {
				for(String reporter:repoMap.get(id)) {
					answer[idIdxMap.get(reporter)]++;
				}
			}
		}
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
	}
}
