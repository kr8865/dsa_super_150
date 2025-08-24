import java.util.Arrays;
import java.util.PriorityQueue;

public class meeting_room {
    public static int  main(String[] args) {
        int k=2;
        int w=0;
        int[] profits={1,2,3};
        int[] capital={0,1,1};
        int[][] arr=new int[profits.length][2];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];

        }
        return ipo(arr,k,w);
        
       

    }
    public static int ipo(int[][] arr, int k ,int w){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<int[] >pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<arr.length;){
            while(w>=arr[i][0]){
                pq.add(arr[i]);
                i++;
            }
        
        if(pq.isEmpty() || k==0){
            return w;
        }
        w+=pq.poll()[1];
        k--;

        return -1;
    }
    
    while(!pq.isEmpty() && k>0){
        w+=pq.poll()[1];
        k--;
    }
    return w;

}
}


