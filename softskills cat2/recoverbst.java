class TreeNode{
    int val;
    TreeNode left;
    TreeNode right; 
    TreeNode(int x){
        val = x;
    }
}

public class recoverbst {
    TreeNode firstIncorrectNode = null;
    TreeNode secondIncorrectNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (firstIncorrectNode == null && prevNode.val >= node.val) {
            firstIncorrectNode = prevNode;
        }
        if (firstIncorrectNode != null && prevNode.val >= node.val) {
            secondIncorrectNode = node;
        }
        prevNode = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverbst solution = new recoverbst();
        solution.recoverTree(root);
        System.out.println("Inorder Traversal of Recovered BST:");
        printInorder(root);
    }

    private static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}