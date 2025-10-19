public class bipartite {
    public static void main(String[] args) {
    }
	public boolean isBipartite(int[][] graph) {
		Queue<BipartitePair> q=new LinkedList<>();
		HashMap<Integer,Integer> visited=new HashMap<>();
		for(int i=0;i<graph.length;i++) {
			if(visited.containsKey(i)) {
				continue;
            }
			
			q.add(new BipartitePair(i,0));
			}
		}
	}
	
	class BipartitePair{
		int vtx;
		int dis;
		public BipartitePair(int vtx,int dis) {
			this.vtx=vtx;
			this.dis=dis;
		}
	}

}
    
    

