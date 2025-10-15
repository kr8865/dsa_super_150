import java.util.HashMap;

public class max_summ {
    public static void main(String[] args) {
        //Input: [1, 2, -3, 3, -1, 2, -2]
        int[] arr={-1,-2,-3,-4,-5};
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxlen=i+1;
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

        }

    }
    
}
