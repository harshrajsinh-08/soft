import java.util.Scanner;
public class flip1 {
    private static int findMaxConsecutiveOnes(int[] a, int k) {
        int maxOnes = 0;

        for(int start = 0;start<a.length;start++){
            for(int end=start;end<a.length;end++){
                int nr=0;
                for(int i=start;i<=end;i++){
                    if(a[i]==0){
                        nr++;
                    }
                }
                if(nr<=k){
                    maxOnes=Math.max(maxOnes,end-start+1);
                }
            }
            
        }
        // Brute-force: check all subarrays
        for (int start = 0; start < a.length; start++) {
            for (int end = start; end < a.length; end++) {
                // Count how many 0's in the current subarray (start, end)
                int numReplacements = 0;
                for (int i = start; i <= end; i++) {
                    if (a[i] == 0) {
                        numReplacements++;
                    }
                }
                
                // If replacements are within the allowed limit, calculate the length of this subarray
                if (numReplacements <= k) {
                    maxOnes = Math.max(maxOnes, end - start + 1);
                }
            }
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,0,0,0,1};
        int k = 2;
        int result = findMaxConsecutiveOnes(a, k);
        System.out.print(result);
    }
}
