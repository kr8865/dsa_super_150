import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topo {
    public static class Cycle_In_Graph {
        private HashMap<Integer, List<Integer> >map;
	
	public Cycle_In_Graph(int v) {
		map = new HashMap<>();
		for(int i = 0; i< v; i++) {
			map.put(i, new ArrayList<>());
		}
		
	}
	
	public void AddEdge(int v1, int v2) {
		map.get(v1).add(v2);
		
	}
	
	public int[] indegree() {
		int[] in = new int[map.size()];
		for(int v1 : map.keySet()) {
			for(int v2: map.get(v1)) {
				in[v2]++;
			}
		}
		return in;
	}
	
	public boolean isCycle() {
		Queue<Integer> q = new LinkedList<>();
		int[] in = indegree();
		for(int i = 0; i < in.length; i++) {
			if(in[i] == 0) {
				q.add(i);
			}
		}
		int c = 0;
		while(!q.isEmpty()) {
			int r = q.poll();
			c++;
			for(int nbrs: map.get(r)) {
				in[nbrs]--;
				if(in[nbrs] == 0) {
					q.add(nbrs);
				}
			}
		}
		return c!=map.size();		
	}
}
	public static void main(String[] args) {
		Cycle_In_Graph ts = new Cycle_In_Graph(8);
		ts.AddEdge(1,2);
		ts.AddEdge(1,0);
		ts.AddEdge(1,4);
		ts.AddEdge(4,3);
		ts.AddEdge(3,2);
		ts.AddEdge(4,5);
		ts.AddEdge(5,7);
		ts.AddEdge(6,3);
		ts.AddEdge(6,7);
		System.out.println(ts.isCycle());
  
        
}
}