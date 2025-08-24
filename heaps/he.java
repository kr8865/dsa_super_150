import java.util.*;
public class he {
    private static ArrayList<Integer> ll=new ArrayList<>();
    public static void add(int item){
        ll.add(item);
        upheapify(ll.size()-1);

    }
    private static void upheapify(int ci){
        int pi=(ci-1)/2;
        if(ll.get(pi)>ll.get(ci)){
            swap(pi,ci);
            upheapify(pi);
            
        }
    }
    public int remove(){
        swap(0,ll.size()-1);
        int val=ll.remove(ll.size()-1);
        downheapif(0);
        return val;
    }

    
    private void downheapif(int pi) {
        // TODO Auto-generated method stub
        int lci=2*pi+1;
        int rci=2*pi+2;
        int mini=pi;

        if(lci<ll.size() && ll.get(pi)>ll.get(lci)){
            mini=lci;

        }
        if(rci<ll.size() && ll.get(mini)>ll.get(rci)){
            mini=rci;
        }
        if(mini!=pi){
            swap(mini,pi);
            downheapif(mini);
        }
        
    }
    private static void swap(int pi, int ci) {
        // TODO Auto-generated method stub
        int a=ll.get(pi);
        int b=ll.get(ci);
        ll.set(pi,b);
        ll.set(ci,a);
    }
    public int  get(){
        return ll.get(0);
    }
    public int size(){
        return ll.size();
    }
    public void display(){
        System.out.println(ll);
    }
    public static void main(String[] args) {
        he hp=new he();
        hp.add(5);
        hp.add(7);
        hp.add(9);
        hp.add(4);
        hp.add(2);
        hp.add(3);
        hp.add(1);
        hp.display();
        //bydefault min heap

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());//max heap
        pq.add(5);
        pq.add(7);
        pq.add(9);
        pq.add(4);
        pq.add(2);
        pq.add(3);
        pq.add(1);
        System.out.println(pq);






        
    }
}

    

