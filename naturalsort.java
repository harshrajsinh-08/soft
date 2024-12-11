import java.util.*;

public class naturalsort {
    public static void main(String[] args) {
        String[] files = { "text1.txt", "text10.txt", "text3.txt" };

        Arrays.sort(files, (a, b) -> {
            String[] partsA = a.split("\\D+");
            String[] partsB = b.split("\\D+");

            int numA = Integer.parseInt(partsA[1]); // Extract numeric part
            int numB = Integer.parseInt(partsB[1]);

            return Integer.compare(numA, numB); // Compare numeric parts
        });

        System.out.println(Arrays.toString(files));
    }
}