import java.util.*;

class TreeNode {
    char val;
    TreeNode left, right;

    public TreeNode(char val) {
        this.val = val;
        left = right = null;
    }
}

public class horizontal {
    public static List<Character> horizontalView(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
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

        List<Character> horizontalViewResult = horizontalView(root);

        System.out.print("Horizontal View: ");
        for (char node : horizontalViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}