package Graph_Programs;
import java.util.*;
public class Bfsclass {

//	Input: V = 5, adj = [[2, 3, 1], [0], [0, 4], [0], [2]]
//
//			Output:[0, 2, 4, 3, 1], [0, 2, 3, 1, 4]
	
	public static void main(String[] args) {
		int v=5;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
		adj.get(0).addAll(Arrays.asList(2,3,1));
		adj.get(1).add(0);
		adj.get(2).addAll(Arrays.asList(0,4));
		adj.get(3).add(0);
		adj.get(4).add(2);
	
		List<Integer> list = new ArrayList<>();
		bfs(v, list,adj);
		System.out.println(list);
	}
	
	static void bfs(int v,List<Integer> list, List<List<Integer>> adj) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[v];
		q.offer(0);
		vis[0]=true;
		
		while(!q.isEmpty()) {
			int val = q.poll();
			list.add(val);
			for(int i:adj.get(val)) {
				if(!vis[i]) {
					q.offer(i);
					vis[i]=true;
				}
			}
		}
	}

}
