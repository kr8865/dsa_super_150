import java.util.*;

public class grap {
     private static HashMap<Integer ,HashMap<Integer,Integer>> map;
    public void graph(int v){
        map=new HashMap<>();
        for(int i=1;i<=v;i++){
            map.put(i,new HashMap<>());
        }
    }
    public void AddEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public boolean ContainsEdge(int v1,int v2){
        return map.get(v1).containsKey(v2);
    }
    public int noofEdge() {  //total no of edges
		int sum=0;
		for(int vtx:map.keySet()) {
			sum=sum+map.get(vtx).size();
		}
		return sum/2;
	}
	public void removeEdge(int v1,int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	public void removeVertex(int v1) {
		for(int nbrs:map.get(v1).keySet()) {
			map.get(nbrs).remove(v1);
		}
		map.remove(v1);
	}
	public void Display() {
		for(int v:map.keySet()) {
			System.out.println(v+" "+map.get(v));
		}
	}
	public boolean HasPath(int src,int des) {
		if(src==des) {
			return true;
		}
		for(int nbrs:map.get(src).keySet()) {
			boolean ans=HasPath(nbrs,des);
			if(ans) {
				return ans;
			}
		}
		return false;
    }

    public static void main(String[] args) {

        
    }
    public boolean BFS(int src,int des){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            //1.remove
            int r=q.poll();

            //2.ignore if already visited
            if(visited.contains(r)){
                continue;
            }
            //3.mark visited
            visited.add(r);
            //4.self work
            if(r==des){
                return true;
            }
            //5.add unvisited nbrs
            for(int nbrs:map.get(r).keySet()){
                if(!visited.contains(nbrs)){
                    visited.add(nbrs);
                }

            }

        }
        return false;

    }
    public static boolean DFS(int src,int des){
        Stack<Integer> st=new Stack<>();
        HashSet<Integer> visited=new HashSet<>();
        st.push(src);
        while(!st.isEmpty()){
            int r=st.pop();
            if(visited.contains(r)){
                continue;
            }
            visited.add(r);
            if(r==des){
                return true;
            }
            for(int nbrs:map.get(r).keySet()){
                if(!visited.contains(nbrs)){
                    visited.add(nbrs);
                }
            }
        }
        return false;
    }
    public void BFT() {
		Queue<Integer> q=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		for(int src:map.keySet()) {
			if(visited.contains(src)) {
				continue;
			}
			q.add(src);
			while(!q.isEmpty()) {
				// 1. remove
				int r=q.poll();
				// 2. Ignore if already visited
				if(visited.contains(r)) {
					continue;
				}
				// 3. Marked Visited
				visited.add(r);
				// 4. self work
				System.out.println(r+" ");
				// 5. Add unvisited nbrs
				for(int nbrs:map.get(r).keySet()) {
					if(!visited.contains(nbrs)) {
						q.add(nbrs);
					}	
				}	
			}
		}
	}
	public void DFT() {
		Stack<Integer> st=new Stack<>();
		HashSet<Integer> visited=new HashSet<>();
		for(int src:map.keySet()) {
			if(visited.contains(src)) {
				continue;
			}
			st.push(src);
			while(!st.isEmpty()) {
				// 1. remove
				int r=st.pop();
				// 2. Ignore if already visited
				if(visited.contains(r)) {
					continue;
				}
				// 3. Marked visited
				visited.add(r);
				// 4.self work
				System.out.println(r+" ");
				// 5. Add unvisited nbrs
				for(int nbrs:map.get(r).keySet()) {
					if(!visited.contains(nbrs)) {
						st.push(nbrs);
					}
				}
			}
		}
	}
    
}//bfs gurantees shortest path that is the diff between bfs and dfs 

