class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        
        inorderTraversal(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

public class Day96_LC_0099 {
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        
        System.out.println("Before recovery (In-order):");
        printInorder(root);
        
        Solution solution = new Solution();
        solution.recoverTree(root);
        
        System.out.println("\nAfter recovery (In-order):");
        printInorder(root);
    }
}