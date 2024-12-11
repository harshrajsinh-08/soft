import java.util.*;
public class maxsumhourglass {
    static int row = 5;
    static int col = 5;
    static int findmax(int[][] mat){
        if(row<3||col<3){
            System.out.println("Not possible to calculate hourglass sum.");
            return Integer.MIN_VALUE;
        }
        int maxsum = -10000;
        for(int i=0;i<row-2;i++){
            for(int j=0;j<col-2;j++){
                int sum = mat[i][j]+mat[i][j+1]+mat[i][j+2]+mat[i+1][j+1]+mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
                maxsum = Math.max(maxsum,sum);
            }
        }
        return maxsum;
    }
    public static void main(String[] args) {
        // Input matrix
        int[][] mat = {
            {1, 2, 3, 0, 0},
            {0, 5, 0, 0, 0},
            {2, 1, 4, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0}
        };
        int result = findmax(mat);
        System.out.println("Maximum sum of hourglass = " + result);
        int num = 9;
        System.out.printf("%2b",num);
    }
}
