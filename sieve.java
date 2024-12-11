import java.util.*;
public class sieve {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();

        if (num < 2) {
            System.out.println("No prime numbers less than 2.");
            return;
        }
        boolean[] bool = new boolean[num + 1];
        Arrays.fill(bool, true);
        for (int i = 2; i * i <= num; i++) {
            if (bool[i]) {
                for (int j = i * i; j <= num; j += i) { // Ensure we stay within bounds
                    bool[j] = false;
                }
            }
        }
        int count=0;
        System.out.println("List of prime numbers up to the given number are: ");
        for(int i=100;i<=200;i++){
            if(bool[i]){
                count++;
            }
        }
        System.out.println(count);

        // System.out.println("Twin primes are : ");
        // for(int i=2;i<=num;i++){
        //     if(bool[i]&&bool[i+2]){
        //         System.out.println(i+" "+(i+2));
        //     }
        // }
    }
}
