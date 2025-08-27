import java.util.ArrayList;

public class hashmap{
    //put/get/remove/contains key
public class HashMap<K,V>{
    class Node{
        K key;
        V value;
        Node next;
        
    }
    private int size=0;
    ArrayList<Node> bucket=new ArrayList<>();
    public HashMap(){
        this(4);

    }
    public HashMap(int n){
        for(int i=0;i<n;i++){
            bucket.add(null);
        }

    }
    public V remove(K key){
        int idx=hashfunc(key);
        Node curr=bucket.get(idx);
        Node prev=null;
        while(curr!=null){
            if(curr.key.equals(key)){
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            return null;
        }
        else if(prev==null){
            bucket.set(idx,curr.next);
        }
        else{
            prev.next=curr.next;
        }
        curr.next=null;
        size--;
        return curr.value;
        
    }
    public V get (K key){
        int idx=hashfunc(key);
        Node temp=bucket.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp=temp.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int idx=hashfunc(key);
        Node temp=bucket.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public void put(K key,V value){
        int idx=hashfunc(key);
        Node temp=bucket.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value=value;
                return;
            }
            temp=temp.next;
        }
        Node nn=new Node();
        nn.key=key;
        nn.value=value;
        temp=bucket.get(idx);
        nn.next=temp;
        bucket.set(idx,nn);
        size++;    
    }
    private void reshashing(){
        ArrayList<Node> new_buckt =new ArrayList<>();
        for(int i=0;i<2*bucket.size();i++){
            new_buckt.add(null);
        }
        ArrayList<Node> oba=bucket;
        bucket=new_buckt;
        size=0;
        for(Node nn:oba){
            while(nn!=null){
                put(nn.key,nn.value);
                nn=nn.next;
            }
        }
    }
    @Override
    public String toString(){
        String s="{";
        for(Node nn:bucket){
            while(nn!=null){
                s=s+nn.key+"="+nn.value+",";
                nn=nn.next;            
            }
        }
        return s+"}";

    }
    public int hashfunc(K key){
        int idx=key.hashCode()%bucket.size();
        if(idx<0){
            idx+=bucket.size();

        }
        return idx;

    }

}
    public void main(String[] args) {
        HashMap<String,Integer> kmap=new HashMap<>();
        
    }
    
}
