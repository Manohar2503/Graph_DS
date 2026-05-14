package Graph_Programs;
import java.util.*;

// which is used mainly finding the cycle in the UDG
// used to find  
// used to get the vertices is connected or not 

 class Joint{
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();
	Joint(int n){
		for(int i=0;i<=n;i++) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}
	
	public int findUparent(int node) {
		if(node == parent.get(node)) return node;
		int curr= findUparent(parent.get(node));
		parent.set(node,curr);
		return  parent.get(node);
	}
	
	public void unionByRank(int u, int v) {
		int ulp_u = findUparent(u);
		int ulp_v = findUparent(v);
		if(ulp_u==ulp_v) return ; // cycle detected 
		if(rank.get(ulp_u) < rank.get(ulp_v)){
			parent.set(ulp_u, ulp_v);
		}
		else if(rank.get(ulp_v) < rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		}
		else {
			parent.set(ulp_u, ulp_v);
			int temp = rank.get(ulp_v);
			rank.set(ulp_v, temp+1);
		}
	}
	
	public void unionBySize(int u, int v) {
		int ulp_u = findUparent(u);
		int ulp_v = findUparent(v);
		if(ulp_u==ulp_v) return ;
		if(size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
		}
		else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}


public class DisjointMain {

	public static void main(String[] args) {
		Joint ds = new Joint(7);
		ds.unionByRank(0,1);
		ds.unionByRank(0,2);
		ds.unionByRank(0,3);
		ds.unionByRank(1,0);
		ds.unionByRank(1,2);
		ds.unionByRank(2,0);
		ds.unionByRank(2,1);
		ds.unionByRank(2,3);
		ds.unionByRank(3,0);
		ds.unionByRank(3,2);
		
		if(ds.findUparent(1) == ds.findUparent(7)) {
			System.out.println("same");
		}
		else {
		System.out.println("not same");
		}
		ds.unionBySize(1, 7);
		
		if(ds.findUparent(1) == ds.findUparent(7)) {
			System.out.println("same");
		}
		else {
			
		System.out.println("not same");
		}
	}
}
