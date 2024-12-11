import java.util.*;

class alice {

    // Function to calculate minimum apples needed
    static int minApples(int M, int K, int N, int S, int W, int E) {
        // If apples to collect are less than or equal to the apples from south trees
        if (M <= S * K)
            return M;

        // If apples to collect are more than south apples but can be collected with additional apples from west and east
        else if (M <= S * K + E + W)
            return S * K + (M - S * K); // Apples collected from south trees + the remaining from west/east trees
        
        // If the number of apples to be collected is greater than the total apples available
        else
            return -1; // Not enough apples to collect
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter no of apples to be collected-");
        int M = sc.nextInt();
        System.out.print("Enter no of apples in each tree-");
        int K = sc.nextInt();
        System.out.print("Enter no of trees in north-");
        int N = sc.nextInt();
        System.out.print("Enter no of trees in south-");
        int S = sc.nextInt();
        System.out.print("Enter no of trees in west-");
        int W = sc.nextInt();
        System.out.print("Enter no of trees in east-");
        int E = sc.nextInt();

        // Calculate the minimum apples needed
        int ans = minApples(M, K, N, S, W, E);

        // Output the result
        System.out.println(ans);
    }
}