import java.io.*;
public class josephuss {
    static int josephus(int n, int k) {
        // Base case: If there's only one person, they are the survivor
        if(n==1){
            return 1;
        }
        else{
            return (josephus(n-1,k)+k-1)%n+1;
        }
    }

    public static void main(String[] args) {
        // Number of people and the step value (every k-th person is eliminated)
        int n = 25;  // Total number of people
        int k = 5;   // Every 2nd person is eliminated
        
        // Call the josephus method and print the result
        System.out.println("The position of the last remaining person is: " + josephus(n, k));
    }
}
