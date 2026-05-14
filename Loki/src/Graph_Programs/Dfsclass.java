package Graph_Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dfsclass {

	public static void main(String[] args) {
		int v=5;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
		adj.get(0).addAll(Arrays.asList(2,3,1));
		adj.get(1).add(0);
		adj.get(2).addAll(Arrays.asList(0,4));
		adj.get(3).add(0);
		adj.get(4).add(2);
		boolean[] vis =new boolean[v];
		List<Integer> list = new ArrayList<>();
		dfs(0,v,vis,list,adj);
		System.out.println(list);

	}
	static void dfs(int node, int v,boolean[] vis, List<Integer> list, List<List<Integer>> adj) {
		
		if(adj.get(node).size()==0) return;
		if(vis[node])return;
		list.add(node);
		vis[node]=true;
		for(int i:adj.get(node)) {
			if(!vis[i]) {
				dfs(i,v,vis,list,adj);
			}
		}
		
	}
}
