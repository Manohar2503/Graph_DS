package Graph_Programs;
import java.util.*;
public class Dijkstras_algo {

	// single source shortest path it doesn't contain any negetive weight
//	input: src = 0, adj[][] = [[[1, 4], [2, 8]],         
//                              [[0, 4], [4, 6], [2,3]], 
//                              [[0, 8], [3, 2], [1,3]], 
//                              [[2, 2], [4, 10]], 
//                              [[1, 6], [3, 10]]]
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of vertices: ");
		int n = sc.nextInt();
		
		System.out.println("enter the edges: ");
		int e = sc.nextInt();
		System.out.println("Enter the u->v , distance : ");
		int[][] edges = new int[e][3];
		for(int i =0;i<e;i++) {
			for(int j=0;j<3;j++) {
				edges[i][j]=sc.nextInt();
			}
		}
		
		int[] result = dijkstras(n,edges,0);
		System.out.println("Shortest distance for all nodes from node"+ 0+ ":");
		
		for(int val:result) {
			System.out.print(val+" ");
		}
	}
	private static int[] dijkstras(int v, int[][] edges, int src) {
		List<List<List<Integer>>> adj = createAdj(v,edges);
		PriorityQueue<List<Integer>>  pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.get(0)));
		int[] dist = new int[v];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		temp.add(src);
		pq.offer(temp);
		while(!pq.isEmpty()) {
			List<Integer> curr = pq.poll();
			int u = curr.get(1);
			for(List<Integer> sublist :adj.get(u)) {
				int vertex = sublist.get(0);
				int weight = sublist.get(1);
				if(dist[vertex] > dist[u]+weight) {
					dist[vertex] = dist[u]+weight;
					List<Integer> temp1 = new ArrayList<>();
					temp1.add(dist[vertex]);
					temp1.add(vertex);
					pq.offer(temp1);
				}
			}
		}
		return dist;
	}
	
	private static List<List<List<Integer>>> createAdj(int v, int[][] edges){
		List<List<List<Integer>>> adj = new ArrayList<>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge:edges) {
			int u = edge[0];
			int ver= edge[1];
			int weight = edge[2];
			ArrayList<Integer> e1 = new ArrayList<>();
			e1.add(ver);
			e1.add(weight);
			adj.get(u).add(e1);
			
			ArrayList<Integer> e2 = new ArrayList<>();
			e2.add(u);
			e2.add(weight);
			adj.get(ver).add(e2);
		}
		
		return adj;
	}

}
