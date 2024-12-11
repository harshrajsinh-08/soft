import java.util.*;
public class leader {
    public static ArrayList<Integer> leaders(int[]arr,int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int maxfromright = arr[n-1];
        ans.add(maxfromright);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxfromright){
                ans.add(arr[i]);
                maxfromright=arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;

    }

    public static void main(String[] args) {
        int n = 6;
        int arr[] = {2, 4, 6, 3, 1, 2};
        ArrayList<Integer> ans = leaders(arr, n);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
