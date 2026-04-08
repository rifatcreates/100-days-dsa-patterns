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
    int preorderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        
        TreeNode root = new TreeNode(rootValue);
        
        int inorderIndex = findInorderIndex(inorder, inorderStart, inorderEnd, rootValue);
        
        root.left = helper(preorder, inorder, inorderStart, inorderIndex - 1);
        root.right = helper(preorder, inorder, inorderIndex + 1, inorderEnd);
        
        return root;
    }
    
    private int findInorderIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

public class Day97_LC_0105 {
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    
    private static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        
        System.out.println("Built tree Inorder traversal:");
        printInorder(root);
        
        System.out.println("\nBuilt tree Preorder traversal:");
        printPreorder(root);
    }
}