import java.util.Stack;
// public class stackperm {
//     public static boolean isStackPermutation(int[] original, int[] target) {
//         Stack<Integer> stack = new Stack<>();
//         int i = 0;

//         for (int element : original) {
//             stack.push(element);
//             while (!stack.isEmpty() && stack.peek() == target[i]) {
//                 stack.pop();
//                 i++;
//             }
//         }
//         return stack.isEmpty();
//     }

//     public static void main(String[] args) {
//         int[] original = {1, 2, 3};
//         int[] target = {2, 1, 3};

//         boolean result = isStackPermutation(original, target);
//         System.out.println("Is it a stack permutation? " + result);
//     }
// }


public class stackoperm{
    public static boolean isperm(int[] orig,int[]target){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int elem:orig){
            stack.push(elem);
            while(!stack.isEmpty() && stack.peek() == target[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        int[] orig = {1,2,3};
        int[] target = {2,1,3};
        boolean res = isperm(orig,target);
        System.out.println("Is it a stack permutation? "+res);
    }
}