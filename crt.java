import java.util.*;

public class crt {
    static int crrt(int[]nums,int[]rems){
        int max=1;
        for(int num:nums){max*=num;}
        for(int x=0;x<max;x++){
            boolean valid=true;
            for(int i=0;i<nums.length;i++){
                if(x%nums[i] != rems[i]){
                    valid = false;
                    break;
                }
            }
            if(valid){return x;}
        }
        return -1;
    }
    // static int bruteForceCRT(int[] nums, int[] rems) {
    //     int max = 1;
    //     for (int num : nums) max *= num;
    //     for (int x = 0; x < max; x++) {
    //         boolean valid = true;
    //         // Check if x satisfies all congruences
    //         for (int i = 0; i < nums.length; i++) {
    //             if (x % nums[i] != rems[i]) {
    //                 valid = false;
    //                 break;
    //             }
    //         }
    //         if (valid) return x;  // Return the first valid x
    //     }
    //     return -1;  // No solution found
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of congruences: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];  // Moduli
        int[] rems = new int[n];  // Remainders
        
        System.out.println("Enter the moduli:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.println("Enter the remainders:");
        for (int i = 0; i < n; i++) {
            rems[i] = sc.nextInt();
        }

        int result = crrt(nums, rems);
        
        if (result != -1) {
            System.out.println("The solution to the system of congruences is: " + result);
        } else {
            System.out.println("No solution found.");
        }
    }
}