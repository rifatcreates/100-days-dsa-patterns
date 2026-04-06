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
    boolean ans = true;
    TreeNode prev = null;

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (prev == null) {
            prev = root;
        } else {
            if (root.val <= prev.val) {
                ans = false;
            }
            prev = root;
        }

        helper(root.right);
    } 

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return ans;
    }
}

public class Day95_LC_0098 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean result = solution.isValidBST(root);
        
        System.out.println(result);
    }
}