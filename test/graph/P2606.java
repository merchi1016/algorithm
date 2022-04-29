package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 바이러스
// https://www.acmicpc.net/problem/2606

public class P2606 {
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		GraphInfo gi = new GraphInfo(v);
	
		for(int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프이므로 연결된 정점 모두 표현
			gi.setGraph(start, end);
		}
		
		dfs(gi, 1);
		
		System.out.println(gi.getVisitedCnt() - 1);
	}
	
	// 그래프 정보
	public static class GraphInfo{
		private ArrayList<ArrayList<Integer>> graph;
		private boolean[] visited;
		
		GraphInfo(int v){
			graph = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[v+1];
			
			// graph 초기화 ( 정점 번호로 접근하기 위해 idx 0번은 사용하지 않는다. 따라서 v+1 개만큼 생성)
			for(int i = 0; i <= v; i++) {
				graph.add(new ArrayList<Integer>());
			}
		}
		
		// 그래프 반환
		public ArrayList<ArrayList<Integer>> getGraph(){
			return graph;
		}
		
		// 그래프에 연결된 정점 정보 등록
		public void setGraph(int start, int end) {
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		// 방문 처리
		public void setVisited(int n) {
			visited[n] = true;
		}
		
		// 방문 현황 반환
		public boolean isVisited(int n) {
			return visited[n];
		}
		
		// 방문한 정점 개수 반환
		public int getVisitedCnt() {
			int cnt = 0;
			for(int i = 0; i < visited.length; i++) {
				if(visited[i])
					cnt++;
			}
			return cnt;
		}
	}
	
	// DFS
	public static void dfs(GraphInfo gi, int v) {
		gi.setVisited(v);
		
		ArrayList<Integer> arrVer = gi.getGraph().get(v);
		for(int ver : arrVer) {
			if(!gi.isVisited(ver))
				dfs(gi, ver);
		}
	}
	
	public static void main(String[] args) throws IOException {
		solution();
	}
}
