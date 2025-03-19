import java.util.*;

class TreeNode {
    char val;
    TreeNode left, right;

    public TreeNode(char val) {
        this.val = val;
        left = right = null;
    }
}

public class vertical {
    public static List<Character> verticalView(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Character>> verticalMap = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        nodeQueue.offer(root);
        hdQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int hd = hdQueue.poll();

            verticalMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.val);
            
            if (node.left != null) {
                nodeQueue.offer(node.left);
                hdQueue.offer(hd - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                hdQueue.offer(hd + 1);
            }
        }
        
        for (List<Character> values : verticalMap.values()) {
            result.addAll(values);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.right.left = new TreeNode('E');
        root.right.right = new TreeNode('F');

        List<Character> verticalViewResult = verticalView(root);

        System.out.print("Vertical View: ");
        for (char node : verticalViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
