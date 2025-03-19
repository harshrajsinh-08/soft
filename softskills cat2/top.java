import java.util.*;

class TreeNode {
    char val;
    TreeNode left, right;

    public TreeNode(char val) {
        this.val = val;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int hd;

    public Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class top {
    public static List<Character> topView(TreeNode root) {
        List<Character> topView = new ArrayList<>();
        if (root == null) return topView;

        Map<Integer, Character> verticalMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            verticalMap.putIfAbsent(hd, node.val);
            if (node.left != null) queue.offer(new Pair(node.left, hd - 1));
            if (node.right != null) queue.offer(new Pair(node.right, hd + 1));
        }

        topView.addAll(verticalMap.values());
        return topView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.right.left = new TreeNode('E');
        root.right.right = new TreeNode('F');

        List<Character> topViewResult = topView(root);
        System.out.print("Top View: ");
        for (char node : topViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}