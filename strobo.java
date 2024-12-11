// import java.util.*;

// public class strobo {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number");
//         String n = sc.nextLine();

//         // Check if the number has only one digit
//         if (n.length() == 1) {
//             if (n.equals("0") || n.equals("1") || n.equals("8")) {
//                 System.out.println("Strobogrammatic");
//             } else {
//                 System.out.println("Not Strobogrammatic");
//             }
//         } else {
//             int l = 0;
//             int r = n.length() - 1;
//             while (l <= r) {
//                 // Check valid strobogrammatic pairs
//                 if ((n.charAt(l) == '0' && n.charAt(r) == '0') ||
//                     (n.charAt(l) == '1' && n.charAt(r) == '1') ||
//                     (n.charAt(l) == '8' && n.charAt(r) == '8') ||
//                     (n.charAt(l) == '6' && n.charAt(r) == '9') ||
//                     (n.charAt(l) == '9' && n.charAt(r) == '6')) {
//                     l++;
//                     r--;
//                 } else {
//                     System.out.println("Not Strobogrammatic");
//                     return; 
//                 }
//             }
//             System.out.println("Strobogrammatic");
//         }
//     }
// }


// import java.util.Scanner;
// public class strobo{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.println("Enter a number");
//         int n=sc.nextInt();
//         String num = String.valueOf(n);
//         StringBuilder sb = new StringBuilder(num);
//         sb.reverse();
//         String rev = sb.toString();
//         if(num.equals(rev)){
//             System.out.println("Strobogrammatic");
//         }
//         else{
//             System.out.println("Not Strobogrammatic");
//         }
//     }
// }

import java.util.Scanner;
public class strobo{
    
    // Function to check if a given number is strobogrammatic
    public static boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            char left = num.charAt(l);
            char right = num.charAt(r);
            // Check if the pair of characters is strobogrammatic
            if ((left == '0' && right == '0') || 
                (left == '1' && right == '1') ||
                (left == '6' && right == '9') ||
                (left == '8' && right == '8') ||
                (left == '9' && right == '6')) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    // Function to generate all possible strobogrammatic numbers of length n
    public static void generateStrobogrammaticNumbers(int n) {
        // All valid digits for strobogrammatic numbers
        char[] digits = {'0', '1', '6', '8', '9'};
        
        // Generate all possible numbers of length n
        int totalNumbers = (int) Math.pow(digits.length, n); // Total combinations
        for (int i = 0; i < totalNumbers; i++) {
            StringBuilder num = new StringBuilder();
            int temp = i;
            // Construct the number by selecting digits
            for (int j = 0; j < n; j++) {
                num.insert(0, digits[temp % digits.length]);
                temp /= digits.length;
            }
            String numStr = num.toString();
            // Check if the generated number is strobogrammatic
            if (isStrobogrammatic(numStr)) {
                System.out.println(numStr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the strobogrammatic numbers:");
        int n = sc.nextInt();

        System.out.println("Strobogrammatic numbers of length " + n + ":");
        generateStrobogrammaticNumbers(n);
    }
}