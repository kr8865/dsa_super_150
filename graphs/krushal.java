import java.util.HashMap;

public class krushal {
    class Node{
        Node par;
        int val;
        int rank;
       
    }
    class DisjoinSet{

    }
    private HashMap<Integer,Node> map=new HashMap<>();
    public void create(int v){
        Node n=new Node();
        n.val=v;
        n.rank=0;
        n.par=n;
        map.put(v,n);

    }
    public int find(int v){
        Node node =map.get(v);
        return find(node).val;
    }
    public Node find(Node node){
        if(node.par==node){
            return node;
        }
        Node n=find(node.par);
        return n;

    }
    public static void main(String[] args) {
        
    }
    
}
