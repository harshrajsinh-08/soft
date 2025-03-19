import java.util.*;

class TreeNode {
    char val;
    TreeNode left, right;

    public TreeNode(char val) {
        this.val = val;
        left = right = null;
    }
}

public class left {
    public static List<Character> leftView(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.right.left = new TreeNode('F');
        root.right.right = new TreeNode('G');

        List<Character> leftViewResult = leftView(root);

        System.out.print("Left View: ");
        for (char node : leftViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}