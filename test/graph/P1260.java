package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// DFS , BFS
// https://www.acmicpc.net/problem/1260

public class P1260 {
	public static void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		GraphInfo gi = new GraphInfo(n);
		
		// 인접 리스트에 연결된 정점 정보 저장
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			gi.addEdge(start, end);
			gi.addEdge(end, start);
		}
		gi.sortList();
		
		dfs(gi, v);
		System.out.println();
		gi.resetVisited(n);
		bfs(gi, v);
		
	}
	
	public static void dfs(GraphInfo gi, int n) {
		gi.setVisited(n);
		
		System.out.print(n + " ");
		
		ArrayList<Integer> vList = gi.getList().get(n);
		
		for(int ver : vList) {
			if(!gi.getVisited(ver)) {
				dfs(gi, ver);
			}
		}
	}
	
	public static void bfs(GraphInfo gi, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		gi.setVisited(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			System.out.print(x + " ");
			
			ArrayList<Integer> vList = gi.getList().get(x);
		
			for(int ver : vList) {
				if(!gi.getVisited(ver)) {
					q.offer(ver);
					gi.setVisited(ver);
				}
			}
		}
	}
	
	public static class GraphInfo{
		private boolean[] vi;
		private ArrayList<ArrayList<Integer>> list;
		
		GraphInfo(int n){
			vi = new boolean[n + 1];
			list = new ArrayList<ArrayList<Integer>>();
			
			// 인접 리스트 초기화
			for(int i = 0; i <= n; i++) {
				list.add(new ArrayList<Integer>());
			}
		}
		
		public boolean getVisited(int n) {
			return vi[n];
		}
		
		public ArrayList<ArrayList<Integer>> getList(){
			return list;
		}
		
		public void setVisited(int n) {
			vi[n] = true;
		}
		
		public void addEdge(int v, int e) {
			list.get(v).add(e);
		}
		
		public void sortList() {
			for(int i = 0; i < list.size(); i++) {
				Collections.sort(list.get(i));
			}
		}
		
		public void resetVisited(int n) {
			vi = new boolean[n + 1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		solution();
	}
}
