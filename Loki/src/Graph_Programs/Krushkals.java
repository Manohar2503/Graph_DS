package Graph_Programs;
import java.util.*;

class Edge implements Comparable<Edge>{
	int src, des,  wei;
	Edge(int src, int des, int wei){
		this.src=src;
		this.des= des;
		this.wei= wei;
	}
	
	public int compareTo(Edge compareEdge){
		return this.wei - compareEdge.wei;
	}
}

public class Krushkals {

	static int spanningTreeSum(int v, int[][] graph) {
		List<Edge> edge = new ArrayList<>();
		
		for(int[] arr:graph) {
			int weight = arr[2];
			int adjnode = arr[1];
			int node = arr[0];
			Edge newedge = new Edge(node,adjnode,weight);
			edge.add(newedge);
		}
		Joint ds = new Joint(v);
		Collections.sort(edge);
		int sum =0;
		
		for(int i=0;i<edge.size();i++) {
			if(ds.findUparent(edge.get(i).src) != ds.findUparent(edge.get(i).des)){
				sum +=edge.get(i).wei;
				ds.unionByRank(edge.get(i).src, edge.get(i).des);
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		int v = 8;
		int[][] graphnodes = {
				{1,1,4},
				{2,1,2},
				{3,2,3},
				{3,2,4},
				{4,1,5},
				{5,3,4},
				{7,2,6},
				{8,3,6},
				{1,4,5},
		};
		int sum = spanningTreeSum(v,graphnodes);
		System.out.println("minimum sum :"+sum);

	}

}
