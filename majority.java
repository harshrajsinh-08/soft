import java.util.Arrays;
import java.util.Scanner;
public class majority{
    public static int maj(int[] v){
        int n=v.length;
        int el=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                el=v[i];
            }
            else if(v[i] == el){
                count++;
            }
            else{
                count--;
            }
        }
        int cnt1 =0;
        for(int i=0;i<n;i++){
            if(v[i]==el){
                cnt1++;
            }
        }
        if(cnt1>(n/2)){
            return el;
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] arr = {2, 1, 1, 1, 1, 2, 2};
        Arrays.sort(arr);
        int n=arr.length /2;
        System.out.println("ans is : "+ arr[n]);
        int ans = maj(arr);
        System.out.println("The majority element is: " + ans);
    }

}