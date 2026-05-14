package Graph_Programs;
import java.util.*;
public class Khans_Algo {
	// Topological Sort
	//it is not possible for cyclic or undirected graphs.Only for DAG
	//Topological Sorted order: It is a linear ordering of vertices such that for every directed edge u -> v, 
	//vertex u comes before v in the ordering.
	
	public static void main(String[] args) {
		int v = 6;
		
		//cylic - [[1], [2, 5], [3], [4], [1], []]
		int[][] edges = {
				{0,1},
				{1,2},
				{2,3},
		        {5,2},
				{4,5},
				{5,1},
				};
/*
 * 						0 - 1 - 2 -3 
 * 							 \	/
 * 						 4  -  5
 * 
 * 		
 * 
 */
		
		
/*
  				4 -	3				  
  				|	  |
 			0 -> 1 -> 2   
 			   /
 			  5			  
 			  	int[][] edges = {
				{0,1},
				{1,2},
				{1,5},
				{2,3},
				{3,4},
				{4,1},
				};
  */
 	
		int[] result = topologicalSort(v,edges);
		for(int i:result) {
			System.out.print(i +"->");
		}

	}
	static List<Integer>[] constructadj(int v, int[][]  edges){
		
		List<Integer>[] list = new ArrayList[v];
		for(int i=0;i<v;i++) {
			list[i] = new ArrayList<>();
		}
		for(int[] edge:edges) {
			list[edge[0]].add(edge[1]);
		}
		return list;
	}
	
	static int[] topologicalSort(int v, int[][] edges) {
		List<Integer>[] adj = constructadj(v,edges);
		int[] indegree = new int[v];
		
		for(int i=0;i<v;i++) {
			for(int neighbour: adj[i]) {
				indegree[neighbour]++;
			}
		}
		
		int[] result = new int[v];
		
		int val=0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			result[val++] = node;
			
			for(int neighbour : adj[node]) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.offer(neighbour);
				}
			}
		}
		
		return result;
	}
}
