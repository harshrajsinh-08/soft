import java.util.*;
public class maxproduct {
    static int maxprod(int[] arr){
        int n=arr.length;
        int suffix=1,prefix=1,ans=1;
        for(int i=0;i<n;i++){
            if(prefix ==0){prefix=1;}
            if(suffix==0){suffix=1;}
            prefix=prefix*arr[i];
            suffix=suffix*arr[n-i-1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {-1,2,-2,4,3,2,-1};
        System.out.println(maxprod(arr));

    }
}
