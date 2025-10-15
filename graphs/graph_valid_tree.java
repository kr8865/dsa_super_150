import java.util.ArrayList;
import java.util.HashMap;

public class graph_valid_tree {
    public static void main(String[] args) {
        
    }
    public boolean validTree(int n,int[][] edges){
        HashMap<Integer ,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            map.get(v1).add(v2);
            


        }
    }
    
}
