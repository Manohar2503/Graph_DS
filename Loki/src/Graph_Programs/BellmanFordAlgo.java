package Graph_Programs;

import java.util.Arrays;

public class BellmanFordAlgo {

	// single source shortest path it contains neg weight and aslo detects the negetive cycle
	// principle of bellmanford algo is relaxation of Edges
	public static void main(String[] args) {
		int v=5;
		int[][] graph = {{0, 1, 1},
	            {1, 2, 3},
	            {2, 3, 2},
	            {3, 1, -6}};
		int[] arr = bellman(v,graph,0);
		
		for(int val:arr) {
			System.out.print(val +" ");
		}
	}
	
	static int[] bellman(int v, int[][] graph,int src) {
		int[] dist = new int[v];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		
		for(int i=0;i<v;i++) {
			for(int[] sub:graph) {
				
				int u = sub[0];
				int ver = sub[1];
				int wt = sub[2];
				
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt < dist[ver]) {
					if(i==v-1)
						return new int[] {-1};
					dist[ver] = dist[u] + wt;
				}
//				for(int val:dist) {
//					if(val==Integer.MAX_VALUE) System.out.print(-1 +" ");
//					else System.out.print(val+" ");
//				}
//				System.out.println();
			}
//			System.out.println();
		}
		return dist;
	}
}
