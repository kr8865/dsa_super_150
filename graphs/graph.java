import java.util.HashMap;

public class graph {
   
    private HashMap<Integer ,HashMap<Integer,Integer>> map;
    public graph(int v){
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

    
    public  void main(String[] args) {
        graph g=new graph(7);
        g.AddEdge(1,4,2);
        g.AddEdge(1,4,2);
        g.AddEdge(1,4,2);
        g.AddEdge(1,4,2);
        g.AddEdge(1,4,2);

        
    }
    
}
